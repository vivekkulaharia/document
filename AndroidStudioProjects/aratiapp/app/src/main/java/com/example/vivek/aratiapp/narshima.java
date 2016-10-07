package com.example.vivek.aratiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vivek on 12/7/16.
 */
public class narshima extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.narshima);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView4);
                textView.setText("\nnamas te narasimhaya\n" +
                        "prahladahlada-dayine\n" +
                        "hiranyakasipor vakshahsila-\n" +
                        "tanka-nakhalaye\n\n\n namas te narasimhaya\n" +
                        "prahladahlada-dayine\n" +
                        "hiranyakasipor vakshahsila-\n" +
                        "tanka-nakhalaye\n\n\n tava kara-kamala-vare \nnakham adbhuta-sringam\n" +
                        "dalita-hiranyakasipu-tanu-bhringam\n" +
                        "kesava dhrita-narahari-rupa jaya jagadisa hare\n");
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

