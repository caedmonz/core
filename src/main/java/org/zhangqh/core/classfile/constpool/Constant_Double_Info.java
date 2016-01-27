package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Double_Info extends Cp_Info {

    double bytes;

    public double getBytes() {
        return bytes;
    }

    public void setBytes(double bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "bytes: " + bytes;
        return state;
    }
}