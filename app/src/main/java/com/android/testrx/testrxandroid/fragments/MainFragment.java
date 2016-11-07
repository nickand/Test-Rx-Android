package com.android.testrx.testrxandroid.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.testrx.testrxandroid.R;
import com.android.testrx.testrxandroid.interfaces.OnClickActivityListener;

/**
 * Created by Nicolas on 07/11/2016.
 */

public class MainFragment extends Fragment {
    private Button mButtonNormalRx;
    private Button mButtonRxRetrofit;
    private OnClickActivityListener mListener;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_main, container, false);

        mButtonNormalRx = (Button) mView.findViewById(R.id.btnNormalList);
        mButtonRxRetrofit = (Button) mView.findViewById(R.id.btnListFromService);

        mButtonNormalRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DummyListFragment fragment = new DummyListFragment();
                mListener.navigateTo(fragment);
            }
        });

        mButtonRxRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DummyListFragment fragment = new DummyListFragment();
                mListener.navigateTo(fragment);
            }
        });

        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnClickActivityListener) {
            mListener = (OnClickActivityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnClickActivityListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
