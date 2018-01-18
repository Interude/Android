package com.ceb.plugins.utils;

import android.Manifest;
import android.content.pm.PackageManager;

import com.ceb.plugins.devices.nt.DevicePlugin;
import com.ceb.plugins.pojo.Data;
import com.ceb.utils.Utils;
import com.google.gson.Gson;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.json.JSONException;

import java.io.File;

/**
 * Created by liyong on 2018/1/12.
 */

public class UtilPlugin extends DevicePlugin {
    public static final String READ = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final int ESPERMISSION = 0;
    CallbackContext mCallbackContext;
    CordovaArgs mArgs;

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        this.mCallbackContext = callbackContext;
        this.mArgs = args;
        if (cordova.hasPermission(READ)) {
            if (processFile(args, callbackContext)) return true;
        } else {
            getExternalStoragePermission(ESPERMISSION);
        }
        return false;
    }

    private boolean processFile(CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        String path = args.getString(0);
        path = Utils.getStorageFilePath(cordova.getContext(), path);
        try {
            String digest = digestFile(new File(path));
            postResult(Data.createSuccess(digest));
            callbackContext.success(digest);
            return true;
        } catch (Exception e) {
            postResult(Data.createFail("获取文件摘要失败"));
            e.printStackTrace();
        }
        return false;
    }

    private void postResult(Data data){
        mCallbackContext.success(new Gson().toJson(data));
    }

    private String digestFile(File file) throws Exception {
        return Utils.digestFile(file);
    }

    private void getExternalStoragePermission(int requestCode) {
        cordova.requestPermission(this, requestCode, READ);
    }

    @Override
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
        switch (requestCode) {
            case ESPERMISSION:
                if (isDenied(grantResults)) {
                    postResult(Data.createFail("没有读取sd卡的权限"));
                }else{
                    processFile(mArgs, mCallbackContext);
                }
                break;
        }

    }

    private boolean isDenied(int[] grantResults) {
        for (int r : grantResults) {
            if (r == PackageManager.PERMISSION_DENIED) {
                return true;
            }
        }
        return false;
    }
}
