package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Class_Info extends Cp_Info {
    int name_index;

    public int getName_index() {
        return name_index;
    }

    public void setName_index(int name_index) {
        this.name_index = name_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "name_index: " + name_index;
        return state;
    }

}
