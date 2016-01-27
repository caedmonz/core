package org.zhangqh.core.classfile;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InvalidClassException;

import org.zhangqh.core.classfile.constpool.*;


public class Cp_InfoUtil {

    private DataInputStream dataInput;

    public Cp_InfoUtil(DataInputStream dataInput) {
        this.dataInput = dataInput;
    }

    public Cp_Info getCpInfo() throws IOException {
        int tag = dataInput.readUnsignedByte();
        switch (tag) {
        case 7:
            Constant_Class_Info cpInfo7 = new Constant_Class_Info();
            int name_index = dataInput.readUnsignedShort();
            cpInfo7.setTag(Constant_Pool_Tag.CONSTANT_CLASS);
            cpInfo7.setName_index(name_index);
            return cpInfo7;
        case 9:
            Constant_Fieldref_Info cpInfo9 = new Constant_Fieldref_Info();
            int class_index9 = dataInput.readUnsignedShort();
            int name_and_type_index9 = dataInput.readUnsignedShort();
            cpInfo9.setTag(Constant_Pool_Tag.CONSTANT_FIELDREF);
            cpInfo9.setClass_index(class_index9);
            cpInfo9.setName_and_type_index(name_and_type_index9);
            return cpInfo9;
        case 10:
            Constant_Methodref_Info cpInfo10 = new Constant_Methodref_Info();
            int class_index10 = dataInput.readUnsignedShort();
            int name_and_type_index10 = dataInput.readUnsignedShort();
            cpInfo10.setTag(Constant_Pool_Tag.CONSTANT_METHODREF);
            cpInfo10.setClass_index(class_index10);
            cpInfo10.setName_and_type_index(name_and_type_index10);
            return cpInfo10;
        case 11:
            Constant_InterfaceMethodref_Info cpInfo11 = new Constant_InterfaceMethodref_Info();
            int class_index11 = dataInput.readUnsignedShort();
            int name_and_type_index11 = dataInput.readUnsignedShort();
            cpInfo11.setTag(Constant_Pool_Tag.CONSTANT_INTERFACEMETHODREF);
            cpInfo11.setClass_index(class_index11);
            cpInfo11.setName_and_type_index(name_and_type_index11);
            return cpInfo11;
        case 8:
            Constant_String_Info cpInfo8 = new Constant_String_Info();
            int string_index = dataInput.readUnsignedShort();
            cpInfo8.setTag(Constant_Pool_Tag.CONSTANT_STRING);
            cpInfo8.setString_index(string_index);
            return cpInfo8;
        case 3:
            Constant_Integer_Info cpInfo3 = new Constant_Integer_Info();
            int bytes3 = dataInput.readInt();
            cpInfo3.setTag(Constant_Pool_Tag.CONSTANT_INTEGER);
            cpInfo3.setBytes(bytes3);
            return cpInfo3;
        case 4:
            Constant_Float_Info cpInfo4 = new Constant_Float_Info();
            float bytes4 = dataInput.readFloat();
            cpInfo4.setTag(Constant_Pool_Tag.CONSTANT_FLOAT);
            cpInfo4.setBytes(bytes4);
            return cpInfo4;
        case 5:
            Constant_Long_Info cpInfo5 = new Constant_Long_Info();
            long bytes5 = dataInput.readLong();
            cpInfo5.setTag(Constant_Pool_Tag.CONSTANT_LONG);
            cpInfo5.setBytes(bytes5);
            return cpInfo5;
        case 6:
            Constant_Double_Info cpInfo6 = new Constant_Double_Info();
            double bytes6 = dataInput.readDouble();
            cpInfo6.setTag(Constant_Pool_Tag.CONSTANT_DOUBLE);
            cpInfo6.setBytes(bytes6);
            return cpInfo6;
        case 12:
            Constant_NameAndType_Info cpInfo12 = new Constant_NameAndType_Info();
            int name_index12 = dataInput.readUnsignedShort();
            int descriptor_index12 = dataInput.readUnsignedShort();
            cpInfo12.setTag(Constant_Pool_Tag.CONSTANT_NAMEANDTYPE);
            cpInfo12.setName_index(name_index12);
            cpInfo12.setDescriptor_index(descriptor_index12);
            return cpInfo12;
        case 1:
            Constant_Utf8_Info cpInfo1 = new Constant_Utf8_Info();
            int length1 = dataInput.readUnsignedShort();
            byte[] bytes1 = new byte[length1];
            dataInput.readFully(bytes1);
            cpInfo1.setTag(Constant_Pool_Tag.CONSTANT_UTF8);
            cpInfo1.setLength(length1);
            cpInfo1.setBytes(bytes1);
            return cpInfo1;
        case 15:
            Constant_MethodHandle_Info cpInfo15 = new Constant_MethodHandle_Info();
            int reference_kind = dataInput.readUnsignedShort();
            int reference_index = dataInput.readUnsignedShort();
            cpInfo15.setTag(Constant_Pool_Tag.CONSTANT_METHODHANDLE);
            cpInfo15.setReference_kind(reference_kind);
            cpInfo15.setReference_index(reference_index);
            return cpInfo15;
        case 16:
            Constant_MethodType_Info cpInfo16 = new Constant_MethodType_Info();
            int descriptor_index16 = dataInput.readUnsignedShort();
            cpInfo16.setTag(Constant_Pool_Tag.CONSTANT_METHODTYPE);
            cpInfo16.setDescriptor_index(descriptor_index16);
            return cpInfo16;
        case 18:
            Constant_InvokeDynamic_Info cpInfo18 = new Constant_InvokeDynamic_Info();
            int bootstrap_method_attr_index = dataInput.readUnsignedShort();
            int name_and_type_index = dataInput.readUnsignedShort();
            cpInfo18.setTag(Constant_Pool_Tag.CONSTANT_INVOKEDYNAMIC);
            cpInfo18.setBootstrap_method_attr_index(bootstrap_method_attr_index);
            cpInfo18.setName_and_type_index(name_and_type_index);
            return cpInfo18;
        default:
            throw new InvalidClassException("[A element in Constant pool with wrong tag] tag is " + tag);
        }
    }
}
