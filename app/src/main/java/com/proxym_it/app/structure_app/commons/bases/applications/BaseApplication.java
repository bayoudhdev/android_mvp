package com.proxym_it.app.structure_app.commons.bases.applications;

import android.app.Application;


/**
 * Created by bayoudh on 25/01/2017.
 */
public class BaseApplication extends Application {
    private static final String DEBUG_STRING = "debug";
    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


}
