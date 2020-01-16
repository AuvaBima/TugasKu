package com.amikom.tugasku.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.amikom.tugasku.model.Jadwal;

@Database(entities = {Jadwal.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "amikom")
                .allowMainThreadQueries()
                .build();
    }

    public abstract JadwalRoom jadwalRoom();

}
