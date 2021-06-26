package com.example.prefinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prefinal.Model.Lop;
import com.example.prefinal.Model.Student;
import com.example.prefinal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewStudentAdapter extends RecyclerView.Adapter<RecyclerViewStudentAdapter.ViewHolder>{
    private List<Student> listStudent;
    private Context context;

    public RecyclerViewStudentAdapter() {
        this.listStudent = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_student, parent, false);
        return new RecyclerViewStudentAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewStudentAdapter.ViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.maSv.setText("Ma sinh vien: " + student.getMaSV());
        holder.tenSV.setText("Ten sinh vien: " + student.getTen());
        holder.namsinh.setText("nam sinh: " + student.getNamSinh());
        holder.quequan.setText("que quan: " + student.getQueQuan());
        holder.namhoc.setText("nam hoc: " + student.getNamHoc());
    }

    public void updateDataStudent(List<Student> stu){
        this.listStudent = stu;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (listStudent == null) ? 0 : listStudent.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView maSv, tenSV, namsinh, quequan, namhoc;
        private RecyclerViewClassAdapter.ViewHolder.ClickListener clickListener;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            maSv = itemView.findViewById(R.id.tv_detail_maSv);
            tenSV = itemView.findViewById(R.id.tv_detail_tenSv);
            namsinh = itemView.findViewById(R.id.tv_detail_namsinh);
            quequan = itemView.findViewById(R.id.tv_detail_quequan);
            namhoc = itemView.findViewById(R.id.tv_detail_namhoc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickListener(getAdapterPosition(), v);
        }

        public void setClickListener(RecyclerViewClassAdapter.ViewHolder.ClickListener listener) {
            this.clickListener = listener;
        }

        public interface ClickListener {
            void onClickListener(int position, View v);
        }

    }

}
