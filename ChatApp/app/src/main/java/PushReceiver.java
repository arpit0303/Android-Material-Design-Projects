import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

/**
 * Created by Arpit on 12/04/15.
 */
public class PushReceiver extends ParsePushBroadcastReceiver {

    @Override
    protected void onPushOpen(Context context, Intent intent) {
        super.onPushOpen(context, intent);
        if(ParseModule.getInstance() != null) {
            Log.d("onPushOpen", "App is running");
            Intent i = new Intent(context, TiApplication.getAppRootOrCurrentActivity().getClass());
            i.putExtras(intent.getExtras());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        else {
            Log.d("onPushOpen", "App is not running");

            Intent i = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
            i.putExtras(intent.getExtras());
            context.startActivity(i);
        }

    }
}
