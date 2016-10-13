package com.tokenautocomplete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by mgod on 5/27/15.
 * <p>
 * Simple custom view example to show how to get selected events from the token
 * view. See ContactsCompletionView and contact_token.xml for usage
 */
public class TokenTextView extends TextView {

    public TokenTextView(Context context) {
        super(context);
//        init(context, null, 0);
    }

    public TokenTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init(context, attrs, 0);
    }

    public TokenTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init(context, attrs, defStyleAttr);
    }

//    private void init(Context context, AttributeSet attrs, int defStyle) {
//        final Resources.Theme theme = context.getTheme();
//        TypedArray a = theme.obtainStyledAttributes(
//                attrs, R.styleable.TokenTextView, defStyle, R.style.TokenStyle);
//
//        final ColorStateList tokenTextColor = a.getColorStateList(R.styleable.TokenTextView_tokenTextColor);
//        final Drawable tokenBackground = a.getDrawable(R.styleable.TokenTextView_tokenBackground);
//        final int tokenPaddingTop = a.getDimensionPixelSize(R.styleable.TokenTextView_tokenPaddingTop, 0);
//        final int tokenPaddingLeft = a.getDimensionPixelSize(R.styleable.TokenTextView_tokenPaddingLeft, 0);
//        final int tokenPaddingRight = a.getDimensionPixelSize(R.styleable.TokenTextView_tokenPaddingRight, 0);
//        final int tokenPaddingBottom = a.getDimensionPixelSize(R.styleable.TokenTextView_tokenPaddingBottom, 0);
//        final int tokenMaxLines = a.getInt(R.styleable.TokenTextView_tokenMaxLines, 1);
//        final int ellipsize = a.getInt(R.styleable.TokenTextView_tokenEllipsize, -1);
//
//        if (tokenTextColor != null)
//            setTextColor(tokenTextColor);
//        if (tokenBackground != null) {
//            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
//                setBackground(tokenBackground);
//            } else {
//                setBackgroundDrawable(tokenBackground);
//            }
//        }
//        setPadding(tokenPaddingLeft, tokenPaddingTop, tokenPaddingRight, tokenPaddingBottom);
//        setMaxLines(tokenMaxLines);
//        switch (ellipsize) {
//            case 1:
//                setEllipsize(TextUtils.TruncateAt.START);
//                break;
//            case 2:
//                setEllipsize(TextUtils.TruncateAt.MIDDLE);
//                break;
//            case 3:
//                setEllipsize(TextUtils.TruncateAt.END);
//                break;
//            case 4:
////                Ignore
//                break;
//        }
//        a.recycle();
//    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, selected ? 0 : 0, 0);
    }
}
