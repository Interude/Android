package com.ceb.business;

import android.app.Application;

/**
 * Created by liyong on 2018/1/17.
 */

public class CebApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ForegroundCallbacks.init(this);
    }
}
