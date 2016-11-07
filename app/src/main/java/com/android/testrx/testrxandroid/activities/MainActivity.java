package com.android.testrx.testrxandroid.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.testrx.testrxandroid.R;
import com.android.testrx.testrxandroid.fragments.MainFragment;
import com.android.testrx.testrxandroid.interfaces.OnClickActivityListener;

public class MainActivity extends AppCompatActivity implements OnClickActivityListener {

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = null;
        fragment = MainFragment.newInstance();
        navigateTo(fragment);
    }

    @Override
    public void navigateTo(Fragment fragment) {
        navigateTo(fragment, true);
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        final FragmentManager manager = getSupportFragmentManager();

        // Removes current fragment from back stack,
        // if user presses back later he skips this fragment.
        // Avoid adding this fragment to back stack, causes fragments overlapping.
        if (!addToBackStack) {
            manager.popBackStackImmediate();
        }

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        if (mFragment == null) {
            fragmentTransaction.add(R.id.fragment_container, fragment).commit();

        } else {

            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        mFragment = fragment;
    }
}
