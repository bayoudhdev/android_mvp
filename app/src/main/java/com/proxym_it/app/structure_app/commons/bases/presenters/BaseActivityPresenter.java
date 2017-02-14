package com.proxym_it.app.structure_app.commons.bases.presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.proxym_it.app.structure_app.R;
import com.proxym_it.app.structure_app.commons.bases.fragmentes.BaseFragment;
import com.proxym_it.app.structure_app.commons.bases.viewIntrerfaces.BaseActivityViewInterface;
import com.proxym_it.app.structure_app.commons.utils.KeybordUtils;


/**
 * Created by bayoudh on 25/01/2017.
 */
public class BaseActivityPresenter<K extends BaseActivityViewInterface> extends BasePresenter<K> {
    /**
     * return the last fragment on the backStack
     *
     * @return BaseFragment the last fragment
     */
    public BaseFragment getLastFragment(FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            int lastIndex = fragmentManager.getBackStackEntryCount() - 1;
            if (lastIndex < 0)
                lastIndex = 0;
            final String lastTag = fragmentManager.getBackStackEntryAt(lastIndex).getName();
            return (BaseFragment) fragmentManager.findFragmentByTag(lastTag);
        }
        return null;
    }

    /**
     * Get Fragment by TAG
     *
     * @param Object Fragment Class Name
     * @return
     */
    public BaseFragment getFragment(FragmentManager fragmentManager, Class Object) {
        return (BaseFragment) fragmentManager.findFragmentByTag(Object.getName());
    }


    /**
     * Return the number of entries currently in the back stack.
     *
     * @return the number of entries.
     */
    public int getBackStackEntryCount(FragmentManager fragmentManager) {
        if (fragmentManager != null)
            return fragmentManager.getBackStackEntryCount();
        return 0;
    }


    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragment(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                ft.replace(frameId, fragment, className);
                ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    public void replaceFragmentNoCondition(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        final String className = fragment.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            ft.replace(frameId, fragment, className);
            ft.addToBackStack(className);
            ft.commit();
        } else {
            ft.show(getFragment(fragmentManager, fragment.getClass()));
        }

    }

    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param activity
     * @param fragmentManager
     * @param fragment
     * @param frameId
     * @param isActivityRunning
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragment(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning,
                                @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(enter, exit, popEnter, popExit);
            if (!fragment.isAdded()) {
                ft.replace(frameId, fragment, className);
                ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }


    /**
     * Replace an existing fragment without add to stack.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void replaceFragmentNoAddToStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            if (!fragment.isAdded()) {
                ft.replace(frameId, fragment, className);
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        } else {
            ft.show(getFragment(fragmentManager, fragment.getClass()));
        }
        ft.commit();
    }

    /**
     * Replace an existing fragment without add to stack.
     *
     * @param activity
     * @param fragmentManager
     * @param fragment
     * @param frameId
     * @param isActivityRunning
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void replaceFragmentNoAddToStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning,
                                            @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            if (!fragment.isAdded()) {
                ft.replace(frameId, fragment, className);
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        } else {
            ft.show(getFragment(fragmentManager, fragment.getClass()));
        }
        ft.commit();
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragment(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                ft.add(frameId, fragment, className);
                ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    /**
     * Add a fragment to activity state with Animation
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithAnnimation(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(R.anim.enter_from_bottom, 0, 0, R.anim.exit_to_bottom);

            if (!fragment.isAdded()) {
                ft.add(frameId, fragment, className);
                ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragmentManager
     * @param fragment          The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId           Optional identifier of the container this fragment is to be placed in.
     * @param activity
     * @param isActivityRunning
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragment(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning,
                            @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(enter, exit, popEnter, popExit);
            if (!fragment.isAdded()) {
                ft.add(frameId, fragment, className);
                ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment          The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId           Optional identifier of the container this fragment is to be placed in.
     * @param isActivityRunning
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentWithoutAddToStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning,
                                             @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(enter, exit, popEnter, popExit);
            if (!fragment.isAdded()) {
                ft.add(frameId, fragment, className);
                //ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    /**
     * Add a fragment to activity state
     *
     * @param fragment The fragment to be added. This fragment must not already be added to the activity.
     * @param frameId  Optional identifier of the container this fragment is to be placed in.
     */
    public void addFragmentWithoutAddToStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (!(fragment.getClass().isInstance(getLastFragment(fragmentManager)))) {
            final String className = fragment.getClass().getName();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                ft.add(frameId, fragment, className);
                //ft.addToBackStack(className);
                ft.commit();
            } else {
                ft.show(getFragment(fragmentManager, fragment.getClass()));
            }
        }
    }

    public void removeFragment(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param frameId  Identifier of the container whose fragment(s) are to be replaced.
     */
    public void addFragmentToClearStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        // clear current stack fragment before adding new one
        clearFullStack(fragmentManager, isActivityRunning);
        final String className = fragment.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            // add new Fragment
            ft.replace(frameId, fragment, className);
            ft.addToBackStack(className);
            ft.commit();
        } else {
            ft.show(getFragment(fragmentManager, fragment.getClass()));
        }
    }

    /**
     * Clear all fragment stack
     */
    public void clearStackToLast(FragmentManager fragmentManager, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;
        for (int i = 0; i < getBackStackEntryCount(fragmentManager) - 1; i++) {
            fragmentManager.popBackStack();
        }

    }


    /**
     * Clear all fragment stack until reaching certain fragment
     */
    public void clearStackTo(FragmentManager fragmentManager, boolean isActivityRunning, String className) {
        if (!isActivityRunning)
            return;
        for (int i = getBackStackEntryCount(fragmentManager) - 1; i >= 0; i--) {
            if (className.equals(fragmentManager.getBackStackEntryAt(i).getName())) {
                return;
            }
            fragmentManager.popBackStack();
        }

    }

    /**
     * Clear current stack and replace an existing fragment that was added to a container.
     *
     * @param activity
     * @param fragmentManager
     * @param fragment          The new fragment to place in the container.
     * @param frameId           Identifier of the container whose fragment(s) are to be replaced.
     * @param isActivityRunning
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     */
    public void addFragmentToClearStack(Activity activity, FragmentManager fragmentManager, BaseFragment fragment, int frameId, boolean isActivityRunning,
                                        @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        // clear current stack fragment before adding new one
        clearFullStack(fragmentManager, isActivityRunning);
        final String className = fragment.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        if (!fragment.isAdded()) {
            // add new Fragment
            ft.replace(frameId, fragment, className);
            ft.addToBackStack(className);
            ft.commit();
        } else {
            ft.show(getFragment(fragmentManager, fragment.getClass()));
        }
    }

    /**
     * Clear all fragment stack
     */
    public void clearFullStack(FragmentManager fragmentManager, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public boolean canBack(FragmentManager fragmentManager, boolean isActivityRunning) {
        if (!isActivityRunning)
            return false;
        return getBackStackEntryCount(fragmentManager) > 0;
    }

    public void onActivityResult(FragmentManager fragmentManager, int requestCode, int resultCode, Intent data) {
        // Pass the activity result to the fragment, which will then pass the result to the login
        // button.
        BaseFragment fragment = getLastFragment(fragmentManager);
        if (fragment != null)
            fragment.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(FragmentManager fragmentManager, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        BaseFragment fragment = getLastFragment(fragmentManager);
        if (fragment != null)
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public boolean onKeyBackDown(Activity activity, FragmentManager fragmentManager, boolean isActivityRunning) {
        if (!isActivityRunning)
            return false;

        if (getLastFragment(fragmentManager) != null && !getLastFragment(fragmentManager).onBackPressed())
            onBackClick(activity, fragmentManager, isActivityRunning);
        else
            exitApp(activity, fragmentManager, isActivityRunning);
        return true;
    }

    public void onBackClick(Activity activity, FragmentManager fragmentManager, boolean isActivityRunning) {
        if (!isActivityRunning)
            return;

        KeybordUtils.hideKeyboard(activity);
        if (canBack(fragmentManager, isActivityRunning)) {
            fragmentManager.popBackStack();
        } else {
            exitApp(activity, fragmentManager, isActivityRunning);
        }
    }

    public void exitApp(final Activity activity, FragmentManager fragmentManager, boolean isActivityRunning) {
        //TODO EXIT APP
    }


}
