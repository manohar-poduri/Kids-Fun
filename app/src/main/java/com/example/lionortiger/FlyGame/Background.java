package com.example.lionortiger.FlyGame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.lionortiger.R;

public class Background {

    int x = 0, y = 0;
    Bitmap background;

    Background(int sceenx, int screeny, Resources res){
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = Bitmap.createScaledBitmap(background,sceenx,screeny,false);
    }
}
