package com.example.shasin.mvp_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText note;
    TextView characterLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews(){
        note = findViewById(R.id.note);
        characterLeft = findViewById(R.id.characterLeft);
    }

    private void initListeners(){
        note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int length = note.length();
                String count = String.valueOf(200 - length);
                characterLeft.setText(count);

                if (length == 200) {
                    characterLeft.setTextColor(Color.RED);
                } else {
                    characterLeft.setTextColor(getResources().getColor(R.color.colorGrey));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
