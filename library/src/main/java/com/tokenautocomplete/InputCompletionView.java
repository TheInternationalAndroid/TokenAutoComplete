package com.tokenautocomplete;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Sample token completion view for basic contact info
 * <p>
 * Created on 9/12/13.
 *
 * @author mgod
 */
public class InputCompletionView extends TokenCompleteTextView<InputModel> {

    public InputCompletionView(Context context) {
        super(context);
    }

    public InputCompletionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputCompletionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View getViewForObject(InputModel inputModel) {
        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TokenTextView tokenTextView = (TokenTextView) l.inflate(R.layout.layout_test, (ViewGroup) getParent(), false);
        tokenTextView.setText(inputModel.getInput());
        return tokenTextView;
    }

    @Override
    protected InputModel defaultObject(String completionText) {
        return new InputModel(completionText, completionText);
    }
}
