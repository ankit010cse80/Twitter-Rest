package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.restclienttemplate.R;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create arraylist (data source)
        tweets = new ArrayList<Tweet>();
        // Create Adapter
        tweetAdapter = new TweetListAdapter(getActivity(), tweets);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container, false);


        return v;
    }


}
