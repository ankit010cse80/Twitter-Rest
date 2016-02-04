package com.codepath.apps.restclienttemplate.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.codepath.apps.restclienttemplate.adapters.TweetListAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.ArrayList;

/**
 * Created by ankit on 3/2/16.
 */
public class TweetsListFragment extends Fragment {

    private SwipeRefreshLayout swipeContainer;
    private TweetListAdapter tweetAdapter;
    private ListView lvTweets;
    private ArrayList<Tweet> tweets;
}
