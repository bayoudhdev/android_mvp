package com.proxym_it.app.structure_app.main.fragments.login;

import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseFragmentViewInterface;

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
