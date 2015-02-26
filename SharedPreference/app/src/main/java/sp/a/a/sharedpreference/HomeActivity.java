package sp.a.a.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends ActionBarActivity {

    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView userText = (TextView) findViewById(R.id.textView);
        TextView passText = (TextView) findViewById(R.id.textView2);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("user","N/A");
        String pass = sharedPreferences.getString("pass","N/A");

        userText.setText(user);
        passText.setText(pass);

        Button back = (Button) findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("home","interface");
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        //RecyclerView Implementation
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        CustomAdapter adapter = new CustomAdapter(this, getData());
        recyclerView.setHorizontalScrollBarEnabled(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        GridView gridView = (GridView) findViewById(R.id.gridView);
//        GridAdapter adapter = new GridAdapter(HomeActivity.this);
//        gridView.setAdapter(adapter);

    }

    public static List<Information> getData(){
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
        String[] title = {"a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"};

        for(int i = 0; i<icons.length && i<title.length ; i++){
            Information information = new Information();
            information.iconId = icons[i];
            information.title = title[i];
            data.add(information);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void back(View v){
        Log.i("home","function xml");
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
    }
}
