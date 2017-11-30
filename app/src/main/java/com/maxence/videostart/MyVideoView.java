package com.maxence.videostart;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by 27535 on 2017/11/29.
 */

public class MyVideoView extends VideoView {
    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
    public MyVideoView(Context context, AttributeSet attrs) {
       this(context, attrs,0);
    }
    public MyVideoView(Context context) {
      this(context,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

                setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }
}
