package com.gmail.robidahariansyah8.mynavigationbottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.robidahariansyah8.mynavigationbottom.models.Person;

public class MoveWithObjectActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_PERSON = "extra_person";
    private int REQUEST_CODE = 100;

    TextView tvResultHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvName = findViewById(R.id.tv_name_mwo_activity);
        TextView tvEmail = findViewById(R.id.tv_email_mwo_activity);
        TextView tvJob = findViewById(R.id.tv_job_mwo_activity);
        TextView tvAge = findViewById(R.id.tv_age_mwo_activity);

        tvResultHobby = findViewById(R.id.tv_result_hobby);

        Button btnHobby = findViewById(R.id.btn_move_activity_result);
        btnHobby.setOnClickListener(this);
        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        tvName.setText(person.getName());
        tvEmail.setText(person.getEmail());
        tvJob.setText(person.getJob());
        tvAge.setText(String.valueOf(person.getAge()));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_activity_result) {
            Intent moveActivityResult = new Intent(getApplicationContext(), MoveForResultActivity.class);
            startActivityForResult(moveActivityResult, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                String selectedValue = data.getStringExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE);
                tvResultHobby.setText("Your hobby : " + selectedValue);
            }
        }
    }
}
