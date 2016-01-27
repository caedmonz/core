package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Float_Info extends Cp_Info {

    float bytes;

    public float getBytes() {
        return bytes;
    }

    public void setBytes(float bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "bytes: " + bytes;
        return state;
    }
}