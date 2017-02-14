package com.mvp.project.commons.bases.presenters;


import com.mvp.project.commons.bases.viewIntrerfaces.BaseViewInterface;

import java.lang.ref.WeakReference;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseAbstractPresenter<V extends BaseViewInterface> {

    private WeakReference<V> viewCallback;

    public void attachViewCallback(V viewCallback) {
        this.viewCallback = new WeakReference<>(viewCallback);
    }

    public V getViewCallback() {
        return viewCallback == null ? null : viewCallback.get();
    }

    public boolean isViewCallbackAttached() {
        return viewCallback != null && viewCallback.get() != null;
    }

    public void detachViewCallback() {
        if (viewCallback != null) {
            viewCallback.clear();
            viewCallback = null;
        }
    }
}