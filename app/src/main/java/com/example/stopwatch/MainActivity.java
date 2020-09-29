package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Animation animation,splash_screen,btn_anim;
    TextView splash;
    TextView motivation;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.getStarted);

        splash=findViewById(R.id.splashtxt);

        motivation=findViewById(R.id.motivation);

        img=findViewById(R.id.splash);

        animation= AnimationUtils.loadAnimation(this,R.anim.animation);

        splash_screen=AnimationUtils.loadAnimation(this,R.anim.splash_anim);

        btn_anim=AnimationUtils.loadAnimation(this,R.anim.btn_anim);

        img.startAnimation(animation);

        splash.startAnimation(splash_screen);

        motivation.startAnimation(splash_screen);

        btn.startAnimation(btn_anim);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,stop_watch.class);
                startActivity(intent);
            }
        });
    }
}