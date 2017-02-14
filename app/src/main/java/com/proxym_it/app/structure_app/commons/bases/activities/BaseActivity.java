package com.proxym_it.app.structure_app.commons.bases.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;

import com.proxym_it.app.structure_app.commons.bases.fragmentes.BaseFragment;
import com.proxym_it.app.structure_app.commons.bases.presenters.BaseActivityPresenter;
import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseActivityViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseActivity<P extends BaseActivityPresenter<O>, O extends BaseActivityViewInterface> extends BasePresenterActivity<P, O> {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public boolean isInFront;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        isInFront = true;

    }

    @Override
    protected void onResume() {
        super.onResume();
        isInFront = true;
    }

    @Override
    protected void onPause() {
        isInFront = false;
        super.onPause();
    }

    /**
     * Check is fragment run on foreground
     *
     * @return fragment status
     */
    public boolean isActivityRunning() {
        return isInFront && !isFinishing();
    }

    /**
     * //     * return the last fragment on the backStack
     * //     *
     * //     * @return BaseFragment the last fragment
     * //
     */
    public BaseFragment getLastFragment() {
        if (presenter != null)
            return presenter.getLastFragment(getSupportFragmentManager());
        return null;
    }

    /**
     * Get Fragment by TAG
     *
     * @param object Fragment Class Name
     * @return
     */
    public BaseFragment getFragment(Class object) {
        if (presenter != null)
            return presenter.getFragment(getSupportFragmentManager(), object);
        return null;
    }

    /**
     * Return the number of entries currently in the back stack.
     *
     * @return the number of entries.
     */
    public int getBackStackEntryCount() {
        if (presenter != null)
            return presenter.getBackStackEntryCount(getSupportFragmentManager());
        return 0;
    }

    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragment(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.replaceFragment(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }


    /**
     * Replace an existing fragment that was added to a container. Even if already exists
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragmentNoCondition(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.replaceFragmentNoCondition(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragment(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null)
            presenter.replaceFragment(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning(), enter, exit, popEnter, popExit);
    }

    /**
     * Replace an existing fragment without add to stack.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragmentNoAddToStack(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.replaceFragmentNoAddToStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Replace an existing fragment without add to stack.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragmentNoAddToStack(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null)
            presenter.replaceFragmentNoAddToStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning(), enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragment(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.addFragment(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragment(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null)
            presenter.addFragment(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning(), enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithoutAddToStack(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.addFragmentWithoutAddToStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Add a fragment to activity state with animation
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithAnnimation(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.addFragmentWithAnnimation(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentWithoutAddToStack(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null)
            presenter.addFragmentWithoutAddToStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning(), enter, exit, popEnter, popExit);
    }

    public void removeFragment(BaseFragment fragment) {
        if (presenter != null)
            presenter.removeFragment(this, getSupportFragmentManager(), fragment, isActivityRunning());
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void addFragmentToClearStack(BaseFragment fragment, int frameId) {
        if (presenter != null)
            presenter.addFragmentToClearStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning());
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentToClearStack(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null)
            presenter.addFragmentToClearStack(this, getSupportFragmentManager(), fragment, frameId, isActivityRunning(), enter, exit, popEnter, popExit);
    }

    /**
     * Clear all fragment stack
     */
    public void clearFullStack() {
        if (presenter != null)
            presenter.clearFullStack(getSupportFragmentManager(), isActivityRunning());
    }

    /**
     * Clear all fragment stack
     */
    public void clearStackToLast() {
        if (presenter != null)
            presenter.clearStackToLast(getSupportFragmentManager(), isActivityRunning());
    }

    public void clearStackTo(String className) {
        if (presenter != null)
            presenter.clearStackTo(getSupportFragmentManager(), isActivityRunning(), className);
    }

    public boolean canBack() {
        if (presenter != null)
            return presenter.canBack(getSupportFragmentManager(), isActivityRunning());
        return false;
    }

    /**
     * Method used to exit Application
     */
    public void exitApp() {
        if (presenter != null)
            presenter.exitApp(this, getSupportFragmentManager(), isActivityRunning());
    }

    protected void onBackClick() {
        if (presenter != null)
            presenter.onBackClick(this, getSupportFragmentManager(), isActivityRunning());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (presenter != null)
            presenter.onActivityResult(getSupportFragmentManager(), requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (presenter != null)
            presenter.onRequestPermissionsResult(getSupportFragmentManager(), requestCode, permissions, grantResults);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (presenter != null)
                return presenter.onKeyBackDown(this, getSupportFragmentManager(), isActivityRunning());
        }
        return super.onKeyDown(keyCode, event);
    }


}
