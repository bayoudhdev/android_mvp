package com.mvp.project.commons.bases.fragmentes;

import android.support.annotation.AnimRes;

import com.mvp.project.commons.bases.presenters.BaseFragmentPresenter;
import com.mvp.project.commons.bases.viewIntrerfaces.BaseFragmentViewInterface;


/**
 * Created by bayoudh on 25/01/2017.
 */
public abstract class BaseFragment<P extends BaseFragmentPresenter<O>, O extends BaseFragmentViewInterface> extends BasePresenterFragment<P, O> {

    /**
     * Check is fragment run on foreground
     *
     * @return fragment status
     */
    public boolean isFragmentRunning() {
        return isAdded() && !isDetached() && !isHidden() && !isRemoving() && !getActivity().isFinishing();
    }

    public abstract boolean onBackPressed();

    /**
     * return the last fragment on the backStack
     *
     * @return BaseFragment the last fragment
     */
    public BaseFragment getLastFragment() {
        if (presenter != null && baseActivity != null)
            return presenter.getLastFragment(baseActivity);
        return null;
    }

    /**
     * Get Fragment by TAG
     *
     * @param object Fragment Class Name
     * @return
     */
    public BaseFragment getFragment(Class object) {
        if (presenter != null && baseActivity != null)
            return presenter.getFragment(baseActivity, object);
        return null;
    }

    /**
     * Return the number of entries currently in the back stack.
     *
     * @return the number of entries.
     */
    public int getBackStackEntryCount() {
        if (presenter != null && baseActivity != null)
            return presenter.getBackStackEntryCount(baseActivity);
        return 0;
    }


    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragment(BaseFragment fragment, int frameId) {
        if (presenter != null && baseActivity != null)
            presenter.replaceFragment(baseActivity, fragment, frameId);
    }

    public void replaceFragment(BaseFragment fragment, int frameId, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (presenter != null && baseActivity != null)
            presenter.replaceFragment(baseActivity, fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Replace an existing fragment without add to stack.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragmentNoAddToStack(BaseFragment fragment, int frameId) {
        if (presenter != null && baseActivity != null)
            presenter.replaceFragmentNoAddToStack(baseActivity, fragment, frameId);
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
        if (presenter != null && baseActivity != null)
            presenter.replaceFragmentNoAddToStack(baseActivity, fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragment(BaseFragment fragment, int frameId) {
        if (presenter != null && baseActivity != null)
            presenter.addFragment(baseActivity, fragment, frameId);
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
        if (presenter != null && baseActivity != null)
            presenter.addFragment(baseActivity, fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithoutAddToStack(BaseFragment fragment, int frameId) {
        if (presenter != null && baseActivity != null)
            presenter.addFragmentWithoutAddToStack(baseActivity, fragment, frameId);
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
        if (presenter != null && baseActivity != null)
            presenter.addFragmentWithoutAddToStack(baseActivity, fragment, frameId, enter, exit, popEnter, popExit);
    }

    public void removeFragment(BaseFragment fragment) {
        if (presenter != null && baseActivity != null)
            presenter.removeFragment(baseActivity, fragment);
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void addFragmentToClearStack(BaseFragment fragment, int frameId) {
        if (presenter != null && baseActivity != null)
            presenter.addFragmentToClearStack(baseActivity, fragment, frameId);
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
        if (presenter != null && baseActivity != null)
            presenter.addFragmentToClearStack(baseActivity, fragment, frameId, enter, exit, popEnter, popExit);
    }

    /**
     * Clear all fragment stack
     */
    public void clearFullStack() {
        if (presenter != null && baseActivity != null)
            presenter.clearFullStack(baseActivity);
    }


}