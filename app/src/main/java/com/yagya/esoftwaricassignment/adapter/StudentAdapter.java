package com.yagya.esoftwaricassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yagya.esoftwaricassignment.R;
import com.yagya.esoftwaricassignment.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final Context context;
    Context Context;
    List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList){
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        final Student student = studentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(student.getAge());
        holder.tvAddress.setText(student.getAddress());
        holder.tvGender.setText(student.getGender());

        String gender = student.getGender();

        if (gender=="Male") {
            holder.ivProfile.setImageResource(R.drawable.male);
        }
        else if(gender=="Female"){
            holder.ivProfile.setImageResource(R.drawable.female);
        }
        else {
            holder.ivProfile.setImageResource(R.drawable.other);
        }

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"hi" +student.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student st = studentList.get(position);
                studentList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(context,"Removed:" +st.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile;
        TextView tvName, tvAge, tvAddress, tvGender;
        Button btnDelete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvGender = itemView.findViewById(R.id.tvGender);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
