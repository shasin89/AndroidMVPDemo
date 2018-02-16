package com.example.shasin.mvp_demo;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Shasin on 16/02/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {
    MainActivityPresenter mainActivityPresenter;

    @Mock
    MainActivityView mainActivityView;

    @Before
    public void setup() throws Exception{
        mainActivityPresenter = new MainActivityPresenter(mainActivityView);
    }



    @Test
    public void testIfPresenterUpdateCharacterLeftText(){
        //Arrange
        int noteLength = 150;
        int maxLength = 200;
        String count = String.valueOf(maxLength - noteLength);

        //Act
        mainActivityPresenter.setCharacterCount(noteLength,maxLength);

        //Assert
        Mockito.verify(mainActivityView).updateCharacterCount(count);

    }

    @Test
    public void testIfPresenterUpdateLabelColorRed(){
        //Arrange
        int noteLength = 200;
        int maxLength = 200;
        int colorRed = Color.RED;

        //Act
        mainActivityPresenter.setLabelColor(noteLength,maxLength);

        //Assert
        Mockito.verify(mainActivityView).updateTextColor(colorRed);

    }

    @Test
    public void testIfPresenterUpdateLabelColorGrey(){
        //Arrange
        int noteLength = 100;
        int maxLength = 200;
        int colorGrey= R.color.colorGrey;

        //Act
        mainActivityPresenter.setLabelColor(noteLength,maxLength);

        //Assert
        Mockito.verify(mainActivityView).updateTextColor(colorGrey);

    }

}
