package com.example.sdl.stargato;

import android.support.annotation.StringRes;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * para las animaciones de salida y entrada seleccionadas de forma random,, de momento sencillas xD
 */

public class AnimationsR {
    static MainActivity main;//instanciando MainActivity para actualizar usuario declarado alla


    public static void entrada(ImageView v, int playerStarA){
        v.setTranslationX(-1000f);
        v.setRotation(0);
        playerDif(v, playerStarA);
        v.animate().translationX(0f).rotation(2160).setDuration(500);
    }// entrada end   360 2160  4320 8640


    public static void playerDif(ImageView v, int pS){
        if(pS == 1){
            v.setImageResource(R.drawable.silver_star);
            main.playerStar = 2;
        } else if(pS == 2){
            v.setImageResource(R.drawable.yellow_star);
            main.playerStar = 1;
        }
    }// playerDif end




}// class Animation end
