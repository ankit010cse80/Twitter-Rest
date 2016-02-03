package com.codepath.apps.restclienttemplate.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/**
 * Created by ankit on 3/2/16.
 */
public class TwitterClient extends OAuthBaseClient {

    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
    public static final String REST_URL = "https://api.twitter.com/1.1/";
    public static final String REST_CONSUMER_KEY = "CRPpOP2x2ALbUNC77M1tgslvG";
    public static final String REST_CONSUMER_SECRET = "1N5SGMm1uMwFJXAyOEib7xSqzDK6XyKZLaCx0T2QIjIFkd8Smb";
    public static final String REST_CALLBACK_URL = "oauth://cpsimpletweets";

    public TwitterClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }

    public void getHomeTimeline(long sinceId, long maxID, AsyncHttpResponseHandler handler) {
        if (isNetworkAvailable()) {
            // Get API
            String apiUrl = getApiUrl("statuses/home_timeline.json");
            // Create parameter list
            RequestParams params = new RequestParams();
            params.put("count", 50);
            params.put("since_id", 1);

            if (maxID != Long.MAX_VALUE) {
                params.put("max_id", maxID);
            }

            // Execute the request
            getClient().get(apiUrl, params, handler);
        } else {
            Toast.makeText(context, "Network not available. Please check your network connection", Toast.LENGTH_SHORT).show();
        }
    }



    // Check if Internet is available
    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
