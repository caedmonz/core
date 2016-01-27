package org.zhangqh.core.classfile.constpool;

import org.zhangqh.core.classfile.Cp_Info;

public class Constant_Utf8_Info extends Cp_Info {

    int length;

    byte[] bytes;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        String state = super.toString();
        state += "length: " + length + " ";
        state += "bytes: " + new String(bytes);
        return state;
    }
}
