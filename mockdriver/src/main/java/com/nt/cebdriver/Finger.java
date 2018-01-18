package com.nt.cebdriver;

import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * 指纹识别仪驱动层
 */

public class Finger {


    /**
     * 查询设备状态
     **/
    public JSONObject fgrStatus(JSONObject inList) {

        return inList;
    }

    /**
     * 等待指纹录入
     **/
    public JSONObject fgrGetFeature(IEventCallback callback, JSONObject inList) {

        return inList;
    }


    /**
     * 指纹比对
     **/
    public JSONObject fgrMatch(JSONObject inList) {
        return inList;
    }

    /**
     * 设备复位
     **/

    public JSONObject fgrReset(JSONObject inList) {
        return inList;
    }


}
