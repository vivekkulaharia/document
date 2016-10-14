package com.example.vivek.vivekphone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button)findViewById(R.id.but);
        but.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View v){
                TextView text = (TextView)findViewById(R.id.text);
                text.setText("you cicked ");
            }
        });

        but.setOnLongClickListener(
                new Button.OnLongClickListener(){
                public boolean onLongClick(View v){
                TextView text = (TextView)findViewById(R.id.text);
                text.setText("you long clicked  ");
                    return true;
                }

        });

    }

}
