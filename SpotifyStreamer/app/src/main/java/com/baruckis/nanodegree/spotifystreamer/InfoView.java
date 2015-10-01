package com.baruckis.nanodegree.spotifystreamer;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Andrius-Baruckis on 2015.
 * http://www.baruckis.com/
 */

/*
* This is custom view component which allows
* to show messages for initial screen or for
* empty list. Also it can show error message
* with icon and button to retry action.
* */
public class InfoView extends LinearLayout {

    public static final String STATE_IS_ERROR = "is_error";

    private ImageView mIconImageView;
    private TextView mMessageTextView;
    private Button mButton;

    private boolean mIsError;

    /*
     * Constructors
     * */
    public InfoView(Context context) {
        super(context);
        init();
    }

    public InfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(11)
    public InfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public InfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /*
     * Methods
     * */
    private void init() {
        hide();
        inflate(getContext(), R.layout.info_view, this);
        mIconImageView = (ImageView) findViewById(R.id.icon);
        mMessageTextView = (TextView) findViewById(R.id.message);
        mButton = (Button) findViewById(R.id.button);
        mIsError = false;
    }

    public void showEmpty(String message) {
        this.setVisibility(View.VISIBLE);
        mMessageTextView.setText(message);
        mIconImageView.setImageDrawable(null);
        mButton.setVisibility(View.GONE);
        mIsError = false;
    }

    public void showError(String message, OnClickListener onClickListener) {
        this.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.VISIBLE);
        mMessageTextView.setText(message);
        mIconImageView.setImageResource(R.drawable.ic_error_outline_black_48dp);
        mButton.setOnClickListener(onClickListener);
        mIsError = true;
    }

    public void hide() {
        this.setVisibility(View.GONE);
    }

    public boolean getIsError() {
        return mIsError;
    }

    public void setIsError(boolean value) {
        mIsError = value;
    }
}
