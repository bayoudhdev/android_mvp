package com.mvp.project.main.activities;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.mvp.project.commons.bases.presenters.BaseActivityPresenter;

/**
 * Created by bayoudh on 25/01/2017.
 */

public class MainActivityPresenter extends BaseActivityPresenter<MainActivityViewInterface> {

    @Override
    public void exitApp(Activity activity, FragmentManager fragmentManager, boolean isActivityRunning) {
        super.exitApp(activity, fragmentManager, isActivityRunning);
    }

}