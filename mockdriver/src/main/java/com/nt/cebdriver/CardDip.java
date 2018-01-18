package com.nt.cebdriver;

import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 *  接触IC模块
 * */



public class CardDip {

    /**
     * 查询设备状态
     **/
    public JSONObject cdpStatus(JSONObject inList) {


        return inList;
    }

    /**
     * IC卡上电操作
     **/

    public JSONObject cdpPowerOn(IEventCallback callback,JSONObject inList) {

        return inList;
    }


    /**
     * IC卡下电操作
     **/


    public JSONObject cdpPowerOff(JSONObject inList) {

        return inList;
    }


    /**
     * IC卡通讯
     **/

    public JSONObject cdpChipIO(JSONObject inList) {
        return inList;
    }


    /**
     * 读取芯片中的Track2、Track3、及57标签
     **/
    public JSONObject cdpGetCardinfo(JSONObject inList) {
        return inList;
    }


    /**
     * 读取卡片电子现金信息
     **/


    public JSONObject cdpGetBalance(JSONObject inList) {
        return inList;
    }


    /**
     * 读取芯片卡中卡号
     **/

    public JSONObject cdpGetCardNo(JSONObject inList) {
        return inList;
    }


    /**
     * 设备复位
     **/

    public JSONObject cdpReset(JSONObject inList) {

        return inList;
    }


}
