package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.DashboardViewHolder> {

    ArrayList<ModelDashboard> dataDashboard = new ArrayList<>();
    DashboardClickListener listener;

    public AdapterDashboard(ArrayList<ModelDashboard> dataDashboard) {
        this.dataDashboard = dataDashboard;
    }

    public void setDataDashboard(ArrayList<ModelDashboard> dataDashboard) {
        this.dataDashboard = dataDashboard;
    }

    public void setListener(DashboardClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dashboard,parent,false);
        return new DashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        ModelDashboard dashboard = dataDashboard.get(position);

        holder.ivFotoMain.setImageResource(R.drawable.logo_unand);
        holder.tvNamaMain.setText(dashboard.getNamaMain());
        holder.tvNimMain.setText(dashboard.getNimMain());

    }

    @Override
    public int getItemCount() {
        return dataDashboard.size();
    }

    public interface DashboardClickListener{
        void onDashboardClick(ModelDashboard dashboard);
    }

    public class DashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivFotoMain;
        public TextView tvNamaMain, tvNimMain, tvTtlMain, tvAlamatMain, tvLokasiKPMain;

        public DashboardViewHolder (@NonNull View itemView) {
            super(itemView);
            ivFotoMain = itemView.findViewById(R.id.iv_fotomain);
            tvNamaMain = itemView.findViewById(R.id.tv_namamain);
            tvNimMain = itemView.findViewById(R.id.tv_nimmain);
            tvTtlMain = itemView.findViewById(R.id.tv_ttlmain);
            tvAlamatMain = itemView.findViewById(R.id.tv_alamatmain);
            tvLokasiKPMain = itemView.findViewById(R.id.tv_lokasikpmain);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ModelDashboard dashboard = dataDashboard.get(getAdapterPosition());
            listener.onDashboardClick(dashboard);
        }

    }
}