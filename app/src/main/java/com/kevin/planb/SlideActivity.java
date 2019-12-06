package com.kevin.planb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;

/**
 * Created by Kevin on 2019-07-10<br/>
 * Describe:<br/>
 */
public class SlideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common);
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        getWindow().setEnterTransition(slide);
    }
}
