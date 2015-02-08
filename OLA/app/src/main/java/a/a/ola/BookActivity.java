package a.a.ola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;


public class BookActivity extends Activity {

    GoogleMap map;
    private double latitude;
    private double longitude;
    String loc;
    private static final String TAG = BookActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this, WalletHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
//
//        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
//                .getMap();
//
//        map.setMyLocationEnabled(true);
//
//        LocationManager locMngr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        // Create a criteria object to retrieve provider
//        Criteria criteria = new Criteria();
//
//        // Get the name of the best provider
//        String provider = locMngr.getBestProvider(criteria, true);
//
//        // Get Current Location
//        Location myLocation = locMngr.getLastKnownLocation(provider);
//
//        latitude = myLocation.getLatitude();
//        longitude = myLocation.getLongitude();
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(new LatLng(latitude, longitude)).zoom(14).build();
//
//        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

//        map.addMarker(new MarkerOptions().position(
//                new LatLng(latitude, longitude)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book, menu);
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
