package com.codepath.apps.restclienttemplate.activities;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

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
}
