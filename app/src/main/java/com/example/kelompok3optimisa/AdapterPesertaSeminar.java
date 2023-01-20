package com.example.kelompok3optimisa;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPesertaSeminar extends RecyclerView.Adapter<AdapterPesertaSeminar.PesertaSeminarViewHolder> {

    ArrayList<ModelPesertaSeminar> dataPesertaSeminar = new ArrayList<>();
    PesertaSeminarClickListener listener;

    public AdapterPesertaSeminar(ArrayList<ModelPesertaSeminar> dataPesertaSeminar) {
        this.dataPesertaSeminar = dataPesertaSeminar;
    }

    public void setDataPesertaSeminar(ArrayList<ModelPesertaSeminar> dataPesertaSeminar) {
        this.dataPesertaSeminar = dataPesertaSeminar;
    }

    public void setListener(PesertaSeminarClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PesertaSeminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pesertaseminar,parent,false);
        return new PesertaSeminarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaSeminarViewHolder holder, int position) {
        ModelPesertaSeminar pesertaSeminar = dataPesertaSeminar.get(position);

        holder.tvNamaPeserta.setText(pesertaSeminar.getNamaPeserta());
        holder.tvNimPeserta.setText(pesertaSeminar.getNimPeserta());
    }

    @Override
    public int getItemCount() {
        return dataPesertaSeminar.size();
    }

    public interface PesertaSeminarClickListener{
        void onPesertaSeminarClick(ModelPesertaSeminar pesertaSeminar);
    }

    public class PesertaSeminarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvNamaPeserta, tvNimPeserta;
        public ImageView BtnAccept, BtnReject;

        public PesertaSeminarViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaPeserta= itemView.findViewById(R.id.tv_namapeserta);
            tvNimPeserta = itemView.findViewById(R.id.tv_nimpeserta);
            BtnAccept = itemView.findViewById(R.id.btn_verifya);
            BtnReject = itemView.findViewById(R.id.btn_verifga);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ModelPesertaSeminar pesertaSeminar = dataPesertaSeminar.get(getAdapterPosition());
            listener.onPesertaSeminarClick(pesertaSeminar);
        }
    }

}