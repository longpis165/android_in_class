package com.example.applapth1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.applapth1.TITLE";
    public static final String EXTRA_COLOR = "com.example.applapth1.COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.Titleview);
        String textsave = intent.getStringExtra(ChangTitleActivity.EXTRA_TITLESAVE);

        String color = intent.getStringExtra(ChangTitleActivity.EXTRA_COLORSAVE);

        if (textsave == null || color == null){
            Log.i ("Hello","PASS");
        }
        else{
            textView.setText(textsave);
            textView.setTextColor(Color.parseColor(color));
        }
    }

    public void Changtitle(View view){
        Intent intent = new Intent (this, ChangTitleActivity.class);
        TextView textview = (TextView)findViewById(R.id.Titleview);
        String title = textview.getText().toString();

        int color = textview.getCurrentTextColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        intent.putExtra(EXTRA_TITLE,title);
        intent.putExtra(EXTRA_COLOR,hexColor);

        startActivity(intent);
    }
    public void ChangBackground(View v){
        Intent intent = new Intent(this,ChangeBackgroundActivity.class);
        startActivity(intent);
    }
}