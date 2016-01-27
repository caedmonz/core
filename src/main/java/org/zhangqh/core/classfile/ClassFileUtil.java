package org.zhangqh.core.classfile;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

/*
 * Utility Methods for analyzing the compile file of java.
 * 
 * <p>Parse the bytes of class file(file ended with '.class') to a struct
 * ClassFile which has elements defined in <<Java Virtual Machine
 * Specification(Java SE 7)>>
 * 
 * @author ZhangQinghua
 * 
 * @version 1.0
 * 
 * @since 2016.01.24
 */
public class ClassFileUtil {

    private String fileName;

    private DataInputStream dataInput;

    private ClassFile classFile;

    public ClassFileUtil(String fileName) throws IOException {

        this.fileName = fileName;

        if (null == fileName || "".equals(fileName.trim())) {
            throw new IllegalArgumentException("File name is empty");
        }

        if (!fileName.endsWith(".class")) {
            throw new IllegalArgumentException("ClassFileParser can only parse file with prefix '.class'");
        }

        InputStream is = new FileInputStream(fileName);
        dataInput = new DataInputStream(is);

        classFile = new ClassFile();

        parse();

        dataInput.close();
    }

    /*
     * Get the ClassFile after parsing class file.
     * 
     * @return the ClassFile struct
     */
    public ClassFile getClassFile() {
        return classFile;
    }

    private void parse() throws IOException {
        this.checkMagic();
        this.checkVersion();
        this.getConstant_Pool();
        this.getAccess_Flags();
        this.getThis_Class();
        this.getSuper_Class();
        this.getInterfaces_Info();
        this.getFields_Info();
        this.getMethods_Info();
        this.getAttributes_Info();
    }

    private void checkMagic() throws IOException {
        int magic = dataInput.readInt();
        if (magic != ClassFile.MAGIC) {
            throw new InvalidClassException("[magic number is wrong] " + fileName + " is an illegal class file");
        }
    }

    private void checkVersion() throws IOException {
        int minor_version = dataInput.readUnsignedShort();
        int major_version = dataInput.readUnsignedShort();
        if (major_version < 0 || minor_version < 0) {
            throw new InvalidClassException(
                    "[Version is " + major_version + "." + minor_version + "] Version should be x.y (x,y>0)");
        }
        classFile.setMinor_version(minor_version);
        classFile.setMajor_version(major_version);
    }

    private void getConstant_Pool() throws IOException {
        int const_pool_count = dataInput.readUnsignedShort();
        classFile.setConst_pool_count(const_pool_count);
        Cp_InfoUtil cpInfoUtil = new Cp_InfoUtil(dataInput);
        List<Cp_Info> const_pool = new ArrayList<Cp_Info>();
        for (int i = 1; i < const_pool_count; i++) {
            Cp_Info cpInfo = cpInfoUtil.getCpInfo();
            const_pool.add(cpInfo);
        }
        classFile.setConst_pool(const_pool);
    }

    private void getAccess_Flags() throws IOException {
        int access_flags = dataInput.readUnsignedShort();
        classFile.setAccess_flags(access_flags);
    }

    private void getThis_Class() throws IOException {
        int this_class = dataInput.readUnsignedShort();
        classFile.setThis_class(this_class);
    }

    private void getSuper_Class() throws IOException {
        int super_class = dataInput.readUnsignedShort();
        classFile.setSuper_class(super_class);
        ;
    }

    private void getInterfaces_Info() throws IOException {
        int interfaces_count = dataInput.readUnsignedShort();
        classFile.setInterfaces_count(interfaces_count);
        List<Integer> interfaces = new ArrayList<Integer>();
        for (int i = 0; i < interfaces_count; i++) {
            int interfaceInfo = dataInput.readUnsignedShort();
            interfaces.add(interfaceInfo);
        }
        classFile.setInterfaces(interfaces);
    }

    private void getFields_Info() throws IOException {
        int fields_count = dataInput.readUnsignedShort();
        classFile.setFields_count(fields_count);
        List<Field_Info> fields = new ArrayList<Field_Info>();
        for (int i = 0; i < fields_count; i++) {
            Field_Info fieldInfo = new Field_Info();
            int access_flags = dataInput.readUnsignedShort();
            int name_index = dataInput.readUnsignedShort();
            int descriptor_index = dataInput.readUnsignedShort();
            int attributes_count = dataInput.readUnsignedShort();
            fieldInfo.setAccess_flags(access_flags);
            fieldInfo.setName_index(name_index);
            fieldInfo.setDescriptor_index(descriptor_index);
            fieldInfo.setAttributes_count(attributes_count);
            List<Attribute_Info> attributes = this.getAttributeList(attributes_count);
            fieldInfo.setAttributes(attributes);
            fields.add(fieldInfo);
        }
        classFile.setFields(fields);
    }

    private void getMethods_Info() throws IOException {
        int methods_count = dataInput.readUnsignedShort();
        classFile.setMethods_count(methods_count);
        List<Method_Info> methods = new ArrayList<Method_Info>();
        for (int i = 0; i < methods_count; i++) {
            Method_Info methodInfo = new Method_Info();
            int access_flags = dataInput.readUnsignedShort();
            int name_index = dataInput.readUnsignedShort();
            int descriptor_index = dataInput.readUnsignedShort();
            int attributes_count = dataInput.readUnsignedShort();
            methodInfo.setAccess_flags(access_flags);
            methodInfo.setName_index(name_index);
            methodInfo.setDescriptor_index(descriptor_index);
            methodInfo.setAttributes_count(attributes_count);
            List<Attribute_Info> attributes = this.getAttributeList(attributes_count);
            methodInfo.setAttributes(attributes);
            methods.add(methodInfo);
        }
        classFile.setMethods(methods);
    }

    private void getAttributes_Info() throws IOException {
        int attributes_count = dataInput.readUnsignedShort();
        classFile.setAttributes_count(attributes_count);
        classFile.setAttributes(getAttributeList(attributes_count));
    }

    private List<Attribute_Info> getAttributeList(int attribute_count) throws IOException {
        List<Attribute_Info> attributes = new ArrayList<Attribute_Info>(attribute_count);
        Attribute_InfoUtil attributeInfoUtil = new Attribute_InfoUtil(dataInput, classFile.getConst_pool());
        for (int i = 0; i < attribute_count; i++) {
            Attribute_Info attributeinfo = attributeInfoUtil.getAttributeInfo();
            attributes.add(attributeinfo);
        }
        return attributes;
    }
}
