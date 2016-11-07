package com.android.testrx.testrxandroid.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by Nicolas on 07/11/2016.
 */

public interface OnClickActivityListener {
    void navigateTo(Fragment fragment);
    void navigateTo(Fragment fragment, boolean addToBackStack);
}
