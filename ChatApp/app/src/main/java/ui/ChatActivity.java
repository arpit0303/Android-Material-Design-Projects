package ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import a.a.chatapp.ParseConstants;
import a.a.chatapp.R;


public class ChatActivity extends ActionBarActivity {

    Toolbar toolbar;
    String userObjectId;
    EditText sendMessage;
    ImageButton sendButton;
    String channelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final String userName = intent.getStringExtra(ParseConstants.KEY_USER_NAME);
        userObjectId = intent.getStringExtra(ParseConstants.KEY_USER_OBJECT_ID);

        getSupportActionBar().setTitle(userName);

        channelName = ParseUser.getCurrentUser().getObjectId() + "_" + userObjectId;
        ParsePush.subscribeInBackground(channelName);

        sendMessage = (EditText) findViewById(R.id.send_message_text);
        sendButton = (ImageButton) findViewById(R.id.message_send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message = sendMessage.getText().toString().trim();

                if (!(message.isEmpty())) {
                    String pushChannel = userObjectId + "_"+ ParseUser.getCurrentUser().getObjectId();
                    ParseQuery<ParseInstallation> query = ParseInstallation.getQuery();
                    query.whereEqualTo("channels", pushChannel);

                    ParsePush push = new ParsePush();
                    push.setQuery(query);
                    push.setMessage(message);
                    push.sendInBackground();
                }
                else {
                    //error
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                    builder.setTitle(getString(R.string.error_title))
                            .setMessage(getString(R.string.error_message))
                            .setPositiveButton(android.R.string.ok, null);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
