package com.kevin.planb;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Kevin on 2019-07-10<br/>
 * Describe:<br/>
 * Dialog 可以展示在状态栏上面
 */
public class TestDialog extends Dialog {
    public TestDialog(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;//外部会失去焦点
        params.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = 300;
        params.gravity = Gravity.TOP;
        window.setAttributes(params);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setDimAmount(0);

        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(-1, -1);
        textView.setLayoutParams(l);
        textView.setText("这里是顶级view");
        textView.setTextSize(10);
        textView.setPadding(200,200,200,200);
        textView.setTextColor(Color.RED);

        setContentView(textView);
        setCancelable(true);//返回键不消失
        setCanceledOnTouchOutside(true);
        hideSystemUI(textView);

    }

    public void hideSystemUI(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
}
