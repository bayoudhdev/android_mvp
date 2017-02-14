package com.proxym_it.app.structure_app.commons.bases.fragmentes;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.proxym_it.app.structure_app.commons.bases.presenters.BaseDialogFragmentPresenter;
import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseDialogFragmentViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseDialogFragment<P extends BaseDialogFragmentPresenter<O>, O extends BaseDialogFragmentViewInterface> extends BasePresenterDialogFragment<P, O> implements View.OnSystemUiVisibilityChangeListener {

    /**
     * Check is fragment run on foreground
     *
     * @return fragment status
     */
    public boolean isFragmentRunning() {
        return isAdded() && !isDetached() && !isHidden() && !isRemoving() && !getActivity().isFinishing();
    }

    public abstract boolean onBackPressed();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        hideSystemNavigationBar();
        initSystemUiVisibilityChangeListener();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * This method used to hide bottom nav bar and make animation
     * when scroll from bottom to sow the action back button nexus
     */
    private void hideSystemNavigationBar() {
        if (getDialog() == null)
            return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getDialog().getWindow();
            if (window == null)
                return;

            View decorView = window.getDecorView();
            if (decorView == null)
                return;

            int uiOptions =
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    private void initSystemUiVisibilityChangeListener() {
        if (getDialog() == null)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getDialog().getWindow();
            if (window == null)
                return;

            View decorView = window.getDecorView();
            if (decorView == null)
                return;

            decorView.setOnSystemUiVisibilityChangeListener(this);
        }
    }

    @Override
    public void onSystemUiVisibilityChange(int visibility) {
        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
            hideSystemNavigationBar();
    }


}