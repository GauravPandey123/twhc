package com.twhc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twhc.R;
import com.twhc.helper.SlideShowAdapter;
import com.twhc.helper.ViewPagerSlideshow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
