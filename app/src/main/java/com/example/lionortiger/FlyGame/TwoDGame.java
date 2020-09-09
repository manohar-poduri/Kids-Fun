package com.example.lionortiger.FlyGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lionortiger.R;

public class TwoDGame extends AppCompatActivity {

    TextView play, highScore;
    private boolean isMute;
    ImageView volumeCtrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_d_game);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        play = findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwoDGame.this,GameActivity.class));
            }
        });

        highScore = findViewById(R.id.highScore);
        final SharedPreferences prefs = getSharedPreferences("game",MODE_PRIVATE);
        highScore.setText("HighScore: " + prefs.getInt("highscore",0));

        isMute = prefs.getBoolean("isMute",false);

        volumeCtrl = findViewById(R.id.volumeUp);
        if (isMute){
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
        } else {
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isMute = !isMute;

                if (isMute){
                    volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
                } else {
                    volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
                }

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute",isMute);
                editor.apply();

            }
        });
    }

}