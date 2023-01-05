package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompok3optimisa.R;
import com.example.kelompok3optimisa.datamodels.LogbooksItem;
import com.example.kelompok3optimisa.datamodels.ListLogbookResponse;

import java.util.ArrayList;
import java.util.List;

public class AdapterLogPribadi extends RecyclerView.Adapter<AdapterLogPribadi.LogPribadiViewHolder>{
    private List<LogbooksItem> itemList = new ArrayList<>();

    public void setItemList(List<LogbooksItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    ItemLogPribadiClickListener listener;

    public void setListener(ItemLogPribadiClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LogPribadiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_logbookpribadi, parent, false);
        return new LogPribadiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogPribadiViewHolder holder, int position) {
        LogbooksItem logbooks = itemList.get(position);
        holder.ID.setText(String.valueOf(logbooks.getId()));
        holder.Tanggal.setText(logbooks.getDate());
        holder.Aktifitas.setText(logbooks.getActivities());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface ItemLogPribadiClickListener{
        void onItemLogPribadiClick(LogbooksItem logbooks);
    }

    public class LogPribadiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView ID, Tanggal, Aktifitas;

        public LogPribadiViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.IDlogbook);
            Tanggal = itemView.findViewById(R.id.TGLlogbook);
            Aktifitas = itemView.findViewById(R.id.aktifitas);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            LogbooksItem logbooks = itemList.get(getAdapterPosition());
            listener.onItemLogPribadiClick(logbooks);
        }
    }
}
