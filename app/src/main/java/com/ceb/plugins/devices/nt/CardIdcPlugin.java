package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.CardIdc;
import com.nt.cebdriver.IEventCallback;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * <p>
 * 二代身份证阅读插件层
 */

public class CardIdcPlugin extends DevicePlugin {

    private CardIdc cardIdc = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cardIdc = new CardIdc();
    }

    /**
     * 状态查询
     **/
    public boolean ibcStatus(JSONObject inList) {

        inList = cardIdc.ibcStatus(inList);
        mCallbackContext.success(inList);
        return true;
    }

    /**
     * 等待用户插入身份证
     **/

    public boolean idcScan(IEventCallback callback, JSONObject inList) {

        try {
            callbackPageFunc = inList.getString("eventCallback");
            inList = cardIdc.idcScan(this, inList);
            mCallbackContext.success(inList.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
            return false;
        }


    }


    /**
     * 设备复位
     **/

    public boolean idcReset(JSONObject inList) {

        inList = cardIdc.idcReset(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


}
