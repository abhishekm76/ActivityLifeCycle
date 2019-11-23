package com.delloil.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeToast("OnCreate() Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        MakeToast("OnStart() Called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MakeToast("OnResume() Called");
    }

    //Activity is now running in foreground


    @Override
    protected void onPause() {
        super.onPause(); // From fragment Activity
        MakeToast("OnPause() Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MakeToast("OnStop() Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MakeToast("OnDestroy() Called");
    }


    public void MakeToast(String messageText) {
        Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_SHORT).show();
        Log.d("MYTAG", messageText);
    }
}
