package com.mvp.project.commons.bases.fragmentes;

import android.app.Activity;
import android.content.Context;

import com.mvp.project.commons.bases.activities.BaseActivity;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseActivityFragment extends BaseButterKnifeFragment {

    protected BaseActivity baseActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity != null && activity instanceof BaseActivity) {
            baseActivity = (BaseActivity) activity;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity != null && activity instanceof BaseActivity) {
            baseActivity = (BaseActivity) activity;
        }
    }

    @Override
    public void onDetach() {
        baseActivity = null;
        super.onDetach();
    }
}