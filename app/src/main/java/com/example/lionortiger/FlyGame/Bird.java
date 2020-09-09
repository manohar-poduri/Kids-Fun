package com.example.lionortiger.FlyGame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.lionortiger.R;

import static com.example.lionortiger.FlyGame.GameView.screenRatiox;
import static com.example.lionortiger.FlyGame.GameView.screenRatioy;

public class Bird {

    public int speed = 1;
    public boolean wasShot = true;
    int x = 0,y, width, height, birdCounter = 1;
    Bitmap bird1, bird2, bird3, bird4;

    Bird(Resources res){
        bird1 = BitmapFactory.decodeResource(res, R.drawable.bird1);
        bird2 = BitmapFactory.decodeResource(res, R.drawable.bird2);
        bird3 = BitmapFactory.decodeResource(res, R.drawable.bird3);
        bird4 = BitmapFactory.decodeResource(res, R.drawable.bird4);

        int width = bird1.getWidth();
        int height = bird1.getHeight();

        width /= 6;
        height /= 6;

        width *= (int) screenRatiox;
        height *=  (int) screenRatioy;

        bird1 = Bitmap.createScaledBitmap(bird1,width,height,false);
        bird2 = Bitmap.createScaledBitmap(bird2,width,height,false);
        bird3 = Bitmap.createScaledBitmap(bird3,width,height,false);
        bird4 = Bitmap.createScaledBitmap(bird4,width,height,false);

        y = -height;

    }

    Bitmap getBird(){
        if (birdCounter == 1){
            birdCounter++;
            return bird1;
        }
        if (birdCounter == 2){
            birdCounter++;
            return bird2;
        }
        if (birdCounter == 3){
            birdCounter++;
            return bird3;
        }
        if (birdCounter == 4){
            birdCounter++;
            return bird4;
        }

        birdCounter = 1;

        return bird4;

    }

    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
