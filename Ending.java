package fcu.mp.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class Ending extends AppCompatActivity {

    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        textView3 = findViewById(R.id.textView3);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                0f,
                100f,
                0f,
                -100f
        );
        translateAnimation.setDuration(2500);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        textView3.startAnimation(translateAnimation);
    }
}