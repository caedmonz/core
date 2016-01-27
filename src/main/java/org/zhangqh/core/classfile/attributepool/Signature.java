package org.zhangqh.core.classfile.attributepool;

import org.zhangqh.core.classfile.Attribute_Info;

public class Signature extends Attribute_Info {

    private int signature_index;

    public int getSignature_index() {
        return signature_index;
    }

    public void setSignature_index(int signature_index) {
        this.signature_index = signature_index;
    }

    @Override
    public String toString() {
        return super.toString() + " signature_index=" + signature_index;
    }
}