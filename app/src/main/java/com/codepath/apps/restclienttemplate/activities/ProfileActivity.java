package com.codepath.apps.restclienttemplate.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.squareup.picasso.Picasso;

/**
 * Created by ankit on 4/2/16.
 */
public class ProfileActivity extends ActionBarActivity {

    private User user;
    private TwitterClient client;
    private TextView tvUserName;
    private TextView tvDescription;
    private ImageView ivUserPhoto;
    private TextView tvTweetCount;
    private TextView tvFollowingCount;
    private TextView tvFollowerCount;
    private ImageView ivBackgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }



    private void populateViews(Bundle savedInstanceState) {

        // Find views
        tvUserName = (TextView) findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvBody);
        ivUserPhoto = (ImageView) findViewById(R.id.ivProfileImage);
        tvTweetCount = (TextView) findViewById(R.id.tvTweetCount);
        tvFollowingCount = (TextView) findViewById(R.id.tvFollowingCount);
        tvFollowerCount = (TextView) findViewById(R.id.tvFollowersCount);

        // Populate information
        tvUserName.setText(user.getName());
        tvDescription.setText(user.getDescription());
        tvTweetCount.setText(user.getTweetCount().toString() + " Tweets");
        tvFollowerCount.setText(user.getFollowerCount().toString() + " Followers");
        tvFollowingCount.setText(user.getFollowingCount().toString() + " Following");
        // Clear user photo
        ivUserPhoto.setImageResource(android.R.color.transparent);
        // Populate user photo
        Picasso.with(getApplicationContext()).load(user.getProfileImageURL()).into(ivUserPhoto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
