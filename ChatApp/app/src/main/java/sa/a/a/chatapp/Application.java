package sa.a.a.chatapp;

import com.parse.Parse;

/**
 * Created by Arpit on 24/02/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Mh0F48y3ET9JgcYQgLrKe9rLNLNZgy2PPaffzy7l", "DtmOIHCQDI7mnvOPsl1Ar2TkrNaJ68XQtrpGDVpJ");


//        ParsePush.subscribeInBackground("", new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
//                } else {
//                    Log.e("com.parse.push", "failed to subscribe for push", e);
//                }
//            }
//        });
    }
}
