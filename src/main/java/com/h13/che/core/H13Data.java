package com.h13.che.core;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-2-14
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */
public class H13Data extends HashMap<String, Object> {

    private H13Data() {
    }

    public static H13Data getData() {
        return new H13Data();
    }

    public H13Data add(String key, Object value) {
        put(key, value);
        return this;
    }
}
