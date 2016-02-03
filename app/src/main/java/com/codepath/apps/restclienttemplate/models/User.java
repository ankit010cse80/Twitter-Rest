package com.codepath.apps.restclienttemplate.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by ankit on 3/2/16.
 */

@Table(name = "User")
public class User extends Model implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "u_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private long uid;
    @Column(name = "screen_name")
    private String screenName;
    @Column(name = "profile_image_url")
    private String profileImageURL;
    @Column(name = "description")
    private String description;
    @Column(name = "follower_count")
    private long followerCount;
    @Column(name = "following_count")
    private long followingCount;
    @Column(name = "tweet_count")
    private long tweetCount;
    @Column(name = "background_profile_image_url")
    private String backgroundProfileImageURL;
}
