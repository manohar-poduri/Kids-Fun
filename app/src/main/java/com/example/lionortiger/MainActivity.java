package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{
        ONE, TWO, No;
    }

    Player currentPlayer = Player.ONE;

    Player[] playerChoices = new Player[9];

    int[][] winnerRowsColumns = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    private boolean gameOver = false;

    private Button btnReset;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        playerChoices[0] = Player.No;
//        playerChoices[1] = Player.No;
//        playerChoices[2] = Player.No;
//        playerChoices[3] = Player.No;
//        playerChoices[4] = Player.No;
//        playerChoices[5] = Player.No;
//        playerChoices[6] = Player.No;
//        playerChoices[7] = Player.No;
//        playerChoices[8] = Player.No;

        for (int index = 0; index < playerChoices.length; index++){
            playerChoices[index] = Player.No;
        }

        btnReset = findViewById(R.id.btnReset);
        gridLayout = findViewById(R.id.gridLayout);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetTheGame();
            }
        });
    }



    public void onClick(View view) {

        ImageView tappedImageView = (ImageView) view;
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        if (playerChoices[tiTag] == Player.No && gameOver == false) {

            tappedImageView.setTranslationX(-2000);

            playerChoices[tiTag] = currentPlayer;
            if (currentPlayer == Player.ONE) {
                tappedImageView.setImageResource(R.drawable.tiger);
                currentPlayer = Player.TWO;

            } else if (currentPlayer == Player.TWO) {
                tappedImageView.setImageResource(R.drawable.lion);
                currentPlayer = Player.ONE;
            }

            tappedImageView.animate().translationXBy(2000).rotation(3600).alpha(1).setDuration(1500);
            Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();

            for (int[] winnerChoices : winnerRowsColumns) {

                if (playerChoices[winnerChoices[0]] == playerChoices[winnerChoices[1]]
                        && playerChoices[winnerChoices[1]] == playerChoices[winnerChoices[2]]
                        && playerChoices[winnerChoices[0]] != Player.No) {

                    btnReset.setVisibility(View.VISIBLE);
                    gameOver = true;
                    String winnerOfGame = "";

                    if (currentPlayer == Player.ONE) {
//                    Toast.makeText(this, "Player Two is the winner", Toast.LENGTH_SHORT).show();
                        winnerOfGame = "Player Two";

                    } else if (currentPlayer == Player.TWO) {
//                    Toast.makeText(this, "Player One is the winner", Toast.LENGTH_SHORT).show();
                        winnerOfGame = "Player One";
                    }

                    Toast.makeText(this, winnerOfGame + " is the winner", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void resetTheGame(){

        for (int index = 0; index < gridLayout.getChildCount(); index++){

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.4f);
        }

        currentPlayer = Player.ONE;
//        playerChoices[0] = Player.No;
//        playerChoices[1] = Player.No;
//        playerChoices[2] = Player.No;
//        playerChoices[3] = Player.No;
//        playerChoices[4] = Player.No;
//        playerChoices[5] = Player.No;
//        playerChoices[6] = Player.No;
//        playerChoices[7] = Player.No;
//        playerChoices[8] = Player.No;

        for (int index = 0; index < playerChoices.length; index++){
            playerChoices[index] = Player.No;
        }
        gameOver = false;

        btnReset.setVisibility(View.INVISIBLE);

    }
}
