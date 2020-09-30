package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class stop_watch extends AppCompatActivity {

    Animation rotate;

    ImageView stick;
    Button startbtn,stopbtn;

    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        startbtn=findViewById(R.id.startwatch);

        stopbtn=findViewById(R.id.stopwatch);
        stopbtn.setAlpha(0);

        stick=findViewById(R.id.stick);

        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);

        chronometer=findViewById(R.id.chronometer);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stick.startAnimation(rotate);
                stopbtn.animate().alpha(1).translationY(0).setDuration(300).start();
                startbtn.animate().alpha(0).setDuration(300).start();
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stick.clearAnimation();
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                startbtn.animate().alpha(1).translationY(0).setDuration(300).start();
                stopbtn.animate().alpha(0).setDuration(300).start();
            }
        });


    }
}