package com.proxym_it.app.structure_app.commons.bases.presenters;

import android.support.annotation.NonNull;

import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseViewInterface;

import java.lang.ref.WeakReference;

/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BasePresenter<V extends BaseViewInterface> {

    private WeakReference<V> viewCallback;

    public void attachViewCallback(V viewCallback) {
        this.viewCallback = new WeakReference<>(viewCallback);
    }

    @NonNull
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