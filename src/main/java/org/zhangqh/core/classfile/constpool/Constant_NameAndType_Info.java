package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_NameAndType_Info extends Cp_Info {

    int name_index;

    int descriptor_index;

    public int getName_index() {
        return name_index;
    }

    public void setName_index(int name_index) {
        this.name_index = name_index;
    }

    public int getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(int descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "name_index: " + name_index + " ";
        state += "descriptor_index: " + descriptor_index;
        return state;
    }

}
