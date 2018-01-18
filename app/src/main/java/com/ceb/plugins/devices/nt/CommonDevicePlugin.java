package com.ceb.plugins.devices.nt;

import com.nt.cebdriver.CommonDevice;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;

/**
 * Created by liyong on 2018/1/17.
 */

public class CommonDevicePlugin extends DevicePlugin {
    private CommonDevice deviceCommonDevice;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        deviceCommonDevice = new CommonDevice();
    }

    public boolean open(JSONObject inList){
        inList = deviceCommonDevice.open(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }

    public boolean close(JSONObject inList){
        inList = deviceCommonDevice.close(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }

    public boolean cancel(JSONObject inList){
        inList = deviceCommonDevice.cancel(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }
}

