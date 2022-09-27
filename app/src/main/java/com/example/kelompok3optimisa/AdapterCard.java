package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {

    private ArrayList<ModelMahasiswa> dataMahasiswa;

    public AdapterCard(ArrayList<ModelMahasiswa> dataMahasiswa) {
        this.dataMahasiswa = dataMahasiswa;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelMahasiswa data);
    }

    private AdapterCard.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack (AdapterCard.OnItemClickCallBack callBack) {
       this.callBack = callBack;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mahasiswa,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelMahasiswa mahasiswa = dataMahasiswa.get(position);

        holder.tvNamaMahasiswa.setText(mahasiswa.getNamamhs());
        holder.tvNimMahasiswa.setText(mahasiswa.getNimmhs());
        holder.tvHariTanggal.setText(mahasiswa.getHaritanggal());
        holder.tvPukul.setText(mahasiswa.getPukul());
        holder.tvRuang.setText(mahasiswa.getRuang());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(dataMahasiswa.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataMahasiswa.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMahasiswa;
        TextView tvNamaMahasiswa,tvNimMahasiswa, tvHariTanggal, tvPukul, tvRuang;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMahasiswa = itemView.findViewById(R.id.iv_mhs);
            tvNamaMahasiswa = itemView.findViewById(R.id.tv_namamhs);
            tvNimMahasiswa = itemView.findViewById(R.id.tv_nimmhs);
            tvHariTanggal = itemView.findViewById(R.id.tv_haritanggal);
            tvPukul = itemView.findViewById(R.id.tv_pukul);
            tvRuang = itemView.findViewById(R.id.tv_ruang);
        }
    }
}
