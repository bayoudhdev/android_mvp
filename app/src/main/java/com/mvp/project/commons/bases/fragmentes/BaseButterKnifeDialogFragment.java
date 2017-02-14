package com.mvp.project.commons.bases.fragmentes;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseButterKnifeDialogFragment extends DialogFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }
}