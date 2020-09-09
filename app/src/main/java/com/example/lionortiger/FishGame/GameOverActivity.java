package com.example.lionortiger.FishGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lionortiger.MainActivity;
import com.example.lionortiger.R;

public class GameOverActivity extends AppCompatActivity {

    private Button startGameAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        startGameAgain = findViewById(R.id.play_again_btn);

        startGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameOverActivity.this, FishActivity.class));
            }
        });

    }
}