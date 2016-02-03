package com.codepath.apps.restclienttemplate.network;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;

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
}
