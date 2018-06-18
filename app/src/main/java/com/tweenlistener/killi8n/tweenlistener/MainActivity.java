package com.tweenlistener.killi8n.tweenlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button animButton, offsetAnimButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animButton = (Button) findViewById(R.id.animButton);
        offsetAnimButton = (Button) findViewById(R.id.offsetAnimButton);

        animButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                final Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                final Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);

                alpha.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animButton.startAnimation(rotate);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animButton.startAnimation(scale);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                scale.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation Ended...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                animButton.startAnimation(alpha);
            }
        });

        offsetAnimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation offset = AnimationUtils.loadAnimation(MainActivity.this, R.anim.offset);
                offsetAnimButton.startAnimation(offset);
            }
        });
    }
}
