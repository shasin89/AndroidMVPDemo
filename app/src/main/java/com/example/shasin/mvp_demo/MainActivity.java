package com.example.shasin.mvp_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityView {


    EditText note;
    TextView characterLeft;
    MainActivityPresenter mainActivityPresenter;
    private int setMaxLength = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityPresenter = new MainActivityPresenter(this);

        initViews();
        initListeners();
    }

    private void initViews() {
        note = findViewById(R.id.note);
        characterLeft = findViewById(R.id.characterLeft);
    }


    private void initListeners() {
        note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int noteLength = note.length();
                mainActivityPresenter.setCharacterCount(noteLength,setMaxLength);
                mainActivityPresenter.setLabelColor(noteLength,setMaxLength);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void updateTextColor(int colorID) {
        characterLeft.setTextColor(colorID);
    }

    @Override
    public void updateCharacterCount(String count) {
        characterLeft.setText(count);
    }
}
