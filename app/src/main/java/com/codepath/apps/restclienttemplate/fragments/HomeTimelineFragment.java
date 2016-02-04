package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

import java.util.ArrayList;

/**
 * Created by ankit on 3/2/16.
 */
public class HomeTimelineFragment extends TweetsListFragment {

    private TwitterClient client;
    private Boolean shouldRefresh = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the client
        client = TwitterApplication.getRestClient(); // singleton client
        ArrayList<Tweet> tweetList = new ArrayList<>();
        tweetList.addAll(Tweet.getTweetsFromDB());

        // Add to the adapter
        addAll(tweetList);

    }

    @Override
    public void populateTimelineWithMaxId(Long sinceId, long maxId) {

    }
}
