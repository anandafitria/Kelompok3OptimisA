package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDashboardAPI extends RecyclerView.Adapter<AdapterDashboardAPI.DashboardAPIViewHolder> {

    ArrayList<ModelDashboardAPI> dataDashboardAPI = new ArrayList<>();
    DashboardAPIClickListener listener;

    public AdapterDashboardAPI(ArrayList<ModelDashboardAPI> dataDashboardAPI) {
        this.dataDashboardAPI = dataDashboardAPI;
    }

    public void setDataDashboardAPI(ArrayList<ModelDashboardAPI> dataDashboardAPI) {
        this.dataDashboardAPI = dataDashboardAPI;
    }

    public void setListener(DashboardAPIClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DashboardAPIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dashboard_api,parent,false);
        return new DashboardAPIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAPIViewHolder holder, int position) {
        ModelDashboardAPI dashboardAPI = dataDashboardAPI.get(position);

        holder.ivFotoMain.setImageResource(dashboardAPI.getFotoDashboard());
        holder.tvNamaMain.setText(dashboardAPI.getNamaDashboard());
        holder.tvNimMain.setText(dashboardAPI.getNimDashboard());

    }

    @Override
    public int getItemCount() {
        return dataDashboardAPI.size();
    }

    public interface DashboardAPIClickListener{
        void onDashboardAPIClick(ModelDashboardAPI dashboardAPI);
    }

    public class DashboardAPIViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivFotoMain;
        public TextView tvNamaMain, tvNimMain, tvTtlMain, tvAlamatMain, tvLokasiKPMain;

        public DashboardAPIViewHolder (@NonNull View itemView) {
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
            ModelDashboardAPI dashboardAPI = dataDashboardAPI.get(getAdapterPosition());
            listener.onDashboardAPIClick(dashboardAPI);
        }

    }
}