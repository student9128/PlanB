package com.kevin.planb;

import android.app.SharedElementCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2019-07-10<br/>
 * Describe:<br/>
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_fade)
    Button btnFade;
    @BindView(R.id.btn_slide)
    Button btnSlide;
    @BindView(R.id.cl)
    ConstraintLayout cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        btnFade.setOnClickListener(this);
        btnSlide.setOnClickListener(this);
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setExitTransition(fade);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fade:
//                startActivity(new Intent(this, FadeActivity.class));
                Scene scene = Scene.getSceneForLayout(cl, R.layout.activity_main, this);
                TransitionManager.go(scene,TransitionInflater.from(this).inflateTransition(R.transition.activity_fade));
                break;
            case R.id.btn_slide:
//                startActivity(new Intent(this, SlideActivity.class));
//                Intent intent = new Intent();
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                ComponentName cn = new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.permission.ui.ManagePermissionsActivity");
//                intent.setComponent(cn);
//                startActivity(intent);
                toSelfSetting(this);
//                Intent intent = new Intent();
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
//                intent.setComponent(comp);
//                startActivity(intent);
                break;
        }
    }
    public static void toSelfSetting(Context context) {
        Intent mIntent = new Intent();
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//            mIntent.setAction(Settings.ACTION_REQUEST_SET_AUTOFILL_SERVICE);
            mIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            mIntent.setAction(Intent.ACTION_VIEW);
            mIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
            mIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(mIntent);
    }


}
