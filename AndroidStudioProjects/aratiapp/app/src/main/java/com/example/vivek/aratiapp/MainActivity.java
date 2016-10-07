package com.example.vivek.aratiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button1 = (ImageButton)findViewById(R.id.imageButton);
        button1.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),prabhupada.class);
                startActivity(intent);

            }
        });

        ImageButton button2 = (ImageButton)findViewById(R.id.imageButton3);
        button2.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),mangalarti.class);
                startActivity(intent);

            }
        });

        ImageButton button3 = (ImageButton)findViewById(R.id.imageButton2);
        button3.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),narshima.class);
                startActivity(intent);

            }
        });

    }
    }



