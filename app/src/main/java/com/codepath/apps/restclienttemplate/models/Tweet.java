package com.codepath.apps.restclienttemplate.models;

import android.text.format.DateUtils;
import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.network.TwitterClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

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

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public User getUser() {
        return user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getRetweetCount() {
        return retweetCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }


    public Tweet() {
        super();
    }

    public static Tweet fromJSON(JSONObject json) {
        Tweet tweet = new Tweet();

        try {
            tweet.body = json.getString("text");
            tweet.uid = json.getLong("id");

            if (maxId > tweet.uid) {
                maxId = tweet.uid;
            }

            if (sinceId < tweet.uid) {
                sinceId = tweet.uid;
            }

            tweet.createdAt = getRelativeTimeAgo(json.getString("created_at"));
            tweet.user = User.findOrCreateFromJson(json.getJSONObject("user"));
            tweet.retweetCount = String.valueOf(json.getLong("retweet_count"));
            tweet.favoriteCount = String.valueOf(json.getLong("favorite_count"));
            tweet.save();
        } catch (JSONException e) {
            Log.d("Tweet", "Json parse exception");
            e.printStackTrace();
        }
        return tweet;
    }

    public static String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }


}
