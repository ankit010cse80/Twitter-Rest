package com.codepath.apps.restclienttemplate.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.codepath.apps.restclienttemplate.R;

/**
 * Created by ankit on 3/2/16.
 */
public class TimelineActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Get view pager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);

    }
}
