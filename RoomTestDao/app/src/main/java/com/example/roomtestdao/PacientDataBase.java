package com.example.roomtestdao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pacient.class}, version = 1)
public abstract class PacientDataBase extends RoomDatabase {
    public abstract PacientDao getNotaDao();
}
