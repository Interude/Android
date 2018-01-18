package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.nt.cebdriver.CardRfd;
import com.nt.cebdriver.IEventCallback;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * <p>
 * 非接IC模块
 */

public class CardRfdPulgin extends DevicePlugin {

    private CardRfd cardRfd = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cardRfd = new CardRfd();
    }


    /**
     * 查询设备状态
     **/
    public boolean rfdStatus(JSONObject inList) {
        inList = cardRfd.rfdStatus(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }

    /**
     * 上电
     **/
    public boolean rfdIdentify(JSONObject inList) {
        try {
            callbackPageFunc = inList.getString("eventCallback");
            inList = cardRfd.rfdIdentify(this, inList);
            mCallbackContext.success(inList.toString());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();

            mCallbackContext.success(gson.toJson(Data.createFail("json 解析错误")));
            return false;
        }


    }

    /**
     * IC卡通讯
     **/
    public boolean rfdChipIO(JSONObject inList) {

        inList = cardRfd.rfdChipIO(inList);

        mCallbackContext.success(inList.toString());
        return true;
    }

    /**
     * 读、Track2、3、57标签值
     **/
    public boolean rfdGetCardInfo(JSONObject inList) {

        inList = cardRfd.rfdGetCardInfo(inList);

        mCallbackContext.success(inList.toString());
        return true;
    }


    /**
     * 读取卡电子现金信息
     **/

    public boolean rfdGetBalance(JSONObject inList) {

        inList = cardRfd.rfdGetBalance(inList);

        mCallbackContext.success(inList.toString());
        return true;
    }

    /**
     * 读取卡号
     **/
    public boolean rfdGetCardNo(JSONObject inList) {

        inList = cardRfd.rfdGetCardNo(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }

    /**
     * 设备复位
     **/
    public boolean rfdReset(JSONObject inList) {
        inList = cardRfd.rfdReset(inList);
        mCallbackContext.success(inList.toString());
        return true;
    }


}
