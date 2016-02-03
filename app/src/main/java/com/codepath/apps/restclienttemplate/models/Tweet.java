package com.codepath.apps.restclienttemplate.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
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

    @Column(name = "body")
    private String body;
    @Column(name = "u_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private long uid; // Unique DB id for the tweet
    @Column(name = "User", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    private User user;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "retweet_count")
    private String retweetCount;
    @Column(name = "favorite_count")
    private String favoriteCount;


}
