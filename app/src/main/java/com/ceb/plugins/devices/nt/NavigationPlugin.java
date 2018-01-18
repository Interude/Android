package com.ceb.plugins.devices.nt;

import android.content.Intent;

import com.ceb.business.SecActivity;

import org.json.JSONObject;

/**
 * Created by liyong on 2018/1/17.
 */

public class NavigationPlugin extends DevicePlugin {

    public boolean startActivity(JSONObject jsonObject){
        cordova.getActivity().startActivity(new Intent(cordova.getActivity(), SecActivity.class));
        return true;
    }
}
