package org.zhangqh.core;

import java.io.IOException;

import org.junit.Test;
import org.zhangqh.core.classfile.ClassFile;

public class ClassFileAnalysisTest {

    @Test
    public void testClassFileAnalysis() throws IOException {
        // TODO Auto-generated method stub
        ClassFileAnalysis parser = new ClassFileAnalysis("test_resources\\ClassFileAnalysis.class");
        ClassFile classFile = parser.getClassFile();
        System.out.println(classFile);
        System.out.println(parser.getAllClassName());
    }
}
