package com.example.sudokugame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartNewGameButtonClicked(View view) {
        Intent intent = new Intent("com.example.sudokugame.GameDifficultyActivity");
        startActivity(intent);
    }

    public void onAddNewBoardButtonClicked(View view) {
        Intent intent = new Intent("com.example.sudokugame.NewBoardActivity");
        startActivity(intent);
    }

    public void onShowInstructionsButtonClicked(View view) {
        Intent intent = new Intent("com.example.sudokugame.InstructionsActivity");
        startActivity(intent);
    }

}