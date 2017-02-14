package com.mvp.project.commons.bases.fragmentes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mvp.project.commons.bases.presenters.BaseFragmentPresenter;
import com.mvp.project.commons.bases.viewIntrerfaces.BaseFragmentViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BasePresenterFragment<P extends BaseFragmentPresenter<O>, O extends BaseFragmentViewInterface> extends BaseActivityFragment {

    protected P presenter;
    protected O viewInterface;

    @NonNull
    public abstract P createPresenter();

    private void setPresenter() {
        if (presenter == null)
            presenter = createPresenter();
    }

    public P getPresenter() {
        return presenter;
    }

    @NonNull
    public abstract O createViewInterface();

    private void setViewInterface() {
        if (viewInterface == null)
            viewInterface = createViewInterface();
    }

    public O getViewInterface() {
        return viewInterface;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        setViewInterface();
        presenter.attachViewCallback(viewInterface);
    }

    @Override
    public void onResume() {
        presenter.attachViewCallback(viewInterface);
        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.detachViewCallback();
        super.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.attachViewCallback(viewInterface);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        presenter.attachViewCallback(viewInterface);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
