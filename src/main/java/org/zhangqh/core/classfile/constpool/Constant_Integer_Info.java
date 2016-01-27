package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Integer_Info extends Cp_Info {

    int bytes;

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "bytes: " + bytes;
        return state;
    }
}
