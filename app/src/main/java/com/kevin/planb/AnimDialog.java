package com.kevin.planb;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;


/**
 * Created by Kevin on 2019-12-06<br/>
 * Blog:http://student9128.top/
 * 公众号：竺小竹
 * Describe:<br/>
 */
public class AnimDialog extends Dialog {
    private LinearLayout linearLayout;
    private int measuredHeight;
    private int measuredWidth;
    private int windowY;
    private int heightPixels;
    private int pY;
private Context context;
    public AnimDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_anim);
        final WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        Point p = new Point();
        defaultDisplay.getSize(p);
        int x = p.x;
        windowY = p.y;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        heightPixels = displayMetrics.heightPixels;
        Log.d("AnimDialog", "x=" + x + ",y=" + windowY);
        Log.d("AnimDialog", "heightPixels=" + heightPixels);
        Point point = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getRealSize(point);
//        getWindow().setBackgroundDrawableResource(R.drawable.ic_w);
        int pX = point.x;
        pY = point.y;
        Log.d("AnimDialog", "PY=" + pY);
        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                linearLayout = findViewById(R.id.ll_container);
                int height = linearLayout.getHeight();
                //获取屏幕高度，获取控件高度，设置dialog顶端距离屏幕顶端的位置
                attributes.y = (windowY) / 2-height/2-getStatusBarHeight(context);
                getWindow().setGravity(Gravity.TOP);

                Log.d("AnimDialog", "height=" + height);
                ValueAnimator animator = createAnimator(linearLayout, 0, height);
                animator.setDuration(600);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

            }
        });
    }

//    @Override
//    public void show() {
//        super.show();
//        ValueAnimator animator = createAnimator(linearLayout, 0, measuredHeight);
//        animator.start();
//
//    }

    private ValueAnimator createAnimator(final View v, int start, int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int animatedValue = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.height = animatedValue;
                v.setLayoutParams(layoutParams);
            }
        });
        return valueAnimator;
    }
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
