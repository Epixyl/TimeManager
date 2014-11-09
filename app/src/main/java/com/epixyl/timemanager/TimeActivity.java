package com.epixyl.timemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.*;
import android.content.*;
import android.text.format.*;
import java.util.*;
import android.graphics.*;

public class TimeActivity extends Activity{
    Button button;
    Button button2;
    Button button3;
    Button button4;
    TextView textView2, textView3, textView4, textView5, textView6, textView7;
    int repeatSetting = 0;
    int points = 0;
    EditText editText;
    TextView text;
    ArrayList<String> tasks;
    ProgressBar progress;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView7 = (TextView)findViewById(R.id.textView7);
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView5.setText("");
        textView6.setText("");
        textView7.setText("");
        editText = (EditText) findViewById(R.id.editText);
        text = (TextView)findViewById(R.id.textView);

        text.setText("Tasks");
        tasks = new ArrayList<String>();
        progress= (ProgressBar)findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(editText.getContext(),editText.getText(),Toast.LENGTH_LONG).show();
                if(!editText.getText().toString().equals("")){
                    tasks.add(editText.getText().toString()+" (RepeatSetting: "+repeatSetting+")\n");
                    getMostRecent();
                }
                editText.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatSetting = 0;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatSetting = 1;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatSetting = 2;
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(0).equals("")) {

                    counter++;
                    progress.setProgress(counter);
                    tasks.remove(0);
                    getMostRecent();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(1).equals("")) {
                    tasks.remove(1);
                    getMostRecent();
                }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(2).equals("")) {
                    tasks.remove(2);
                    getMostRecent();
                }
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(3).equals("")) {
                    tasks.remove(3);
                    getMostRecent();
                }
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(4).equals("")) {
                    tasks.remove(4);
                    getMostRecent();
                }
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(5).equals("")) {
                    tasks.remove(5);
                    getMostRecent();
                }
            }
        });

    }
    public void getMostRecent() {
        String s = "";
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView5.setText("");
        textView6.setText("");
        textView7.setText("");
        for(int i=0; i<Math.min(tasks.size(), 5); i++) {
            if(tasks.size()>i) {
                s = tasks.get(i);
                switch (i) {
                    case 0:
                        textView2.setText(s);
                        break;
                    case 1:
                        textView3.setText(s);
                        break;
                    case 2:
                        textView4.setText(s);
                        break;
                    case 3:
                        textView5.setText(s);
                        break;
                    case 4:
                        textView6.setText(s);
                        break;
                    case 5:
                        textView7.setText(s);
                        break;
                }
            }
        }
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
