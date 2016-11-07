package com.android.testrx.testrxandroid.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.testrx.testrxandroid.R;
import com.android.testrx.testrxandroid.interfaces.OnClickActivityListener;
import com.android.testrx.testrxandroid.models.DummyContent;

import java.util.List;

/**
 * Created by Nicolas on 07/11/2016.
 */

public class DummyContentAdapter extends RecyclerView.Adapter<DummyContentAdapter.ViewHolder> {

    private final List<DummyContent> mValues;
    private OnClickActivityListener mListener;
    private Context mContext;
    private TypedArray mImgs;

    public DummyContentAdapter(List<DummyContent> mValues, OnClickActivityListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public DummyContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DummyContentAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mAppName.setText(holder.mItem.getTextTitle());
        holder.mImage.setImageResource(holder.mItem.getImage());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView mImage;
        public final TextView mAppName;

        public DummyContent mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImage = (ImageView) view.findViewById(R.id.ivIcon);
            mAppName = (TextView) view.findViewById(R.id.tvText);

        }
    }
}
