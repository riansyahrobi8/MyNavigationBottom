package com.gmail.robidahariansyah8.mynavigationbottom.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gmail.robidahariansyah8.mynavigationbottom.MoveActivity;
import com.gmail.robidahariansyah8.mynavigationbottom.MoveWithDataActivity;
import com.gmail.robidahariansyah8.mynavigationbottom.MoveWithObjectActivity;
import com.gmail.robidahariansyah8.mynavigationbottom.R;
import com.gmail.robidahariansyah8.mynavigationbottom.models.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnMoveActivity = view.findViewById(R.id.btn_move_activity);
        Button btnMoveWithData = view.findViewById(R.id.btn_move_with_data);
        Button btnMoveWithObject = view.findViewById(R.id.btn_move_with_object);
        Button btnDialNumber = view.findViewById(R.id.btn_dial_number);

        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(getActivity(), MoveActivity.class);
                startActivity(moveActivity);
                break;
            case R.id.btn_move_with_data:
                Intent moveWithData = new Intent(getActivity(), MoveWithDataActivity.class);
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Robi Dahariansyah");
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 23);
                startActivity(moveWithData);
                break;
            case R.id.btn_move_with_object:
                Intent moveWithObject = new Intent(getActivity(), MoveWithObjectActivity.class);
                Person person = new Person();
                person.setName("Robi Dahariansyah");
                person.setEmail("robidahariansyah8@gmail.com");
                person.setJob("Android Developer");
                person.setAge(23);
                moveWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObject);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "+6287778043255";
                Intent dialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialNumber);
                break;
        }
    }
}
