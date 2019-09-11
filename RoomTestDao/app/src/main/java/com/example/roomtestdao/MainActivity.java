package com.example.roomtestdao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pacientName, pacientSurName,pacientBirth,pacientEmail;
    private Button mGuardar;
    private Button mBorrar;

    private PacientLab pacientLab;
    private Pacient pacient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pacientName = findViewById(R.id.name);
        pacientSurName = findViewById(R.id.surname);
        pacientBirth = findViewById(R.id.birthday);
        pacientEmail = findViewById(R.id.email);

        pacientLab = PacientLab.get(this);
        List<Pacient> pacients = pacientLab.getPacients();
        if(pacients.size() > 0) {
            pacient = pacients.get(0);
            pacientName.setText(pacient.getName());
            pacientSurName.setText(pacient.getSurname());
            pacientEmail.setText(pacient.getEmail());
            pacientBirth.setText(pacient.getBirthday());
        }

        mGuardar = findViewById(R.id.boton_guardar);
        mGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        mBorrar = findViewById(R.id.boton_borrar);
        mBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });

    }

    /**
     * Borra la nota si existe (si pacient no es null).
     */
    private void borrar() {
        if(pacient != null) {
            pacientLab.deletePacient(pacient);
            pacient = null;
            pacientName.setText("");
            Toast.makeText(this, "paciente borrado",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "no existe este paciente",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Guarda la nota si no existe (pacient es null), o la actualiza si existe.
     */
    private void guardar() {
        String pacientName = this.pacientName.getText().toString();
        if(!pacientName.equals("")) {
            if(pacient == null) {
                pacient = new Pacient();
                pacient.setName(pacientName);
                pacientLab.addPacient(pacient);
                Toast.makeText(this, "paciente creado",
                        Toast.LENGTH_SHORT).show();
            } else {
                pacient.setName(pacientName);
                pacientLab.updatePacient(pacient);
                Toast.makeText(this, "paciente actualizado",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "crea al paciente primero",
                    Toast.LENGTH_SHORT).show();
        }
    }
}