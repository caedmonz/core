package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_InvokeDynamic_Info extends Cp_Info {

    int bootstrap_method_attr_index;

    int name_and_type_index;

    public int getBootstrap_method_attr_index() {
        return bootstrap_method_attr_index;
    }

    public void setBootstrap_method_attr_index(int bootstrap_method_attr_index) {
        this.bootstrap_method_attr_index = bootstrap_method_attr_index;
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
        state += "bootstrap_method_attr_index: " + bootstrap_method_attr_index + " ";
        state += "name_and_type_index: " + name_and_type_index;
        return state;
    }

}
