package org.zhangqh.core.classfile.attributepool;

import org.zhangqh.core.classfile.Attribute_Info;

public class ConstantValue extends Attribute_Info {

    int constant_value_index;

    public int getConstant_value_index() {
        return constant_value_index;
    }

    public void setConstant_value_index(int constant_value_index) {
        this.constant_value_index = constant_value_index;
    }

    @Override
    public String toString() {
        return super.toString() + " constant_value_index=" + constant_value_index;
    }
}
