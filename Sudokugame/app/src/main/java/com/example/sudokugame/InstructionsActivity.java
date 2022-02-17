package com.example.sudokugame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class InstructionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }
}
