package com.mvp.project.networks.listeners;

import android.content.Context;

import com.mvp.project.networks.ParamsWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bayoudh on 25/10/2016.
 */

public abstract class UserAuthCallBack extends BaseWSCallBack implements Callback<Object> {
    public UserAuthCallBack(Context mContext) {
        super(mContext);
    }

    @Override
    public void onResponse(Call<Object> call, Response<Object> response) {
        // if (response.body().getStatus() == ParamsWebService.ErrorMessageWS.KEY_SUCCESS_WS)
        //     onRequestSuccessValid(response.body());
        // else {
        //     onRequestSuccessNotValid(checkCodeMessage(response.body().getStatus()));
        // }
    }

    @Override
    public void onFailure(Call<Object> call, Throwable t) {
        onRequestSuccessNotValid(checkCodeMessage(ParamsWebService.ErrorMessageWS.KEY_ERROR_SERVER));
    }
}
