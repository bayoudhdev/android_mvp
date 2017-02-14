package com.mvp.project.commons.bases.presenters;

import android.support.annotation.AnimRes;

import com.mvp.project.commons.bases.activities.BaseActivity;
import com.mvp.project.commons.bases.fragmentes.BaseFragment;
import com.mvp.project.commons.bases.viewIntrerfaces.BaseFragmentViewInterface;

/**
 * Created by bayoudh on 25/01/2017.
 */
public class BaseFragmentPresenter<K extends BaseFragmentViewInterface> extends BasePresenter<K> {


    /**
     * return the last fragment on the backStack
     *
     * @return BaseFragment the last fragment
     */
    public BaseFragment getLastFragment(BaseActivity baseActivity) {
        if (baseActivity != null)
            return baseActivity.getLastFragment();
        return null;
    }

    /**
     * Get Fragment by TAG
     *
     * @param Object Fragment Class Name
     * @return
     */
    public BaseFragment getFragment(BaseActivity baseActivity, Class Object) {
        if (baseActivity != null)
            return baseActivity.getFragment(Object);
        return null;
    }


    /**
     * Return the number of entries currently in the back stack.
     *
     * @return the number of entries.
     */
    public int getBackStackEntryCount(BaseActivity baseActivity) {
        if (baseActivity != null)
            return baseActivity.getBackStackEntryCount();
        return 0;
    }


    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragment(BaseActivity baseActivity, BaseFragment fragment, int frameId) {
        if (baseActivity != null)
            baseActivity.replaceFragment(fragment, frameId);
    }

    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param baseActivity
     * @param fragment     The new fragment to place in the container.
     * @param frameId      Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragment(BaseActivity baseActivity, BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (baseActivity != null)
            baseActivity.replaceFragment(fragment, frameId, enter, exit, popEnter, popExit);
    }


    /**
     * Replace an existing fragment without add to stack.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragmentNoAddToStack(BaseActivity baseActivity, BaseFragment fragment, int frameId) {
        if (baseActivity != null)
            baseActivity.replaceFragmentNoAddToStack(fragment, frameId);
    }

    /**
     * Replace an existing fragment without add to stack.
     *
     * @param baseActivity
     * @param fragment     The new fragment to place in the container.
     * @param frameId      Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragmentNoAddToStack(BaseActivity baseActivity, BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (baseActivity != null)
            baseActivity.replaceFragmentNoAddToStack(fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragment(BaseActivity baseActivity, BaseFragment fragment, int frameId) {
        if (baseActivity != null)
            baseActivity.addFragment(fragment, frameId);
    }

    /**
     * Add a fragment to activity state
     *
     * @param baseActivity
     * @param fragment     The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId      Optional identifier of the container this fragment is to be placed in.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragment(BaseActivity baseActivity, BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (baseActivity != null)
            baseActivity.addFragment(fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithoutAddToStack(BaseActivity baseActivity, BaseFragment fragment, int frameId) {
        if (baseActivity != null)
            baseActivity.addFragmentWithoutAddToStack(fragment, frameId);
    }

    /**
     * Add a fragment to activity state
     *
     * @param baseActivity
     * @param fragment     The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId      Optional identifier of the container this fragment is to be placed in.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentWithoutAddToStack(BaseActivity baseActivity, BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (baseActivity != null)
            baseActivity.addFragmentWithoutAddToStack(fragment, frameId, enter, exit, popEnter, popExit);
    }

    public void removeFragment(BaseActivity baseActivity, BaseFragment fragment) {
        if (baseActivity != null)
            baseActivity.removeFragment(fragment);
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void addFragmentToClearStack(BaseActivity baseActivity, BaseFragment fragment, int frameId) {
        if (baseActivity != null)
            baseActivity.addFragmentToClearStack(fragment, frameId);
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param baseActivity
     * @param fragment     The new fragment to place in the container.
     * @param frameId      Identifier of the container whose fragment(s) are to be replaced.
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentToClearStack(BaseActivity baseActivity, BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (baseActivity != null)
            baseActivity.addFragmentToClearStack(fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Clear all fragment stack
     */
    public void clearFullStack(BaseActivity baseActivity) {
        if (baseActivity != null)
            baseActivity.clearFullStack();
    }


}
