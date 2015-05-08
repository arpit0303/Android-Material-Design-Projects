package a.a.linuxcommand;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

    EditText cmdBox;
    Button btnRun;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdBox = (EditText)findViewById(R.id.cmdbox);
        btnRun = (Button)findViewById(R.id.run);
        textResult = (TextView)findViewById(R.id.result);
        textResult.setTypeface(Typeface.MONOSPACE);

        btnRun.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Split String from EditText to String Array
                String[] cmd = cmdBox.getText().toString().split("\\s+");
                try {
                    String cmdResult = runLinuxCmd(cmd);
                    textResult.setTextColor(Color.WHITE);
                    textResult.setText(cmdResult);
                } catch (IOException e) {
                    e.printStackTrace();
                    textResult.setTextColor(Color.RED);
                    textResult.setText("Something Wrong!\n"
                            + e.getMessage());
                }
            }});
    }

    //Run a Linux command and return result
    private String runLinuxCmd(String[] command) throws IOException {

        StringBuilder cmdReturn = new StringBuilder();

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        int c;

        while ((c = inputStream.read()) != -1) {
            cmdReturn.append((char) c);
        }

        return cmdReturn.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
