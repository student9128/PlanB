package com.kevin.planb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2019-12-06<br/>
 * Blog:http://student9128.top/
 * 公众号：竺小竹
 * Describe:<br/>
 */
public class DialogAnimActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_anim);
        ButterKnife.bind(this);
        final AnimDialog animDialog = new AnimDialog(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animDialog.show();
            }
        });
    }
}
