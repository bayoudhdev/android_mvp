package com.mvp.project.main.fragments.login;

import com.mvp.project.commons.bases.viewIntrerfaces.BaseFragmentViewInterface;

/**
 * Created by bayoudh on 25/01/2017.
 */

public interface LoginViewInterface extends BaseFragmentViewInterface {
    /**
     * Method used to get success result
     */
    void loadLoginSuccess();

    /**
     * Method used when get error auth
     */
    void loadLoginFailed();
}
