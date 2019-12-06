package com.kevin.planb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionInflater;

/**
 * Created by Kevin on 2019-07-10<br/>
 * Describe:<br/>
 */
public class FadeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common);
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);
    }
}
