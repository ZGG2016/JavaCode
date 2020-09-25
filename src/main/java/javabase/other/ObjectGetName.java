package javabase.other;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ObjectGetName {

    private static class Innr{}

    private static Logger log = LogManager.getLogger(ObjectGetName.class);

    public static void main(String[] args) throws Exception {

        log.info("-----------内部类----------------");
        Class innr = Innr.class;
        log.info(innr.getCanonicalName());
        log.info(innr.getName());
        log.info(innr.getSimpleName());

        log.info("-----------匿名类----------------");

        Class anonymousClass = new Object(){}.getClass();
        log.info(anonymousClass.getCanonicalName());
        log.info(anonymousClass.getName());
        log.info(anonymousClass.getSimpleName());

        log.info("-----------数组类----------------");
        Class arrayClass = Object[].class;
        log.info(arrayClass.getCanonicalName());
        log.info(arrayClass.getName());
        log.info(arrayClass.getSimpleName());


    }
}
//原文链接：https://blog.csdn.net/zq1994520/article/details/78942684
