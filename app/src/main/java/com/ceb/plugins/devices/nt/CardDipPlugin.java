package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.CardDip;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * <p>
 * 接触IC卡模块
 */

public class CardDipPlugin extends DevicePlugin {

    private CardDip cardDip = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cardDip = new CardDip();
    }


    public boolean cdpStatus(JSONObject inList) {
        inList = cardDip.cdpStatus(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 上电
     **/
    public boolean cdpPowerOn(JSONObject inList) {
        try {
            callbackPageFunc = inList.getString("eventCallback");
            inList = cardDip.cdpPowerOn(this,inList);
            mCallbackContext.success(inList.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
            return false;
        }


    }


    /**
     * 下电
     **/

    public boolean cdpPowerOff(JSONObject inList) {

        inList = cardDip.cdpPowerOff(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * IC卡通讯
     **/

    public boolean cdpChipIO(JSONObject inList) {
        inList = cardDip.cdpChipIO(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 读Track2、3、57
     **/

    public boolean cdpGetCardInfo(JSONObject inList) {
        inList = cardDip.cdpGetCardinfo(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 读取卡电子现金信息
     **/

    public boolean cdpGetBalance(JSONObject inList) {
        inList = cardDip.cdpGetBalance(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 得到卡片中卡号
     **/
    public boolean cdpGetCardNo(JSONObject inList) {
        inList = cardDip.cdpGetCardNo(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 设备复位
     **/
    public boolean cdpReset(JSONObject inList) {
        inList = cardDip.cdpReset(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


}
