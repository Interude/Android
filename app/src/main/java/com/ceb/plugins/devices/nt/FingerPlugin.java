package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.Finger;
import com.nt.cebdriver.IEventCallback;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * 指纹识别也仪器插件层
 */

public class FingerPlugin extends DevicePlugin {

    private Finger finger = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        finger = new Finger();
    }


    /**
     * 查询设备状态
     **/
    public boolean fgrStatus(JSONObject inList) {

        inList = finger.fgrStatus(inList);
        mCallbackContext.success(inList.toString());


        return true;
    }

    /**
     * 等待指纹录入
     **/
    public boolean fgrGetFeature(IEventCallback callback, JSONObject inList) {


        try {
            callbackPageFunc = inList.getString("eventCallback");
            inList = finger.fgrGetFeature(this, inList);
            mCallbackContext.success(inList.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
            return false;
        }


    }


    /**
     * 指纹比对
     **/
    public boolean fgrMatch(JSONObject inList) {

        inList = finger.fgrMatch(inList);
        mCallbackContext.success(inList);
        return true;
    }

    /**
     * 设备复位
     **/

    public boolean fgrReset(JSONObject inList) {

        inList = finger.fgrReset(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


}
