package com.example.vivek.gesture;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private TextView text ;
    private GestureDetectorCompat gestureDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        text.setText("ondown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        text.setText("showpress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        text.setText("On singletapup");
        return true;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        text.setText("Onscroll");
        return true;
    }
    @Override
    public void onLongPress(MotionEvent e) {
        text.setText("On Longpress");

    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        text.setText("Onfling");
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        text.setText("Onsingletapconfirmed");
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        text.setText("On doubletap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        text.setText("On doubletapEvent");
        return true;
    }
    }
