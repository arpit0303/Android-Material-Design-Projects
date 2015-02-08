package a.a.ola;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class RequestActivity extends ActionBarActivity {

    String contact;
    String phoneNumber;
    ListView list;
    ArrayList<String> aa= new ArrayList<String>();
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        list= (ListView) findViewById(R.id.list);

        getNumber(this.getContentResolver());

        EditText transfer = (EditText) findViewById(R.id.request);

        contact = transfer.getText().toString();

        Button go = (Button) findViewById(R.id.go1);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestActivity.this, AddMoney.class);
                intent.putExtra("requestedFriend",contact);
                startActivity(intent);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RequestActivity.this, AddMoney.class);
                intent.putExtra("requestedFriend",(String) parent.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }

    public void getNumber(ContentResolver cr)
    {
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        int i = 0;
        while (phones.moveToNext())
        {
            name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//            System.out.println(".................."+phoneNumber);
            aa.add(phoneNumber);
            i++;
        }
        phones.close();// close cursor

//        ContactAdapter adapter = new ContactAdapter(RequestActivity.this, name, phoneNumber);
//        list.setAdapter(adapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,aa);
        list.setAdapter(adapter);
        //display contact numbers in the list
    }
}
