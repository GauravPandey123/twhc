package com.twhc;

import android.content.Context;
import android.support.multidex.MultiDex;

import in.editsoft.api.util.App;

/**
 * Created by Gaurav on 10/10/17.
 */

public class TwhcApp extends App {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
