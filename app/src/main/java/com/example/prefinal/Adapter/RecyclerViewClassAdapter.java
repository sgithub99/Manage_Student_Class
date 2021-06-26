package com.example.prefinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prefinal.Model.Lop;
import com.example.prefinal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewClassAdapter extends RecyclerView.Adapter<RecyclerViewClassAdapter.ViewHolder>{
    private List<Lop> listLop;
    private Context context;


    public RecyclerViewClassAdapter() {
        this.listLop = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_class, parent, false);
        return new RecyclerViewClassAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClassAdapter.ViewHolder holder, int position) {
        Lop lop = listLop.get(position);
        holder.maLop.setText("Ma Lop: " + lop.getMaLop());
        holder.tenLop.setText("Ten Lop: " + lop.getTenLop());

        holder.setClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onClickListener(int position, View v) {

            }
        });
    }

    public void updateDataLop(List<Lop> lop) {
        this.listLop = lop;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (listLop == null) ? 0 : listLop.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView maLop, tenLop;
        private ClickListener clickListener;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            maLop = itemView.findViewById(R.id.tv_detail_maLop);
            tenLop = itemView.findViewById(R.id.tv_detail_tenLop);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickListener(getAdapterPosition(), v);
        }

        public void setClickListener(ClickListener listener) {
            this.clickListener = listener;
        }

        public interface ClickListener {
            void onClickListener(int position, View v);
        }
    }

}
