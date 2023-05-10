package com.example.pc2_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class Preg3Activity extends AppCompatActivity {

    EditText editTextNombre, editTextAnio;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg3);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextAnio = findViewById(R.id.editTextAnio);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularEdad();
            }
        });
    }

    private void calcularEdad() {
        String nombre = editTextNombre.getText().toString();
        int anio = Integer.parseInt(editTextAnio.getText().toString());
        int edad = obtenerEdad(anio);

        ResultFragment resultFragment = ResultFragment.newInstance(nombre, edad);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, resultFragment);
        fragmentTransaction.commit();
    }

    private int obtenerEdad(int anio) {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return anioActual - anio;
    }
}
