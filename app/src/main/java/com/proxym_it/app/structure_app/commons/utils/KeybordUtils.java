package com.proxym_it.app.structure_app.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by bayoudh on 25/01/2017.
 */
public class KeybordUtils {

    public static void hideKeyboard(Activity mActivity) {
        if (mActivity != null) {
            try {
                InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showKeyboard(Activity mActivity, EditText yourEditText) {
        if (mActivity != null) {
            try {
                InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);


                imm.showSoftInput(yourEditText, InputMethodManager.SHOW_IMPLICIT);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
