package org.zhangqh.core.classfile.attributepool;

import org.zhangqh.core.classfile.Attribute_Info;

public class SourceFile extends Attribute_Info {

    private int sourcefile_index;

    public int getSourcefile_index() {
        return sourcefile_index;
    }

    public void setSourcefile_index(int sourcefile_index) {
        this.sourcefile_index = sourcefile_index;
    }

    @Override
    public String toString() {
        return super.toString() + " sourcefile_index=" + sourcefile_index;
    }

}