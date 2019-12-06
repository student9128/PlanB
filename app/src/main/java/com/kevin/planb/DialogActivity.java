package com.kevin.planb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2019-07-10<br/>
 * Describe:<br/>
 */
public class DialogActivity extends AppCompatActivity {
    @BindView(R.id.btn_show)
    Button btnShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        final TestDialog dialog = new TestDialog(this);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
