package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Long_Info extends Cp_Info {

    long bytes;

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "bytes: " + bytes;
        return state;
    }
}