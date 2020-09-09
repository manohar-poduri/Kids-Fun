package com.example.lionortiger.FlyGame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.lionortiger.R;

import static com.example.lionortiger.FlyGame.GameView.screenRatiox;
import static com.example.lionortiger.FlyGame.GameView.screenRatioy;

public class Bullet {

    int x, y, width, height;
    Bitmap bullet;

    Bullet(Resources res){

        bullet= BitmapFactory.decodeResource(res,R.drawable.bullet);

        width = bullet.getWidth();
        height = bullet.getHeight();

        width /= 4;
        height /= 4;

        width *= (int) screenRatiox;
        height *=  (int) screenRatioy;

        bullet = Bitmap.createScaledBitmap(bullet,width,height,false);
    }
    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
