package com.io.sintezi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private native void touchEvent(int action, float frequency);

    private native void startEngine();

    private native void stopEngine();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEngine();

        //get buttonA
        final Button keyA = findViewById(R.id.keyA);
        //function
        keyA.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyA.setScaleX((float)(1/0.9));
                        keyA.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 130.81);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        keyA.setScaleX((float)0.9);
                        keyA.setScaleY((float)0.9);
                        // RELEASED
                        touchEvent(1, (float) 130.81);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });

        //get buttonB
        final Button keyB = findViewById(R.id.keyB);

        //function
        keyB.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyB.setScaleX((float)(1/0.9));
                        keyB.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 155.56);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyB.setScaleX((float)0.9);
                        keyB.setScaleY((float)0.9);
                        touchEvent(1,(float) 155.56);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });

        //get buttonC
        final Button keyC = findViewById(R.id.keyC);

        //function
        keyC.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyC.setScaleX((float)(1/0.9));
                        keyC.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 174.61);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyC.setScaleX((float)0.9);
                        keyC.setScaleY((float)0.9);
                        touchEvent(1,(float) 174.61);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });


        //get buttonD
        final Button keyD = findViewById(R.id.keyD);

        //function
        keyD.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyD.setScaleX((float)(1/0.9));
                        keyD.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 185.00);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyD.setScaleX((float)0.9);
                        keyD.setScaleY((float)0.9);
                        touchEvent(1,(float) 185.00);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });


        //get buttonE
        final Button keyE = findViewById(R.id.keyE);

        //function
        keyE.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyE.setScaleX((float)(1/0.9));
                        keyE.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 196.00);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyE.setScaleX((float)0.9);
                        keyE.setScaleY((float)0.9);
                        touchEvent(1,(float) 196.00);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });


        //get buttonF
        final Button keyF = findViewById(R.id.keyF);

        //function
        keyF.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyF.setScaleX((float)(1/0.9));
                        keyF.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 233.08);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyF.setScaleX((float)0.9);
                        keyF.setScaleY((float)0.9);
                        touchEvent(1,(float) 233.08);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });


        //get buttonG
        final Button keyG = findViewById(R.id.keyG);

        //function
        keyG.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyG.setScaleX((float)(1/0.9));
                        keyG.setScaleY((float)(1/0.9));
                        touchEvent(0,(float) 261.63);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        touchEvent(1,(float) 261.63);
                        keyG.setScaleX((float)0.9);
                        keyG.setScaleY((float)0.9);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    public void onDestroy() {
        stopEngine();
        super.onDestroy();
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}
