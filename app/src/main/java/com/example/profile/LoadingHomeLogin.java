package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class LoadingHomeLogin extends AppCompatActivity {
    ProgressBar progressBar;
    int currentProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_home_login);
        runProg();
    }
    public void runProg() {
        progressBar = findViewById(R.id.progressBar);
        Intent intent = new Intent(LoadingHomeLogin.this, HomeLogin.class);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                currentProgress++;
                progressBar.setProgress(currentProgress);
                if(currentProgress == 100){
                    t.cancel();
                    startActivity(intent);
                }
            }
        };
        t.schedule(tt, 0, 100);
    }
}