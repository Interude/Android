package com.nt.cebdriver;

import org.json.JSONObject;

/**
 * Created by xiaochunyuan on 18/1/18.
 * 二代证驱动层
 */

public class CardIdc {


    /**
     * 状态查询
     **/
    public JSONObject ibcStatus(JSONObject inList) {
        return inList;
    }

    /**
     * 等待用户插入身份证
     **/

    public JSONObject idcScan(IEventCallback callback, JSONObject inList) {

        return inList;

    }


    /**
     * 设备复位
     **/

    public JSONObject idcReset(JSONObject inList) {
        return inList;
    }


}
