package com.twhc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twhc.R;
import com.twhc.helper.SlideShowAdapter;
import com.twhc.helper.ViewPagerSlideshow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.slideshow)
    ViewPagerSlideshow slideshow;
    @BindView(R.id.aboutus)
    ImageView aboutus;
    @BindView(R.id.product)
    ImageView product;
    @BindView(R.id.visual)
    ImageView visual;
    @BindView(R.id.news)
    ImageView news;
    @BindView(R.id.enquiry)
    ImageView enquiry;
    @BindView(R.id.contact_us)
    ImageView contactUs;
    @BindView(R.id.container)
    LinearLayout container;
    Intent intent;
    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageViewBack.setVisibility(View.GONE);
        String URLS[] = new String[]{
                "http://i.imgur.com/5g697Ao.jpg",
                "http://i.imgur.com/z7v35T7.jpg",
                "http://i.imgur.com/7v6awZj.jpg",
                "http://i.imgur.com/6dMetEv.png",
                "http://i.imgur.com/49ZuJY1.jpg"
        };

        ViewPagerSlideshow slideshow = (ViewPagerSlideshow) findViewById(R.id.slideshow);
        SlideShowAdapter adapter = new SlideShowAdapter(getSupportFragmentManager(), URLS);
        slideshow.setAdapter(adapter);
    }

    @OnClick({R.id.slideshow, R.id.aboutus, R.id.product, R.id.visual, R.id.news, R.id.enquiry, R.id.contact_us})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.slideshow:
                break;
            case R.id.aboutus:
                intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.product:
                intent = new Intent(MainActivity.this, ProductListingActivity.class);
                startActivity(intent);
                break;
            case R.id.visual:
                intent = new Intent(MainActivity.this, VisualCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.news:
                intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.enquiry:
                intent = new Intent(MainActivity.this, EnquiryActivity.class);
                startActivity(intent);
                break;
            case R.id.contact_us:
                intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
