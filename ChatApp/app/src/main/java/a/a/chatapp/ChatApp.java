package a.a.chatapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Arpit on 12/04/15.
 */
public class ChatApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Mh0F48y3ET9JgcYQgLrKe9rLNLNZgy2PPaffzy7l", "DtmOIHCQDI7mnvOPsl1Ar2TkrNaJ68XQtrpGDVpJ");

        // Save the current Installation to Parse.
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
