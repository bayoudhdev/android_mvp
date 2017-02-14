package com.mvp.project.commons.utils;

import android.content.pm.PackageManager;

/**
 * Created by bayoudh on 25/01/2017.
 */
public class Utils {
    public static boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


}
