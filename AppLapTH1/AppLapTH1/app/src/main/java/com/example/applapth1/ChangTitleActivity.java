package com.example.applapth1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class ChangTitleActivity extends AppCompatActivity {

    public static final String EXTRA_TITLESAVE = "com.example.applapth1.TITLESAVE";
    public static final String EXTRA_COLORSAVE = "com.example.applapth1.COLORSAVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_title_activity);

        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
        TextView textView = findViewById(R.id.Showview);

        String color = intent.getStringExtra(MainActivity.EXTRA_COLOR);
        View view = findViewById(R.id.colorshow);

        textView.setText(title);
        textView.setTextColor(Color.parseColor(color));
        view.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.DARKEN);
    }

    public void Savetitle(View v){
        Intent intent = new Intent(this,MainActivity.class);
        EditText editText = (EditText)findViewById(R.id.Showview);
        String titlesave = editText.getText().toString();

        View view = (View)findViewById(R.id.colorshow);
        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        intent.putExtra(EXTRA_TITLESAVE,titlesave);
        intent.putExtra(EXTRA_COLORSAVE,hexColor);
        startActivity(intent);
    }
    public void gotoPurple_200(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.purple_200);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }
    public void gotoTeal_200(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.teal_200);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }
    public void gotoTeal_700(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.teal_700);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }
    public void gotoPurple_500(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.purple_500);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }
    public void gotoGray(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.cardview_dark_background);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }
    public void gotoOrange(View v){
        View view = findViewById(R.id.colorshow);
        view.setBackgroundResource(R.color.orange);

        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        int color = viewColor.getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        TextView Text = (TextView) findViewById(R.id.Showview);
        Text.setTextColor(Color.parseColor(hexColor));
    }

}