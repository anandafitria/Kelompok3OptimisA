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

public class AdapterLogbook extends RecyclerView.Adapter<AdapterLogbook.LogbookViewHolder> {

    private ArrayList<ModelLogbook> dataLogbook;

    public AdapterLogbook(ArrayList<ModelLogbook> dataLogbook) {
        this.dataLogbook = dataLogbook;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelLogbook data2);
    }

    private AdapterLogbook.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack (AdapterLogbook.OnItemClickCallBack callBack) {
        this.callBack = callBack;
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

        holder.tvNamaLogbook.setText(logbook.getNamaLogbook());
        holder.tvNimLogbook.setText(logbook.getNimLogbook());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(dataLogbook.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataLogbook.size();
    }

    public class LogbookViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaLogbook,tvNimLogbook;
        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaLogbook= itemView.findViewById(R.id.tv_namalogbook);
            tvNimLogbook = itemView.findViewById(R.id.tv_nimlogbook);
        }
    }
}
