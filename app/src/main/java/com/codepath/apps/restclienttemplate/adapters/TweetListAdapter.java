package com.codepath.apps.restclienttemplate.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.squareup.picasso.Picasso;

import java.util.List;

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

    private TwitterClient client = TwitterApplication.getRestClient();

    public TweetListAdapter(Context context, List<Tweet> tweets) {
        super(context, android.R.layout.simple_list_item_1, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    }
}
