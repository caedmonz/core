package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_InterfaceMethodref_Info extends Cp_Info {

    int class_index;

    int name_and_type_index;

    public int getClass_index() {
        return class_index;
    }

    public void setClass_index(int class_index) {
        this.class_index = class_index;
    }

    public int getName_and_type_index() {
        return name_and_type_index;
    }

    public void setName_and_type_index(int name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "class_index: " + class_index + " ";
        state += "name_and_type_index: " + name_and_type_index;
        return state;
    }
}
