package com.codepath.apps.restclienttemplate.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.R;

/**
 * Created by ankit on 5/2/16.
 */
public class TweetListCursorAdapter extends CursorAdapter {

    public TweetListCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        ImageView ivProfileImage = (ImageView) view.findViewById(R.id.ivProfileImage);
        TextView tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        TextView tvTweetBody = (TextView) view.findViewById(R.id.tvBody);
        TextView tvTimeStamp = (TextView) view.findViewById(R.id.tvTimeStamp);
        TextView tvRetweet = (TextView) view.findViewById(R.id.tvRetweet);
        TextView tvFavorites = (TextView) view.findViewById(R.id.tvFavorites);
        ImageButton btnReply = (ImageButton) view.findViewById(R.id.btnReply);
        // Extract properties from cursor
        String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        long id = cursor.getLong(cursor.getColumnIndexOrThrow("u_id"));

        // Populate fields with extracted properties
        tvTweetBody.setText(body);
    }
}
