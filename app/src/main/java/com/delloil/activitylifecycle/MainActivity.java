package com.delloil.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showGuess;
    private EditText userGuess;
    public final int  REQUEST_CODE =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeToast("OnCreate() Called");
        showGuess=findViewById(R.id.button_submitguess);
        userGuess=findViewById(R.id.enter_guess);
        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = userGuess.getText().toString().trim();

                if (!enteredText.isEmpty()){
                    Intent navIntent = new Intent(MainActivity.this, ShowGuess.class);
                    navIntent.putExtra("guesskey",enteredText);
                    navIntent.putExtra("age", 23);
                    navIntent.putExtra("bool", true);

                    startActivityForResult(navIntent,REQUEST_CODE);
                   // startActivity(navIntent);
                }else{
                    Toast.makeText(MainActivity.this, "You need to enter a name",Toast.LENGTH_SHORT).show();

                }

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUEST_CODE){
            if(resultCode==-1){
                assert data!=null;
                String message = data.getStringExtra("message_back");
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
        }
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
