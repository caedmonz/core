package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_MethodHandle_Info extends Cp_Info {

    int reference_kind;

    int reference_index;

    public int getReference_kind() {
        return reference_kind;
    }

    public void setReference_kind(int reference_kind) {
        this.reference_kind = reference_kind;
    }

    public int getReference_index() {
        return reference_index;
    }

    public void setReference_index(int reference_index) {
        this.reference_index = reference_index;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "reference_kind: " + reference_kind + " ";
        state += "reference_index: " + reference_index;
        return state;
    }

}
