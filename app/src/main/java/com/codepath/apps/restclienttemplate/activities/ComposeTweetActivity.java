package com.codepath.apps.restclienttemplate.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

/**
 * Created by ankit on 3/2/16.
 */
public class ComposeTweetActivity extends ActionBarActivity {

    private User user;
    private ImageView ivUserPhoto;
    private TextView tvName;
    private TextView tvScreenName;
    private EditText etTweet;
    private TwitterClient client;
    private MenuItem menuItem;
    private Long parentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_tweet);
    }
}
