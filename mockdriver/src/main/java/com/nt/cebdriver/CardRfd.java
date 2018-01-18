package com.nt.cebdriver;

import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * 非接触IC模块
 */

public class CardRfd {

    /**
     * 查询设备状态
     **/
    public JSONObject rfdStatus(JSONObject inList) {
        return inList;
    }

    /**
     * 上电
     **/
    public JSONObject rfdIdentify(IEventCallback callback, JSONObject inList) {
        return inList;
    }

    /**
     * IC卡通讯
     **/
    public JSONObject rfdChipIO(JSONObject inList) {
        return inList;
    }

    /**
     * 读、Track2、3、57标签值
     **/
    public JSONObject rfdGetCardInfo(JSONObject inList) {
        return inList;
    }


    /**
     * 读取卡电子现金信息
     **/

    public JSONObject rfdGetBalance(JSONObject inList) {
        return inList;
    }

    /**
     * 读取卡号
     **/
    public JSONObject rfdGetCardNo(JSONObject inList) {
        return inList;
    }

    /**
     * 设备复位
     **/
    public JSONObject rfdReset(JSONObject inList) {
        return inList;
    }


}
