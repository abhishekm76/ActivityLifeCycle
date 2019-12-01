package com.delloil.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    private TextView showGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        showGuess=findViewById(R.id.recievedText);

        Bundle fromMainActivity = getIntent().getExtras();

        if (fromMainActivity != null){
            String passedFromOne = fromMainActivity.getString("guesskey");
            showGuess.setText(passedFromOne);
            Log.d("PassedInfo", "passedint" + fromMainActivity.getInt("age"));
            Log.d("PassedInfo","passedboolean"+fromMainActivity.getBoolean("bool"));
        }
    }

}
