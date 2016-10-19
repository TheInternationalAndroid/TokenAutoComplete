package com.tokenautocomplete;

import android.content.Context;

import java.util.List;

/**
 * Created by Android Studio.
 * ProjectName: TokenAutoComplete
 * Author:  Lena
 * Date: 19/10/2016
 * Time: 4:58 PM
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
public abstract class InputFilterAdapter extends FilteredArrayAdapter<InputModel> {

    public InputFilterAdapter(Context context, int resource, InputModel[] objects) {
        super(context, resource, objects);
    }

    public InputFilterAdapter(Context context, int resource, int textViewResourceId, InputModel[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public InputFilterAdapter(Context context, int resource, List<InputModel> objects) {
        super(context, resource, objects);
    }

    public InputFilterAdapter(Context context, int resource, int textViewResourceId, List<InputModel> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
