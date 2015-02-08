package a.a.ola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TransferMoney extends ActionBarActivity {

    String MESSAGE;
    String transferFriendNumber;
    EditText pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money);

        transferFriendNumber = getIntent().getStringExtra("transferredFriend");
        pay = (EditText) findViewById(R.id.addMoney);

        Button payMoney = (Button) findViewById(R.id.pay_done);

        payMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = pay.getText().toString();
                MESSAGE = "Congrats!! You got " + amount +" Rs from " + transferFriendNumber + ".";
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(transferFriendNumber, null, MESSAGE, null, null);

                Toast.makeText(TransferMoney.this,"You money transfer is successful.",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TransferMoney.this,WalletHomeActivity.class));
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transfer_money, menu);
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
