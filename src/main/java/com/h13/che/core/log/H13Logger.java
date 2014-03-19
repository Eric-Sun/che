package com.h13.che.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-4
 * Time: 下午5:44
 * To change this template use File | Settings | File Templates.
 */
public class H13Logger {
    private static String KEY = "che";


    public static void info(H13LoggerEntity obj) {
        Logger log = LoggerFactory.getLogger(KEY + "." + obj.getMod());
        log.info(obj.toString());
    }

    public static void error(H13LoggerEntity obj, Throwable t) {
        Logger log = LoggerFactory.getLogger(KEY + "." + obj.getMod());
        log.error(obj.toString(), t);
    }

    public static void error(H13LoggerEntity obj) {
        Logger log = LoggerFactory.getLogger(KEY + "." + obj.getMod());
        log.error(obj.toString());
    }


    public static void debug(H13LoggerEntity obj) {
        Logger log = LoggerFactory.getLogger(KEY + "." + obj.getMod());
        log.debug(obj.toString());
    }

}
