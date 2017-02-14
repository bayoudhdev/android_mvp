package com.mvp.project.main.fragments.login;

import android.content.Context;

import com.mvp.project.commons.bases.presenters.BaseFragmentPresenter;
import com.mvp.project.networks.listeners.UserAuthCallBack;
import com.mvp.project.networks.requests.PostLoginRequest;

/**
 * Created by bayoudh on 25/01/2017.
 */

public class LoginPresenter extends BaseFragmentPresenter<LoginViewInterface> {

    public void login(Context mContext, String password) {
        PostLoginRequest postLoginRequest = new PostLoginRequest(mContext);
        postLoginRequest.loadDataFromNetwork().postLogin(password).enqueue(new UserAuthCallBack(mContext) {
            @Override
            public void onRequestSuccessValid(Object result) {
                if (getViewCallback() != null)
                    getViewCallback().loadLoginSuccess();
            }

            @Override
            public void onRequestSuccessNotValid(String result) {
                if (getViewCallback() != null)
                    getViewCallback().loadLoginFailed();
            }
        });
    }
}
