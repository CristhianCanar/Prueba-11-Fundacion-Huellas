package com.nitrocanar.fundacionhuellas;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    EditText etNombre, etApellido,etTelefono,etEmail,etContrasenia,etEdad;
    Button btnGuardar, btnLapiz, btnBorrador;
    Lienzo lienzo;


    int tamanioLapiz,largeBorrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNombre = findViewById(R.id.etNombreReg);
        etApellido = findViewById(R.id.etApellidoReg);
        etContrasenia = findViewById(R.id.etContraseniaReg);
        etEmail = findViewById(R.id.etEmailReg);
        etEdad= findViewById(R.id.etEdadReg);
        etTelefono = findViewById(R.id.etTelefonoReg);

        btnGuardar=findViewById(R.id.btnEnviarDatosReg);
        btnGuardar.setOnClickListener(this);

        btnBorrador=findViewById(R.id.btnBorrador);
        btnBorrador.setOnClickListener(this);

        btnLapiz=findViewById(R.id.btnPencil);
        btnLapiz.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEnviarDatosReg:

                break;

            case R.id.btnPencil:


                lienzo.setBorrado(false);
                tamanioLapiz = 10;
                lienzo.setLapiz(tamanioLapiz);

                break;

            case R.id.btnBorrador:
                lienzo.setBorrado(true);
                largeBorrador = 30;
                break;
        }
    }
}
