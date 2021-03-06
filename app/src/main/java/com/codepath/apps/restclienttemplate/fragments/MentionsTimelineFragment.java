package com.codepath.apps.restclienttemplate.fragments;

import android.util.Log;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ankit on 4/2/16.
 */
public class MentionsTimelineFragment extends TweetsListFragment{

    private TwitterClient client;
    @Override
    public void populateTimelineWithMaxId(Long sinceId, final long maxId) {


        if (maxId == Long.MAX_VALUE) {
            Tweet.setMaxId(Long.MAX_VALUE);
        }

        long since_id = 1;

        if (sinceId != null) {
            since_id = sinceId;
        }

        client.getMentionsTimeline(since_id, maxId, new JsonHttpResponseHandler() {
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
                super.onFailure(statusCode, (cz.msebera.android.httpclient.Header[]) headers, throwable, errorResponse);
            }
        });
    }



}
