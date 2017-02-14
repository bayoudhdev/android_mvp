package com.proxym_it.app.structure_app.commons.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;

/**
 * Created by bayoudh on 25/01/2017.
 */
public class ConversionDimensionUtils {
    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp) {
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    public static int getStatusBarHeight(Context ctx) {
        int result = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int resourceId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = ctx.getResources().getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }

    public static int getNavigationBarHeight(Context ctx, int orientation) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Resources resources = ctx.getResources();

            //has status bar
            boolean hasNavigationBar = true;


            int hasNavigationBarId = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (hasNavigationBarId > 0) {
                hasNavigationBar = resources.getBoolean(hasNavigationBarId);
                DebugLog.e("hasNavigationBar1:" + hasNavigationBar);
            } else {    // Check for keys
                boolean hasMenuKey = ViewConfiguration.get(ctx).hasPermanentMenuKey();
                boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
                hasNavigationBar = !hasMenuKey && !hasBackKey;
                DebugLog.e("hasNavigationBar2:" + hasNavigationBar);
            }

            //Emulator
            if (Build.FINGERPRINT.startsWith("generic"))
                hasNavigationBar = true;
            if (hasNavigationBar) {
                //get size
                int id = resources.getIdentifier(
                        orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_height_landscape",
                        "dimen", "android");
                if (id > 0) {
                    return resources.getDimensionPixelSize(id);
                }
            }
        }
        return 0;
    }

}
