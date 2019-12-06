package com.kevin.planb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_dialog)
    Button btnDialog;
    @BindView(R.id.btn_anim)
    Button btnAnim;
    @BindView(R.id.btn_dialog_2)
    Button btnDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnDialog.setOnClickListener(this);
        btnAnim.setOnClickListener(this);
        btnDialog2.setOnClickListener(this);
        AudioSensorBinder sensorBinder = new AudioSensorBinder(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.btn_anim:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.btn_dialog_2:
                startActivity(new Intent(this, DialogAnimActivity.class));
                break;
        }
    }
}
