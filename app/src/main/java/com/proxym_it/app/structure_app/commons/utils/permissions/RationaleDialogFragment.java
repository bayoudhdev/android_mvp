package com.proxym_it.app.structure_app.commons.utils.permissions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;

/**
 * Created by bayoudh on 25/01/2017.
 * <p>
 * {@link DialogFragment} to display rationale for permission requests when the request comes from
 * a Fragment or Activity that can host a Fragment.
 */
@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
public class RationaleDialogFragment extends DialogFragment {

    private ActivePermissions.PermissionCallbacks permissionCallbacks;
    private RationaleDialogConfig config;
    private RationaleDialogClickListener clickListener;

    static RationaleDialogFragment newInstance(
            @StringRes int positiveButton, @StringRes int negativeButton,
            @NonNull String rationaleMsg, int requestCode, @NonNull String[] permissions) {

        // Create new Fragment
        RationaleDialogFragment dialogFragment = new RationaleDialogFragment();

        // Initialize configuration as arguments
        RationaleDialogConfig config = new RationaleDialogConfig(
                positiveButton, negativeButton, rationaleMsg, requestCode, permissions);
        dialogFragment.setArguments(config.toBundle());

        return dialogFragment;
    }

    @SuppressLint("NewApi")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // getParentFragment() requires API 17 or higher
        boolean isAtLeastJellyBeanMR1 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;

        if (isAtLeastJellyBeanMR1
                && getParentFragment() != null
                && getParentFragment() instanceof ActivePermissions.PermissionCallbacks) {
            permissionCallbacks = (ActivePermissions.PermissionCallbacks) getParentFragment();
        } else if (context instanceof ActivePermissions.PermissionCallbacks) {
            permissionCallbacks = (ActivePermissions.PermissionCallbacks) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        permissionCallbacks = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Rationale dialog should not be cancelable
        setCancelable(false);

        // Get config from arguments, create click listener
        config = new RationaleDialogConfig(getArguments());
        clickListener = new RationaleDialogClickListener(this, config, permissionCallbacks);

        // Create an AlertDialog
        return config.createDialog(getActivity(), clickListener);
    }

}
