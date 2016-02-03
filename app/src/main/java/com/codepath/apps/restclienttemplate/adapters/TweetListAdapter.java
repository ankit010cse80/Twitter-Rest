package com.codepath.apps.restclienttemplate.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;

/**
 * Created by ankit on 3/2/16.
 */
public class TweetListAdapter extends ArrayAdapter<Tweet> {

    private static class ViewHolder {
        ImageView ivProfileImage;
        TextView tvUsername;
        TextView tvTweetBody;
        TextView tvTimeStamp;
        TextView tvRetweet;
        TextView tvFavorites;
        ImageButton btnReply;
    }


    public TweetListAdapter(Context context, int resource) {
        super(context, resource);
    }
}
