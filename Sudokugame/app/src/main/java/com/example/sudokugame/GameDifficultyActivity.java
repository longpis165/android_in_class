package com.example.sudokugame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class GameDifficultyActivity extends AppCompatActivity {
    private boolean newBoard = false;
    //set thông số mặc định trò chơi là 0 (dễ)
    private int selectedDifficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_difficulty);
        newBoard = getIntent().getBooleanExtra("newBoard", false);
        if (newBoard) {
            Button buttonContinue = findViewById(R.id.buttonContinue);
            buttonContinue.setText(getString(R.string.add_new_board));
        }
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }

    public void onDifficultyRadioButtonsClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        //chọn độ khó
        switch (view.getId()) {
            case R.id.radioButtonEasy:
                if (checked) {
                    selectedDifficulty = 0;
                }
                break;
            case R.id.radioButtonNormal:
                if (checked) {
                    selectedDifficulty = 1;
                }
                break;
            case R.id.radioButtonHard:
                if (checked) {
                    selectedDifficulty = 2;
                }
                break;
        }
    }

    public void onStartGameButtonClicked(View view) {
        //nếu khởi tạo bảng mới
        if (newBoard) {
            Intent intent = new Intent();
            intent.putExtra("boardSaved", true);
            intent.putExtra("difficulty", selectedDifficulty);
            setResult(RESULT_OK, intent);
            finish();
            //bắt đầu game với độ khó đã chọn
        } else {
            Intent intent = new Intent("com.example.sudokugame.GameActivity");
            intent.putExtra("difficulty", selectedDifficulty);
            startActivity(intent);
        }
    }
}
