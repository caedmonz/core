package org.zhangqh.core.classfile.attributepool.stackmapclasses;

public class Same_Frame_Extended extends Stack_Map_Frame {

    private int offset_delta;

    public int getOffset_delta() {
        return offset_delta;
    }

    public void setOffset_delta(int offset_delta) {
        this.offset_delta = offset_delta;
    }

    @Override
    public String toString() {
        return super.toString() + " offset_delta=" + offset_delta;
    }
}
