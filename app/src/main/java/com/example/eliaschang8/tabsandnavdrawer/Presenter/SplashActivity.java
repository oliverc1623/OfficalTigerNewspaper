package com.example.eliaschang8.tabsandnavdrawer.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.eliaschang8.tabsandnavdrawer.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2750;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
//                SplashActivity.this.startActivity(mainIntent);
//                SplashActivity.this.finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}

