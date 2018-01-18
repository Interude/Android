package com.nt.cebdriver;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by liyong on 2018/1/17.
 */

public class PinPad {

    public JSONObject pinStatus(JSONObject inList){
        return inList;
    }

    public JSONObject pinLoadKey(JSONObject inList){
        return inList;
    }

    public JSONObject pinCrypt(JSONObject inList){
        return inList;
    }

    public JSONObject pinGetData(final IEventCallback callback, JSONObject inList){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                while (System.currentTimeMillis() - start < 6 * 1000) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("0", "0");
                        jsonObject.put("确认", "ENTER");
                        jsonObject.put("退格", "BACKSPACE");
                        callback.devEvent(jsonObject);
                        Thread.sleep(3 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return inList;
    }

    public JSONObject pinGetPin(IEventCallback callback, JSONObject inList){
        return inList;
    }

    public JSONObject pinGetPinblock(IEventCallback callback, JSONObject inList){
        return inList;
    }

    public JSONObject pinReset(JSONObject inList){
        return inList;
    }
}
