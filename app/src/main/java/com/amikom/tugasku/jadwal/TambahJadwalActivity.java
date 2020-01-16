package com.amikom.tugasku.jadwal;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import com.amikom.tugasku.MainActivity;
import com.amikom.tugasku.R;
import com.amikom.tugasku.helper.Notification;
import com.amikom.tugasku.model.Jadwal;
import com.amikom.tugasku.room.AppDatabase;
import com.amikom.tugasku.room.JadwalRoom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class TambahJadwalActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtHari;
    EditText edtMakul;
    EditText edtTanggal;
    EditText edtKeterangan;
    EditText edtDosen;
    Button btnTambah;
    Button btnUpdate;
    Button btnHapus;
    JadwalRoom room;
    Jadwal jadwal;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jadwal);
        Notification.init(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Jadwal");
        edtHari = findViewById(R.id.tambah_jadwal_hari);
        edtMakul = findViewById(R.id.tambah_jadwal_makul);
        //edtTanggal = findViewById(R.id.tambah_jadwal_tanggal);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tambah_jadwal_tanggal);
        btDatePicker = (EditText) findViewById(R.id.tambah_jadwal_tanggal);

        edtKeterangan = findViewById(R.id.tambah_jadwal_keterangan);
        edtDosen = findViewById(R.id.tambah_jadwal_dosen);
        btnTambah = findViewById(R.id.tambah_jadwal);
        btnUpdate = findViewById(R.id.update_jadwal);
        btnHapus = findViewById(R.id.hapus_jadwal);
        btnTambah.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnHapus.setOnClickListener(this);

        btDatePicker = (EditText) findViewById(R.id.tambah_jadwal_tanggal);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        room = AppDatabase.db(this).jadwalRoom();
        int id = getIntent().getIntExtra("id", 0);
        jadwal = room.select(id);
        if (jadwal != null) {
            edtHari.setText(jadwal.getHari());
            edtMakul.setText(jadwal.getMataKuliah());
            tvDateResult.setText(jadwal.getTanggal());
            edtKeterangan.setText(jadwal.getKeterangan());
            edtDosen.setText(jadwal.getDosen());
            btnUpdate.setVisibility(View.VISIBLE);
            btnHapus.setVisibility(View.VISIBLE);
        } else {
            btnTambah.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnTambah)) {
            Jadwal jadwalBaru = new Jadwal();
            jadwalBaru.setHari(edtHari.getText().toString());
            jadwalBaru.setMataKuliah(edtMakul.getText().toString());
            jadwalBaru.setTanggal(tvDateResult.getText().toString());
            jadwalBaru.setKeterangan(edtKeterangan.getText().toString());
            jadwalBaru.setDosen(edtDosen.getText().toString());
            room.insert(jadwalBaru);
            Notification.notify(this, "Tambah", "Berhasil tambah data",
                    new Intent(this, MainActivity.class));
        } else if (v.equals(btnUpdate)) {
            jadwal.setHari(edtHari.getText().toString());
            jadwal.setMataKuliah(edtMakul.getText().toString());
            jadwal.setTanggal(tvDateResult.getText().toString());
            jadwal.setKeterangan(edtKeterangan.getText().toString());
            jadwal.setDosen(edtDosen.getText().toString());
            room.update(jadwal);
            Notification.notify(this, "Update", "Berhasil update data",
                    new Intent(this, MainActivity.class));
        } else if (v.equals(btnHapus)) {
            room.delete(jadwal);
            Notification.notify(this, "Hapus", "Berhasil hapus data",
                    new Intent(this, MainActivity.class));
        }
        setResult(Activity.RESULT_OK, new Intent());
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
