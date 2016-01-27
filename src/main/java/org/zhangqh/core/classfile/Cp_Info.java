package org.zhangqh.core.classfile;

public class Cp_Info {

    Constant_Pool_Tag tag;

    public Constant_Pool_Tag getTag() {
        return tag;
    }

    public void setTag(Constant_Pool_Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "[tag = " + tag + "] ";
    }
}
