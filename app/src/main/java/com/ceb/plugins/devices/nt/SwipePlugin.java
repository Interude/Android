package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.Swipe;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by liyong on 2018/1/17.
 */

public class SwipePlugin extends DevicePlugin{
    private Swipe deviceSwipe;
    
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        deviceSwipe = new Swipe();
    }

    public boolean swpStatus(JSONObject inList){
        inList = deviceSwipe.swpStatus(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }

    public boolean swpReadTracks(JSONObject inList){
        try {
            callbackPageFunc = inList.getString("eventCallback");
            inList = deviceSwipe.swpReadTracks(this, inList);
            mCallbackContext.success(inList.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
        return false;
    }

    public boolean swpReset(JSONObject inList){
        inList = deviceSwipe.swpReset(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }
}
