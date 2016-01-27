package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_String_Info extends Cp_Info {

    int string_index;

    public int getString_index() {
        return string_index;
    }

    public void setString_index(int string_index) {
        this.string_index = string_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "string_index: " + string_index;
        return state;
    }
}
