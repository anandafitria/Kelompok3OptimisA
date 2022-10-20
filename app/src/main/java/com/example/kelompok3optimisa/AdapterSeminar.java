package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSeminar extends RecyclerView.Adapter<AdapterSeminar.SeminarViewHolder> {

    private ArrayList<ModelSeminar> dataSeminar = new ArrayList<>();
    SeminarClickListener listener;

    public AdapterSeminar(ArrayList<ModelSeminar> dataSeminar) {
        this.dataSeminar = dataSeminar;
    }

    public void setDataSeminar(ArrayList<ModelSeminar> dataSeminar) {
        this.dataSeminar = dataSeminar;
    }

    public void setListener(SeminarClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SeminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_seminar,parent,false);
        return new SeminarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeminarViewHolder holder, int position) {
        ModelSeminar seminar = dataSeminar.get(position);

        holder.ivFotoSeminar.setImageResource(seminar.getFotoSeminar());
        holder.tvNamaSeminar.setText(seminar.getNamaSeminar());
        holder.tvNimSeminar.setText(seminar.getNimSeminar());
        holder.tvHariSeminar.setText(seminar.getHariSeminar());
        holder.tvJamSeminar.setText(seminar.getJamSeminar());
        holder.tvRuangSeminar.setText(seminar.getRuangSeminar());

    }

    @Override
    public int getItemCount() {
        return dataSeminar.size();
    }

    public interface SeminarClickListener{
        void onSeminarClick(ModelSeminar seminar);
    }

    public class SeminarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivFotoSeminar;
        TextView tvNamaSeminar,tvNimSeminar, tvHariSeminar, tvJamSeminar, tvRuangSeminar;
        public SeminarViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFotoSeminar = itemView.findViewById(R.id.iv_fotoseminar);
            tvNamaSeminar = itemView.findViewById(R.id.tv_namaseminar);
            tvNimSeminar = itemView.findViewById(R.id.tv_nimseminar);
            tvHariSeminar = itemView.findViewById(R.id.tv_hariseminar);
            tvJamSeminar = itemView.findViewById(R.id.tv_jamseminar);
            tvRuangSeminar = itemView.findViewById(R.id.tv_ruangseminar);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ModelSeminar seminar = dataSeminar.get(getAdapterPosition());
            listener.onSeminarClick(seminar);
        }
    }
}
