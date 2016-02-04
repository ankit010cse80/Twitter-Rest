package com.codepath.apps.restclienttemplate.activities;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

/**
 * Created by ankit on 4/2/16.
 */
public class TweetDetailActivity extends ActionBarActivity {

    private ImageView ivUserPhoto;
    private TextView tvUserName;
    private TextView tvScreenName;
    private TextView tvTweetDetail;
    private TextView tvTimestamp;
    private TextView tvTweetCount;
    private TextView tvFavoritesCount;
    private ImageButton btnReply;
    private TwitterClient client = TwitterApplication.getRestClient();

}
