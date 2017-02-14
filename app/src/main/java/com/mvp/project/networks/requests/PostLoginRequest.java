package com.mvp.project.networks.requests;

import android.content.Context;

import com.mvp.project.managers.InjectorManager;
import com.mvp.project.networks.ParamsWebService;
import com.mvp.project.networks.interfaces.IRUserService;

/**
 * Created by bayoudh on 25/10/2016.
 */

public class PostLoginRequest {
    Context context;

    public PostLoginRequest(Context context) {
        this.context = context;
    }

    /**
     * Method used to load data user information
     *
     * @return
     */
    public IRUserService loadDataFromNetwork() {
        return InjectorManager.getInstance(ParamsWebService.DEFAULT_BASE_URL, true).createReq(IRUserService.class);
    }
}
