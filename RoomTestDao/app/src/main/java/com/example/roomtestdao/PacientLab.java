package com.example.roomtestdao;;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.List;

import androidx.room.Room;

/**
 * Esta clase hace uso de la interfaz NotaDao e interactúa con la base de datos.
 *
 * @author Miguel Callejón Berenguer
 * @version 2018.07
 */
public class PacientLab {
    @SuppressLint("StaticFieldLeak")
    private static PacientLab pacient;

    private PacientDao pacientDao;

    private PacientLab(Context context) {
        Context appContext = context.getApplicationContext();
        PacientDataBase database = Room.databaseBuilder(appContext, PacientDataBase.class, "pacient")
                .allowMainThreadQueries().build();
        pacientDao = database.getNotaDao();
    }

    public static PacientLab get(Context context) {
        if (pacient == null) {
            pacient = new PacientLab(context);
        }
        return pacient;
    }

    public List<Pacient> getPacients() {
        return pacientDao.getPacients();
    }

    public Pacient getPacient(String id) {
        return pacientDao.getPacient(id);
    }

    public void addPacient(Pacient pacient) {
        pacientDao.addPacient(pacient);
    }

    public void updatePacient(Pacient pacient) {
        pacientDao.updatePacient(pacient);
    }

    public void deletePacient(Pacient pacient) {
        pacientDao.deletePacient(pacient);
    }
}