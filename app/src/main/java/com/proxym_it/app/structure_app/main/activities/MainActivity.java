package com.proxym_it.app.structure_app.main.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.proxym_it.app.structure_app.R;
import com.proxym_it.app.structure_app.commons.bases.activities.BaseActivity;
import com.proxym_it.app.structure_app.commons.utils.permissions.ActivePermissions;
import com.proxym_it.app.structure_app.commons.utils.permissions.AfterPermissionGranted;
import com.proxym_it.app.structure_app.commons.utils.permissions.AppSettingsDialog;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainActivityPresenter, MainActivityViewInterface> implements MainActivityViewInterface
        , View.OnClickListener
        , ActivePermissions.PermissionCallbacks {

    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_SETTINGS_SCREEN = 125;
    private static final String TAG = "MainActivity";
    @BindView(R.id.button_camera)
    AppCompatButton mCheckCameraPermission;

    @NonNull
    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }

    @NonNull
    @Override
    public MainActivityViewInterface createViewInterface() {
        return this;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckCameraPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cameraTask();
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() {
        if (ActivePermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            // Have permission, do the thing!
            Toast.makeText(this, "TODO: Camera things ;)", Toast.LENGTH_LONG).show();
        } else {
            // Ask for one permission
            ActivePermissions.requestPermissions(this, getString(R.string.rationale_camera),
                    RC_CAMERA_PERM, Manifest.permission.CAMERA);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        ActivePermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SETTINGS_SCREEN) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(this, R.string.returned_from_app_settings_to_activity, Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (ActivePermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, getString(R.string.rationale_ask_again))
                    .setTitle(getString(R.string.title_settings_dialog))
                    .setPositiveButton(getString(R.string.setting))
                    .setNegativeButton(getString(R.string.cancel), null /* click listener */)
                    .setRequestCode(RC_SETTINGS_SCREEN)
                    .build()
                    .show();
        }
    }
}
