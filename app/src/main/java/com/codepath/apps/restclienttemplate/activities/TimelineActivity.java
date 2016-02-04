package com.codepath.apps.restclienttemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent i = new Intent(TimelineActivity.this, ComposeTweetActivity.class);
            startActivity(i);

            return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void onProfileView(MenuItem mi) {
        // Open Profile Activity
        Intent i = new Intent(TimelineActivity.this, ProfileActivity.class);
        startActivity(i);
    }
}
