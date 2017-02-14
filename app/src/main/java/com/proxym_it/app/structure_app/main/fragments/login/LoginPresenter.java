package com.proxym_it.app.structure_app.main.fragments.login;

import android.content.Context;

import com.proxym_it.app.structure_app.commons.bases.presenters.BaseFragmentPresenter;
import com.proxym_it.app.structure_app.networks.listeners.UserAuthCallBack;
import com.proxym_it.app.structure_app.networks.requests.PostLoginRequest;

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
