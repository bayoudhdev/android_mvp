package com.mvp.project.commons.bases.fragmentes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mvp.project.commons.bases.presenters.BaseDialogFragmentPresenter;
import com.mvp.project.commons.bases.viewIntrerfaces.BaseDialogFragmentViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BasePresenterDialogFragment<P extends BaseDialogFragmentPresenter<O>, O extends BaseDialogFragmentViewInterface> extends BaseActivityDialogFragment {

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        setViewInterface();
        presenter.attachViewCallback(viewInterface);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachViewCallback(viewInterface);
    }

    @Override
    public void onPause() {
        presenter.detachViewCallback();
        super.onPause();
    }
}
