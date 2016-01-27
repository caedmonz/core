package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_MethodType_Info extends Cp_Info {

    int descriptor_index;

    public int getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(int descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "descriptor_index: " + descriptor_index;
        return state;
    }
}
