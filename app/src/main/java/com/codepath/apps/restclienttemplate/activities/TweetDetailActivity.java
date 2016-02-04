package com.codepath.apps.restclienttemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.squareup.picasso.Picasso;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);

        // Get tweet from intent
        final Tweet tweet = (Tweet) getIntent().getSerializableExtra("tweet");

        tvUserName = (TextView) findViewById(R.id.tvTweetDetailUserName);
        tvScreenName = (TextView) findViewById(R.id.tvTweetDetailScreenName);
        tvTweetDetail = (TextView) findViewById(R.id.tvTweetDetail);
        ivUserPhoto = (ImageView) findViewById(R.id.ivTweetDetailUserPhoto);
        tvTimestamp = (TextView) findViewById(R.id.tvTweetDetailTimeStamp);
        tvTweetCount = (TextView) findViewById(R.id.tvTweetDetailRetweet);
        tvFavoritesCount = (TextView) findViewById(R.id.tvTweetDetailFavorites);
        btnReply = (ImageButton) findViewById(R.id.btnTweetDetailReply);


        //filling values
        tvUserName.setText(tweet.getUser().getName());
        tvScreenName.setText(tweet.getUser().getScreenName());
        tvTweetDetail.setText(Html.fromHtml(tweet.getBody()));
        tvTimestamp.setText(tweet.getCreatedAt());
        tvTweetCount.setText(tweet.getRetweetCount());
        tvFavoritesCount.setText(tweet.getFavoriteCount());

        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TweetDetailActivity.this, ComposeTweetActivity.class);
                i.putExtra("parentId", tweet.getUid());
                i.putExtra("parentUsername", tweet.getUser().getScreenName());
                startActivity(i);
            }
        });

        // Load the photo
        ivUserPhoto.setImageResource(android.R.color.transparent);

        Picasso.with(getApplicationContext())
                .load(tweet.getUser().getProfileImageURL())
                .placeholder(R.drawable.photo_placeholder)
                .into(ivUserPhoto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tweet_detail, menu);
        return true;
    }
}
