package com.yagya.esoftwaricassignment.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yagya.esoftwaricassignment.R;
import com.yagya.esoftwaricassignment.Student;
import com.yagya.esoftwaricassignment.adapter.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Rupesh Dhakal", "22", "Balaju", "Male"));
        studentList.add(new Student("Rita Sharma", "25", "Baneshwor", "Female"));
        StudentAdapter studentAdapter = new StudentAdapter(getContext(), studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
