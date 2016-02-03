package com.codepath.apps.restclienttemplate.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

import java.io.Serializable;

/**
 * Created by ankit on 3/2/16.
 */

@Table(name = "Tweets")
public class Tweet extends Model implements Serializable {

    private static long maxId = Long.MAX_VALUE;
    private static long sinceId = 1;
    private static TwitterClient client = TwitterApplication.getRestClient();


}
