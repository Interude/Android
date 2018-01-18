package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.PinPad;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by liyong on 2018/1/17.
 */

public class PinPadPlugin extends DevicePlugin{
    private PinPad driverPinPad;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        driverPinPad = new PinPad();
    }

    public boolean pinStatus(JSONObject jsonObj){
        jsonObj = driverPinPad.pinStatus(jsonObj);
        mCallbackContext.success(jsonObj.toString());
        return true;
    }

    public boolean pinLoadKey(JSONObject jsonObj){
        jsonObj = driverPinPad.pinLoadKey(jsonObj);
        mCallbackContext.success(jsonObj.toString());
        return true;
    }

    public boolean pinCrypt(JSONObject jsonObj){
        jsonObj = driverPinPad.pinCrypt(jsonObj);
        mCallbackContext.success(jsonObj.toString());
        return true;
    }

    public boolean pinGetData(JSONObject jsonObj){
        try {
            callbackPageFunc = jsonObj.getString("eventCallback");
            jsonObj = driverPinPad.pinGetData(this, jsonObj);
            mCallbackContext.success(jsonObj.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
        return false;
    }

    public boolean pinGetPin(JSONObject jsonObj){
        try {
            callbackPageFunc = jsonObj.getString("eventCallback");
            jsonObj = driverPinPad.pinGetPin(this, jsonObj);
            mCallbackContext.success(jsonObj.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
        return false;
    }

    public boolean pinGetPinblock(JSONObject jsonObj){
        try {
            callbackPageFunc = jsonObj.getString("eventCallback");
            jsonObj = driverPinPad.pinGetPinblock(this, jsonObj);
            mCallbackContext.success(jsonObj.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
        return false;
    }

    public boolean pinReset(JSONObject jsonObj){
        jsonObj = driverPinPad.pinReset(jsonObj);
        mCallbackContext.success(jsonObj.toString());
        return true;
    }
}
