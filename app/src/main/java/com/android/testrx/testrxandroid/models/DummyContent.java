package com.android.testrx.testrxandroid.models;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nicolas on 07/11/2016.
 */

public class DummyContent {
    private int image;
    private String textTitle;

    public DummyContent() {

    }

    public DummyContent(int image, String textTitle) {
        this.image = image;
        this.textTitle = textTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
}
