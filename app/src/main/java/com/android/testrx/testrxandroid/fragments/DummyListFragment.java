package com.android.testrx.testrxandroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.testrx.testrxandroid.R;
import com.android.testrx.testrxandroid.adapters.DummyContentAdapter;
import com.android.testrx.testrxandroid.interfaces.OnClickActivityListener;
import com.android.testrx.testrxandroid.models.DummyContent;

import java.util.ArrayList;

/**
 * Created by Nicolas on 07/11/2016.
 */

public class DummyListFragment extends Fragment {

    private ArrayList<DummyContent> mDummyList;
    private DummyContentAdapter mDummyAdapter;
    private OnClickActivityListener mListener;
    private RecyclerView mReciclerView;

    public DummyListFragment() {
    }

    public static DummyListFragment newInstance() {
        DummyListFragment fragment = new DummyListFragment();
        return fragment;
    }

    public static DummyListFragment newInstance(Bundle args) {
        DummyListFragment fragment = new DummyListFragment();
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
        View mView = inflater.inflate(R.layout.dummy_content_list, container, false);

        mReciclerView = (RecyclerView) mView.findViewById(R.id.item_list);

        mDummyList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            mDummyList.add(new DummyContent(R.mipmap.ic_launcher, "Dummy Content "+i));
        }

        mDummyAdapter = new DummyContentAdapter(mDummyList, mListener);
        mReciclerView.setAdapter(mDummyAdapter);

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
