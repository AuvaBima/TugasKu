package com.amikom.tugasku.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Jadwal {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "hari")
    private String hari;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    @ColumnInfo(name = "makul")
    private String mataKuliah;

    @ColumnInfo(name = "dosen")
    private String dosen;

    public Jadwal() {

    }

    @Ignore

    public Jadwal(int id, String hari, String tanggal, String keterangan, String mataKuliah, String dosen) {
        this.id = id;
        this.hari = hari;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }
}
