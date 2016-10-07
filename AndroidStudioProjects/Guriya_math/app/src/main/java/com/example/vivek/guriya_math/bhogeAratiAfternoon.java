package com.example.vivek.guriya_math;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by vivek on 12/7/16.
 */
public class bhogeAratiAfternoon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mangal_arati);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("  ");
            }
        });


        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("");
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("");
            }
        });


    }
}

