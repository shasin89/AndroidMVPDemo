package com.example.shasin.mvp_demo;

import android.graphics.Color;

/**
 * Created by Shasin on 16/02/2018.
 */

public class MainActivityPresenter {
    private MainActivityView view;
    private int colorGrey = R.color.colorGrey;
    private int colorRed = Color.RED;

   protected MainActivityPresenter (MainActivityView mainActivityView){
       this.view = mainActivityView;
   }

   public void setCharacterCount(int noteLength,int maxLength){
       String count = String.valueOf(maxLength - noteLength);
       view.updateCharacterCount(count);
   }

   public void setLabelColor(int noteLength,int maxLength){
       if(noteLength == maxLength){
           view.updateTextColor(colorRed);
       }else
           view.updateTextColor(colorGrey);
   }


}
