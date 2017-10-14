package com.twhc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.twhc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gaurav on 14/10/17.
 */

public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        textViewTitle.setText("ABOUTUS");
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
