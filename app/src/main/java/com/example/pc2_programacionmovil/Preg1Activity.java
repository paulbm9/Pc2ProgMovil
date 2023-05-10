package com.example.pc2_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Preg1Activity extends AppCompatActivity {

    EditText editTextNombre, editTextSueldo, editTextFechadeNacimiento;
    Button btnMostrarDatos, btnLimpiar1;
    TextView txtResultado;
    CheckBox checkBoxEscucharMusica, checkBoxDormir, checkBoxIralCine, checkBoxJugarFutbol;
    RadioGroup radioGroupGenero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg1);
        //Vinculamos
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextSueldo = findViewById(R.id.editTextSueldo);
        editTextFechadeNacimiento = findViewById(R.id.editTextFechadeNacimiento);
        btnMostrarDatos = findViewById(R.id.btnMostrarDatos);
        btnLimpiar1 = findViewById(R.id.btnLimpiar1);
        radioGroupGenero = findViewById(R.id.radioGroupGenero);
        txtResultado = findViewById(R.id.textViewResultado);
        checkBoxEscucharMusica = findViewById(R.id.checkBoxEscucharMusica);
        checkBoxDormir = findViewById(R.id.checkBoxDormir);
        checkBoxIralCine = findViewById(R.id.checkBoxIralCine);
        checkBoxJugarFutbol = findViewById(R.id.checkBoxJugarFutbol);

    }


    public void MostrarDatos(View view) {


        double sueldo = 0.0;

        String etnombre = editTextNombre.getText().toString();
        String etfecha = editTextFechadeNacimiento.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = format.parse(etfecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);
        Calendar fechaActual = Calendar.getInstance();


        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.MONTH) < fechaNacimientoCal.get(Calendar.MONTH) || (fechaActual.get(Calendar.MONTH) == fechaNacimientoCal.get(Calendar.MONTH) && fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCal.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        String hobbies = "";
        if (checkBoxEscucharMusica.isChecked()) {
            hobbies += "Escuchar música, ";
        }
        if (checkBoxDormir.isChecked()) {
            hobbies += "Dormir, ";
        }
        if (checkBoxIralCine.isChecked()) {
            hobbies += "Ir al cine, ";
        }
        if (checkBoxJugarFutbol.isChecked()) {
            hobbies += "Jugar fútbol, ";
        }


        String genero = "";
        if (radioGroupGenero.getCheckedRadioButtonId() == R.id.rbuttonMasculino) {
            genero = "masculino";
        } else {
            genero = "femenino";
        }


        String etsueldo = editTextSueldo.getText().toString();


        String resultado = "Sr. " + etnombre + ", usted tiene " + edad + " años y recibe un sueldo de " + etsueldo + ". Su género es " + genero + ". Sus Hobbies son: " + hobbies;


        txtResultado.setText(resultado);

    }

    public void Limpiar1(View view) {
        editTextNombre.setText("");
        editTextSueldo.setText("");
        editTextFechadeNacimiento.setText("");
        txtResultado.setText("");
    }
}