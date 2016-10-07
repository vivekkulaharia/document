package com.example.vivek.first;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.GREEN);
        Button button = new Button(this);
        button.setId(1);
        final EditText editText = new EditText(this);
        editText.setId(2);
        button.setBackgroundColor(Color.CYAN);
        button.setText("click");
        Resources resources = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,resources.getDisplayMetrics());
        RelativeLayout.LayoutParams bd = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        editText.setWidth(px);
        RelativeLayout.LayoutParams bd1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        bd1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bd1.addRule(RelativeLayout.ABOVE,button.getId());
        bd1.setMargins(0,0,0,50);

        bd.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bd.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeLayout.addView(button,bd);
        relativeLayout.addView(editText,bd1);
        setContentView(relativeLayout);
    }

}
