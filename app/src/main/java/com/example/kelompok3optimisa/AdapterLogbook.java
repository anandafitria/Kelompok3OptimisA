package com.example.kelompok3optimisa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompok3optimisa.datamodels.LogbooksItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterLogbook extends RecyclerView.Adapter<AdapterLogbook.LogbookViewHolder> {

    private List<LogbooksItem> item;
    private List<LogbooksItem> itemList;

    public AdapterLogbook(ArrayList<ModelLogbook> logbook) {
    }

    public void setItemList(List<LogbooksItem> itemList) {
        this.itemList = itemList;
    }

    ArrayList<LogbooksItem> logbooks = new ArrayList<>();
    ItemLogbookClickListener listener;

    public void AdapterLogbook(ArrayList<LogbooksItem> logbooks) {
        this.logbooks = logbooks;
    }

    public AdapterLogbook(ArrayList<LogbooksItem> logbooks, ItemLogbookClickListener listener) {
        this.logbooks = logbooks;
        this.listener = listener;
    }

    public void setLogbooks(ArrayList<LogbooksItem> logbooks) {
        this.logbooks = logbooks;
        //notifyDataSetChanged();
    }

    public void setListener(ItemLogbookClickListener listener){
        this.listener = listener;
    }

    //LogbookClickListener listenerItemList;
    //public void setItemList(List<LogbooksItem> itemList) {
    //= new ArrayList<>();
    //this.itemList = itemList;
    //notifyDataSetChanged();
//
//    }

    //public static void setItem(List<LogbooksItem> listLogbook) {
    //}

    //ArrayList<ModelLogbook> dataLogbook = new ArrayList<>();
    //LogbookClickListener listener;

    //public AdapterLogbook(ArrayList<ModelLogbook> dataLogbook) {
    //this.dataLogbook = dataLogbook;
    //}

    //public void setDataLogbook(ArrayList<ModelLogbook> dataLogbook) {
    //this.dataLogbook = dataLogbook;
    //}

    //public void setListener(LogbookClickListener listener) {
    //this.listener = listener;
    //}

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_logbook, parent, false);
        return new LogbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
        LogbooksItem logbooks = itemList.get(position);
        LogbooksItem logbooksItem = this.logbooks.get(position);
        holder.agendaLogbook.setText(logbooks.getAgenda());
        holder.tanggalLogbook.setText(logbooks.getTanggal());
        //holder.ivFotoLogbook.setImage(logbooks.getFotoLogbook());
        //holder.tvHariTglLogbook.setText(logbooks.getHariTglLogbook());
        //holder.tvNamaLogbook.setText(logbooks.getNamaLogbook());
        //holder.tvNimLogbook.setText(logbooks.getNimLogbook());
        //holder.tvLokasiKPLogbook.setText(logbooks.getLokasiKPLogbook());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface ItemLogbookClickListener {
        void onItemLogbookClick(LogbooksItem logbooksItem);
    }

    //public interface LogbookClickListener{
    //void onLogbookClick(ModelLogbook logbook);
    //}

    //public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView agendaLogbook;
        public TextView tanggalLogbook;
        //public ImageView ivFotoLogbook;
        //public TextView tvHariTglLogbook, tvNamaLogbook,tvNimLogbook, tvLokasiKPLogbook;

        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);
            agendaLogbook = itemView.findViewById(R.id.progress);
            tanggalLogbook = itemView.findViewById(R.id.date);
            //ivFotoLogbook = itemView.findViewById(R.id.iv_fotologbook);
            //tvHariTglLogbook = itemView.findViewById(R.id.tv_haritgllogbook);
            //tvNamaLogbook= itemView.findViewById(R.id.tv_namalogbook);
            //tvNimLogbook = itemView.findViewById(R.id.tv_nimlogbook);
            //tvLokasiKPLogbook = itemView.findViewById(R.id.tv_lokasikplogbook);
            //itemView.setOnClickListener((View.OnClickListener) this);
            //}

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            LogbooksItem logbooksItem = logbooks.get(getAdapterPosition());
            listener.onItemLogbookClick(logbooksItem);
        }
    }

}