package com.codepath.apps.restclienttemplate.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.apps.restclienttemplate.network.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by ankit on 3/2/16.
 */
public class ComposeTweetActivity extends ActionBarActivity {

    private User user;
    private ImageView ivUserPhoto;
    private TextView tvName;
    private TextView tvScreenName;
    private EditText etTweet;
    private TwitterClient client;
    private MenuItem menuItem;
    private Long parentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_tweet);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compose_tweet, menu);
        // Get menu item
        menuItem = menu.findItem(R.id.miCharCount);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }


    private void composeTweet(String tweetStr, Long parentId) {
        client.composeTweet(tweetStr, parentId, new JsonHttpResponseHandler() {
            // SUCCESS

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("TweetDebug", response.toString());
                setResult(RESULT_OK);
                ComposeTweetActivity.this.finish();
            }

            // FAILURE

            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("TweetError", errorResponse.toString());
                setResult(RESULT_CANCELED);
                Toast.makeText(ComposeTweetActivity.this, "Could not compose tweet" + errorResponse.toString(), Toast.LENGTH_SHORT).show();
                ComposeTweetActivity.this.finish();
            }
        });
    }

    public static void showAsPopup(Activity activity) {
        //To show activity as dialog and dim the background, you need to declare android:theme="@style/PopupTheme" on for the chosen activity on the manifest
        activity.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.height = 600; //fixed height
        params.alpha = 1.0f;
        params.dimAmount = 0.5f;
        activity.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

}
