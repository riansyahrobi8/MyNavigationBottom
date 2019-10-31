package com.gmail.robidahariansyah8.mynavigationbottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int RESULT_CODE = 110;
    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";

    RadioGroup rgHobbies;
    RadioButton rbBaca, rbTulis, rbHujat, rbNyinyir;
    Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        rgHobbies = findViewById(R.id.rg_hobby);
        rbBaca = findViewById(R.id.rb_membaca);
        rbTulis = findViewById(R.id.rb_menulis);
        rbHujat = findViewById(R.id.rb_menghujat);
        rbNyinyir = findViewById(R.id.rb_nyinyir);

        btnChoose = findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_choose) {
            if (rgHobbies.getCheckedRadioButtonId() != 0) {
                String value = null;
                switch (rgHobbies.getCheckedRadioButtonId()) {
                    case R.id.rb_membaca:
                        value = rbBaca.getText().toString();
                        break;
                    case R.id.rb_menulis:
                        value = rbTulis.getText().toString();
                        break;
                    case R.id.rb_menghujat:
                        value = rbHujat.getText().toString();
                        break;
                    case R.id.rb_nyinyir:
                        value = rbNyinyir.getText().toString();
                        break;
                }

                Intent intentResult = new Intent();
                intentResult.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, intentResult);
                finish();
            }
        }
    }
}
