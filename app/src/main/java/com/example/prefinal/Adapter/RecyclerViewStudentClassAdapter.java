package com.example.prefinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prefinal.Model.StudentClass;
import com.example.prefinal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewStudentClassAdapter extends RecyclerView.Adapter<RecyclerViewStudentClassAdapter.ViewHolder>{
    private List<StudentClass> listStudentClass;
    private Context context;

    public RecyclerViewStudentClassAdapter() {
        this.listStudentClass = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewStudentClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_studentclass, parent, false);
        return new RecyclerViewStudentClassAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewStudentClassAdapter.ViewHolder holder, int position) {
        StudentClass studentClass = listStudentClass.get(position);
        holder.sinhVien.setText("Sinh viên: " + studentClass.getStudentId().getTen());
        holder.lopHoc.setText("Lớp học: " + studentClass.getClassroomId().getTenLop());
        holder.kyHoc.setText("Kỳ học: " + studentClass.getSemester());
        holder.tinChi.setText("Tín chỉ: " + studentClass.getCredits());
    }

    public void updateDataStudent(List<StudentClass> studentClasses){
        this.listStudentClass = studentClasses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (listStudentClass == null) ? 0 : listStudentClass.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView sinhVien, lopHoc, kyHoc, tinChi;
        private RecyclerViewStudentClassAdapter.ViewHolder.ClickListener clickListener;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            sinhVien = itemView.findViewById(R.id.tv_detail_sinhVien);
            lopHoc = itemView.findViewById(R.id.tv_detail_lopHoc);
            kyHoc = itemView.findViewById(R.id.tv_detail_kyHoc);
            tinChi = itemView.findViewById(R.id.tv_detail_tinChi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickListener(getAdapterPosition(), v);
        }

        public interface ClickListener {
            void onClickListener(int position, View v);
        }
    }
}

