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

    private ArrayList<ModelDashboard> dataDashboard;

    public AdapterDashboard(ArrayList<ModelDashboard> dataDashboard) {
        this.dataDashboard = dataDashboard;
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

        holder.tvNamaMain.setText(dashboard.getNamaMain());
        holder.tvNimMain.setText(dashboard.getNimMain());

    }

    @Override
    public int getItemCount() {
        return dataDashboard.size();
    }

    public class DashboardViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaMain,tvNimMain;

        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaMain = itemView.findViewById(R.id.tv_namamain);
            tvNimMain = itemView.findViewById(R.id.tv_nimmain);
        }
    }
}