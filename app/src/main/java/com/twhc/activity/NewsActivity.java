package com.twhc.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.twhc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gaurav on 14/10/17.
 */

public class NewsActivity extends BaseActivity {

    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        textViewTitle.setText("NEWS");
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}


