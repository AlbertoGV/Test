package com.example.roomtestdao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
interface PacientDao {
    @Query("SELECT * FROM pacient")
    List<Pacient> getPacients();

    @Query("SELECT * FROM pacient WHERE id LIKE :uuid")
    Pacient getPacient(String uuid);

    @Insert
    void addPacient(Pacient pacient);

    @Delete
    void deletePacient(Pacient pacient);

    @Update
    void updatePacient(Pacient pacient);


}