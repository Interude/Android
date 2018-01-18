package com.ceb.plugins.devices.nt;

import com.ceb.plugins.pojo.Data;
import com.google.gson.Gson;
import com.nt.cebdriver.IEventCallback;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

/**
 * Created by liyong on 2018/1/17.
 */

public abstract class DevicePlugin extends CordovaPlugin implements IEventCallback{
    protected CallbackContext mCallbackContext;
    protected Gson gson = new Gson();
    protected String callbackPageFunc;

    @Override
    public boolean execute(String action, String rawArgs, CallbackContext callbackContext) throws JSONException {
        mCallbackContext = callbackContext;
        try {
            Method method = this.getClass().getDeclaredMethod(action, JSONObject.class);
            return (boolean)method.invoke(this, new JSONObject(rawArgs));
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.success(new Gson().toJson(Data.createFail("调用失败，请检查类名，方法名,参数是否正确")));
            return false;
        }
    }

    @Override
    public void devEvent(JSONObject outList) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(callbackPageFunc != null){
                    webView.loadUrl("javascript: " + callbackPageFunc + "('" + new Gson().toJson(outList) + "')");
                }
            }
        });
    }
}
