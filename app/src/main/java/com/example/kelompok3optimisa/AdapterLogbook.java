package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLogbook extends RecyclerView.Adapter<AdapterLogbook.LogbookViewHolder> {

    ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();
    LogbookClickListener listener;

    public AdapterLogbook(ArrayList<ModelLogbook> dataLogbook) {
        this.dataLogbook = dataLogbook;
    }

    public void setDataLogbook(ArrayList<ModelLogbook> dataLogbook) {
        this.dataLogbook = dataLogbook;
    }

    public void setListener(LogbookClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_logbook,parent,false);
        return new LogbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
        ModelLogbook logbook = dataLogbook.get(position);

        holder.ivFotoLogbook.setImageResource(logbook.getFotoLogbook());
        holder.tvNamaLogbook.setText(logbook.getNamaLogbook());
        holder.tvNimLogbook.setText(logbook.getNimLogbook());
        holder.tvLokasiKPLogbook.setText(logbook.getLokasiKPLogbook());
    }

    @Override
    public int getItemCount() {
        return dataLogbook.size();
    }

    public interface LogbookClickListener{
        void onLogbookClick(ModelLogbook logbook);
    }

    public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivFotoLogbook;
        public TextView tvNamaLogbook,tvNimLogbook, tvLokasiKPLogbook;

        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFotoLogbook = itemView.findViewById(R.id.iv_fotologbook);
            tvNamaLogbook= itemView.findViewById(R.id.tv_namalogbook);
            tvNimLogbook = itemView.findViewById(R.id.tv_nimlogbook);
            tvLokasiKPLogbook = itemView.findViewById(R.id.tv_lokasikplogbook);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ModelLogbook logbook = dataLogbook.get(getAdapterPosition());
            listener.onLogbookClick(logbook);
        }
    }
}
