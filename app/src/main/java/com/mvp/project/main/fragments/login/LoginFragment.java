package com.mvp.project.main.fragments.login;

import android.support.annotation.NonNull;

import com.mvp.project.commons.bases.fragmentes.BaseFragment;

/**
 * Created by bayoudh on 25/01/2017.
 */

public class LoginFragment extends BaseFragment<LoginPresenter, LoginViewInterface> implements LoginViewInterface {
    @Override
    public boolean onBackPressed() {
        return false;
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @NonNull
    @Override
    public LoginViewInterface createViewInterface() {
        return this;
    }

    @Override
    public void loadLoginSuccess() {

    }

    @Override
    public void loadLoginFailed() {

    }

    @Override
    public void onResume() {
        super.onResume();
//TODO TO THIS EXEMPLE TO POST LOGIN ;)
        //presenter.login(baseActivity,"your password");
    }
}
