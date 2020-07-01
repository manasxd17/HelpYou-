package com.example.saish.helpyou;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivitysplash extends AppCompatActivity {
    private ImageView sp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_activitysplash);
        sp1 = (ImageView) findViewById(R.id.sp1);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.transition1);
        sp1.startAnimation(myanim1);

        final Intent homeintent = new Intent(this,MainActivity1.class);
        Thread timer = new Thread(){
            public void run(){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                startActivity(homeintent);
                finish();

            }
            }
        };
        timer.start();



    }
}