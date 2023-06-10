package com.vandee.aplikasikita;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.vandee.aplikasikita.Login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static int SPLACH_SCREEN = 5000;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView tv_judul, tv_subjudul;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.img_bg);
        tv_judul = findViewById(R.id.tv_judul);
        tv_subjudul = findViewById(R.id.tv_subjudul);

        image.setAnimation(topAnim);
        tv_judul.setAnimation(bottomAnim);
        tv_subjudul.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLACH_SCREEN);
    }
}