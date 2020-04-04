package com.io.sintezi;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    int test = 0;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private native void touchEvent(int action);

    private native void startEngine();

    private native void stopEngine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEngine();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchEvent(event.getAction());
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
