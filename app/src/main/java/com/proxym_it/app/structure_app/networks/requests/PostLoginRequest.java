package com.proxym_it.app.structure_app.networks.requests;

import android.content.Context;

import com.proxym_it.app.structure_app.managers.InjectorManager;
import com.proxym_it.app.structure_app.networks.ParamsWebService;
import com.proxym_it.app.structure_app.networks.interfaces.IRUserService;

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
