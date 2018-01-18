package com.ceb.plugins.pojo;

import org.apache.cordova.PluginResult;

/**
 * Created by liyong on 2018/1/12.
 */

public class Data<T> {
    private String code;
    private T data;

    public static <T> Data<T> createSuccess(T info) {
        Data entry = new Data();
        entry.code = PluginResult.Status.OK.toString();
        entry.data = info;
        return entry;
    }

    public static <T> Data<T> createFail(T error) {
        Data entry = new Data();
        entry.code = PluginResult.Status.ERROR.toString();
        entry.data = error;
        return entry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
