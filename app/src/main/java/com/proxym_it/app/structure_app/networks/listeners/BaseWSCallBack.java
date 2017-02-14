package com.proxym_it.app.structure_app.networks.listeners;

import android.content.Context;

/**
 * Created by Bayoudh on 10/08/2016.
 */
public abstract class BaseWSCallBack {

    //region Fields
    protected Context mContext;
    //endregion

    //region Constructor
    public BaseWSCallBack(Context mContext) {
        this.mContext = mContext;
    }
    //endregion


    protected String checkCodeMessage(int code) {
        switch (code) {
            case 0:
                return "";
            default:
                return "";
        }
    }
    //endregion

    //region abstract
    public abstract void onRequestSuccessValid(Object result);

    public abstract void onRequestSuccessNotValid(String result);

    //endregion
    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    //endregion
}

