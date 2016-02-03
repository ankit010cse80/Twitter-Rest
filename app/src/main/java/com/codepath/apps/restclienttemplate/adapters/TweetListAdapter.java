package com.codepath.apps.restclienttemplate.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.codepath.apps.restclienttemplate.models.Tweet;

/**
 * Created by ankit on 3/2/16.
 */
public class TweetListAdapter extends ArrayAdapter<Tweet> {
    public TweetListAdapter(Context context, int resource) {
        super(context, resource);
    }
}
