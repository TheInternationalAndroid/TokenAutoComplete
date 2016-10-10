package com.tokenautocomplete;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Android Studio.
 * ProjectName: TokenAutoComplete
 * Author:  Lena
 * Date: 10/10/2016
 * Time: 1:05 PM
 * Handle saving the token state
 * \ ----------------------------------------
 * \| A small leak will sink a great ship.!  |
 * \ ----------------------------------------
 * \  \
 * \   \   \_\_    _/_/
 * \    \      \__/
 * \           (oo)\_______
 * \           (__)\       )\/\
 * \               ||----w |
 * \               ||     ||
 */

public class SavedState extends View.BaseSavedState {
    CharSequence prefix;
    boolean allowCollapse;
    boolean allowDuplicates;
    boolean performBestGuess;
    TokenCompleteTextView.TokenClickStyle tokenClickStyle;
    TokenCompleteTextView.TokenDeleteStyle tokenDeleteStyle;
    ArrayList<Serializable> baseObjects;
    char[] splitChar;

    @SuppressWarnings("unchecked")
    SavedState(Parcel in) {
        super(in);
        prefix = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        allowCollapse = in.readInt() != 0;
        allowDuplicates = in.readInt() != 0;
        performBestGuess = in.readInt() != 0;
        tokenClickStyle = TokenCompleteTextView.TokenClickStyle.values()[in.readInt()];
        tokenDeleteStyle = TokenCompleteTextView.TokenDeleteStyle.values()[in.readInt()];
        baseObjects = (ArrayList<Serializable>) in.readSerializable();
        splitChar = in.createCharArray();
    }

    SavedState(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(@NonNull Parcel out, int flags) {
        super.writeToParcel(out, flags);
        TextUtils.writeToParcel(prefix, out, 0);
        out.writeInt(allowCollapse ? 1 : 0);
        out.writeInt(allowDuplicates ? 1 : 0);
        out.writeInt(performBestGuess ? 1 : 0);
        out.writeInt(tokenClickStyle.ordinal());
        out.writeInt(tokenDeleteStyle.ordinal());
        out.writeSerializable(baseObjects);
        out.writeCharArray(splitChar);
    }

    @Override
    public String toString() {
        String str = "TokenCompleteTextView.SavedState{"
                + Integer.toHexString(System.identityHashCode(this))
                + " tokens=" + baseObjects;
        return str + "}";
    }

    @SuppressWarnings("hiding")
    public static final Parcelable.Creator<SavedState> CREATOR
            = new Parcelable.Creator<SavedState>() {
        public SavedState createFromParcel(Parcel in) {
            return new SavedState(in);
        }

        public SavedState[] newArray(int size) {
            return new SavedState[size];
        }
    };
}
