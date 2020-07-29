package com.mikhaellopez.circularimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class CircularImageView extends View {
    public CircularImageView(Context context) {
        this(context, null);
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
