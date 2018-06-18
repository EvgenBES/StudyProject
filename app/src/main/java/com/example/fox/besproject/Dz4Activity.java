package com.example.fox.besproject;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

public class Dz4Activity extends Activity {
    AnimationDrawable owlAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz4);

        ImageView imageView = findViewById(R.id.imageOwlDz3);
        imageView.setBackgroundResource(R.drawable.animations_owl);
        owlAnimation = (AnimationDrawable) imageView.getBackground();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        owlAnimation.start();
    }
}