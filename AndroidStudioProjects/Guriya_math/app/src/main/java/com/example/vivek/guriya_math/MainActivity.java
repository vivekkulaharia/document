package com.example.vivek.guriya_math;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button1 = (ImageButton)findViewById(R.id.imageButton12);
        button1.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),mangal_arati.class);
                startActivity(intent);

            }
        });
    }
}
