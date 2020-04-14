package com.io.sintezi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private native void touchEvent(int action, float frequency);

    private native void startEngine();

    private native void stopEngine();

    private native void setWaveShape(int waveShape);


    private ArrayList<WaveItem> mWaveList;
    private WaveAdapter mAdapter;



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        startEngine();




        final Scale theScale = new Scale();
        theScale.setScaleType(ScaleType.BLUES);

        //sin = 0, tri = 1, square = 2, saw = 3
        setWaveShape(3);

        //get buttonA
        final Button keyA = findViewById(R.id.keyA);
        //function
        keyA.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyA.setScaleX((float) (1 / 0.9));
                        keyA.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[0]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        keyA.setScaleX((float) 0.9);
                        keyA.setScaleY((float) 0.9);
                        // RELEASED
                        touchEvent(1, theScale.getValues()[0]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyB.setScaleX((float) (1 / 0.9));
                        keyB.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[1]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyB.setScaleX((float) 0.9);
                        keyB.setScaleY((float) 0.9);
                        touchEvent(1, theScale.getValues()[1]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyC.setScaleX((float) (1 / 0.9));
                        keyC.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[2]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyC.setScaleX((float) 0.9);
                        keyC.setScaleY((float) 0.9);
                        touchEvent(1, theScale.getValues()[2]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyD.setScaleX((float) (1 / 0.9));
                        keyD.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[3]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyD.setScaleX((float) 0.9);
                        keyD.setScaleY((float) 0.9);
                        touchEvent(1, theScale.getValues()[3]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyE.setScaleX((float) (1 / 0.9));
                        keyE.setScaleY((float) (1 / 0.9));
                        touchEvent(0, (float) theScale.getValues()[4]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyE.setScaleX((float) 0.9);
                        keyE.setScaleY((float) 0.9);
                        touchEvent(1, (float) theScale.getValues()[4]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyF.setScaleX((float) (1 / 0.9));
                        keyF.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[5]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        keyF.setScaleX((float) 0.9);
                        keyF.setScaleY((float) 0.9);
                        touchEvent(1, theScale.getValues()[5]);
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
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        keyG.setScaleX((float) (1 / 0.9));
                        keyG.setScaleY((float) (1 / 0.9));
                        touchEvent(0, theScale.getValues()[6]);
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        touchEvent(1, theScale.getValues()[6]);
                        keyG.setScaleX((float) 0.9);
                        keyG.setScaleY((float) 0.9);
                        return true; // if you want to handle the touch event
                }
                return false;
            }


        });

        initList();

        Spinner spinnerWaves = findViewById(R.id.wave_spinner);

        mAdapter = new WaveAdapter(this, mWaveList);
        spinnerWaves.setAdapter(mAdapter);

        spinnerWaves.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WaveItem clickedItem = (WaveItem) parent.getItemAtPosition(position);
                String clickedItemWaveName = clickedItem.getWaveName();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

    private void initList() {
        mWaveList = new ArrayList<>();
        mWaveList.add(new WaveItem("Sine", R.drawable.wave_sinehdpi));
        mWaveList.add(new WaveItem("Sawtooth", R.drawable.wave_sawtoothhdpi));
        mWaveList.add(new WaveItem("Square", R.drawable.wave_squarehdpi));
        mWaveList.add(new WaveItem("Triangle", R.drawable.wave_trianglehdpi));


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        /**
         * A native method that is implemented by the 'native-lib' native library,
         * which is packaged with this application.
         */


    }
}

