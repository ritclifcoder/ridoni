package com.example.berberuyg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Thread thread =new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent welcomeIntent =new Intent(SplashActivity.this,WelcomeActivity.class);
                    startActivity(welcomeIntent);


                }

            }

        };

        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }



    }

