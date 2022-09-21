package com.example.kelompok3optimisa;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswaAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<ListMahasiswa> listmhs = new ArrayList<>();

    public ListMahasiswaAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setListmhs(ArrayList<ListMahasiswa> listmhs) {
        this.listmhs = listmhs;
    }

    @Override
    public int getCount() {
        return listmhs.size();
    }

    @Override
    public Object getItem(int position) {
        return listmhs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = view;

        if(itemView == null){
            itemView = LayoutInflater.from(ctx).inflate(R.layout.activity_list_mahasiswa, viewGroup, false );
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        ListMahasiswa listmhs = (ListMahasiswa) getItem(position);
        viewHolder.bind(listmhs);
        return itemView;
    }

    private  class ViewHolder {
        private ImageView fotomhs;
        private TextView namamhs, nimmhs, hariseminar, jamseminar, pengujiseminar;

        ViewHolder (View view) {
            fotomhs = view.findViewById(R.id.fotomhs);
            namamhs = view.findViewById(R.id.namamhs);
            nimmhs = view.findViewById(R.id.nimmhs);
            hariseminar = view.findViewById(R.id.hariseminar);
            jamseminar = view.findViewById(R.id.jamseminar);
            pengujiseminar = view.findViewById(R.id.pengujiseminar);
        }

        void bind(ListMahasiswa listmhs) {
            fotomhs.setImageResource(listmhs.getFoto());
            namamhs.setText(listmhs.getNama());
            nimmhs.setText(listmhs.getNIM());
            hariseminar.setText(listmhs.getHariTanggal());
            jamseminar.setText(listmhs.getJam());
            pengujiseminar.setText(listmhs.getPenguji());
        }
    }
}
