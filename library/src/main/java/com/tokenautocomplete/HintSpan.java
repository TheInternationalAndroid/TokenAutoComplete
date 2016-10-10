package com.tokenautocomplete;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.text.style.TextAppearanceSpan;

/**
 * Subclass of TextAppearanceSpan just to work with how Spans get detected
 *
 * Created on 2/3/15.
 * @author mgod
 */
public class HintSpan extends TextAppearanceSpan {
    public HintSpan(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        super(family, style, size, color, linkColor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected HintSpan(Parcel in) {
        super(in);
    }

    public static final Creator<HintSpan> CREATOR = new Creator<HintSpan>() {
        @Override
        public HintSpan createFromParcel(Parcel source) {
            return new HintSpan(source);
        }

        @Override
        public HintSpan[] newArray(int size) {
            return new HintSpan[size];
        }
    };
}
