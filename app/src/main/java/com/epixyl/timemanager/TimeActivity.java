package com.epixyl.timemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.*;
import android.content.*;
import java.util.*;


public class TimeActivity extends Activity {
    Button button;
    EditText editText;
    TextView text;
    ArrayList<String> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        text = (TextView)findViewById(R.id.textView);
        text.setText("No entries.");
        tasks = new ArrayList<String>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(editText.getContext(),editText.getText(),Toast.LENGTH_LONG).show();
                if(editText.getText().toString() != ""){
                    tasks.add(editText.getText().toString());
                    getMostRecent();
                }
                editText.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });
    }
    public void getMostRecent() {
        String s = "";
        for(int i=0; i<tasks.size(); i++) {
            s += tasks.get(i)+"\n";
        }
        text.setText(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time, menu);
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
