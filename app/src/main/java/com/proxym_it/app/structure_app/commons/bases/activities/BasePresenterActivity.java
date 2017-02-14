package com.proxym_it.app.structure_app.commons.bases.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.proxym_it.app.structure_app.commons.bases.presenters.BaseActivityPresenter;
import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseActivityViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BasePresenterActivity<P extends BaseActivityPresenter<O>, O extends BaseActivityViewInterface> extends BaseButterKnifeActivity {

    protected P presenter;
    protected O viewInterface;

    @NonNull
    public abstract P createPresenter();

    private void setPresenter() {
        presenter = createPresenter();
    }

    public P getPresenter() {
        return presenter;
    }

    @NonNull
    public abstract O createViewInterface();

    private void setViewInterface() {
        viewInterface = createViewInterface();
    }

    public O getViewInterface() {
        return viewInterface;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        setViewInterface();
        presenter.attachViewCallback(viewInterface);
    }

    @Override
    protected void onResume() {
        presenter.attachViewCallback(viewInterface);
        super.onResume();
    }

    @Override
    protected void onPause() {
        presenter.detachViewCallback();
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.attachViewCallback(viewInterface);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
