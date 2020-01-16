package com.amikom.tugasku.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.amikom.tugasku.R;
import com.amikom.tugasku.model.Jadwal;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
    private Context context;
    private List<Jadwal> jadwal;
    private AdapterView.OnItemClickListener listener;

    public JadwalAdapter(Context context, List<Jadwal> jadwal,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.jadwal = jadwal;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_jadwal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Jadwal jadwal = this.jadwal.get(i);
        viewHolder.tvHari.setText(jadwal.getHari());
        viewHolder.tvMakul.setText(jadwal.getMataKuliah());
        viewHolder.tvTanggal.setText(jadwal.getTanggal());
        viewHolder.tvKeterangan.setText(jadwal.getKeterangan());
        viewHolder.tvDosen.setText(jadwal.getDosen());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, v, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jadwal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHari;
        public TextView tvMakul;
        public TextView tvTanggal;
        public TextView tvKeterangan;
        public TextView tvDosen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHari = itemView.findViewById(R.id.jadwal_hari);
            tvMakul = itemView.findViewById(R.id.jadwal_makul);
            tvTanggal = itemView.findViewById(R.id.jadwal_tanggal);
            tvKeterangan = itemView.findViewById(R.id.jadwal_keterangan);
            tvDosen = itemView.findViewById(R.id.jadwal_dosen);
        }
    }
}
