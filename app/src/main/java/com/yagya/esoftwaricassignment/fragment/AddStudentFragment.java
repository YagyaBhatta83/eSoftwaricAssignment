package com.yagya.esoftwaricassignment.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yagya.esoftwaricassignment.MainActivity;
import com.yagya.esoftwaricassignment.R;
import com.yagya.esoftwaricassignment.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment {
    private EditText etFullName, etAge, etAddress;
    private Button btnSave;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbOther;
    String name, age, address, gender;


    public AddStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        etFullName = view.findViewById(R.id.etFullName);
        etAge = view.findViewById(R.id.etAge);
        etAddress = view.findViewById(R.id.etAddress);
        rgGender = view.findViewById(R.id.rgGender);
        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);
        rbOther = view.findViewById(R.id.rbOther);
        btnSave = view.findViewById(R.id.btnSave);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbMale) {
                    gender = "Male";
                }
                if (checkedId == R.id.rbFemale) {
                    gender = "Female";
                }
                if (checkedId == R.id.rbOther) {
                    gender = "Others";
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etFullName.getText().toString();
                address = etAddress.getText().toString();
                age = etAge.getText().toString();

                if(TextUtils.isEmpty(name))
                {
                    etFullName.setError("Enter a name");
                    return;
                }
                if(TextUtils.isEmpty(age))
                {
                    etAge.setError("Enter a age");
                    return;
                }
                if(TextUtils.isEmpty(address))
                {
                    etAddress.setError("Enter a Address");
                    return;
                }
                if(TextUtils.isEmpty(gender))
                {
                    Toast.makeText(getActivity(), "Select a Gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                MainActivity.studentList.add(new Student(name,age,address,gender));
                Toast.makeText(getActivity(), "Student added", Toast.LENGTH_SHORT).show();

                etFullName.setText("");
                etAge.setText("");
                etAddress.setText("");
                rgGender.clearCheck();

            }
        });
        return view;
    }
}
