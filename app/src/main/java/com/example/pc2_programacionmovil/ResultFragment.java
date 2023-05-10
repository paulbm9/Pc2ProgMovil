package com.example.pc2_programacionmovil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_EDAD = "edad";

    private String nombre;
    private int edad;

    public ResultFragment() {
        // Constructor vacío requerido
    }

    public static ResultFragment newInstance(String nombre, int edad) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        args.putInt(ARG_EDAD, edad);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString(ARG_NOMBRE);
            edad = getArguments().getInt(ARG_EDAD);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView textViewResultado = view.findViewById(R.id.textViewResultado);
        textViewResultado.setText("¡Hola " + nombre + "! Tienes " + edad + " años.");
        return view;
    }
}
