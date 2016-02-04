package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

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
    public void populateTimelineWithMaxId(Long sinceId, final long maxId) {

        if (maxId == Long.MAX_VALUE) {
            Tweet.setMaxId(Long.MAX_VALUE);
        }

        long since_id = 1;

        if (sinceId != null) {
            since_id = sinceId;
        }

        client.getHomeTimeline(since_id, maxId, new JsonHttpResponseHandler() {
            // SUCCESS

            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("DEBUG:", response.toString());
                // Clear tweetAdapter
                if (maxId == Long.MAX_VALUE) {
                    clearList();
                }
                // Add new data to tweetAdapter
                addAll(Tweet.fromJSONArray(response));
                // Now we call setRefreshing(false) to signal refresh has finished
                stopRefreshing();
            }

            // FAILURE

            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
                stopRefreshing();
//                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
