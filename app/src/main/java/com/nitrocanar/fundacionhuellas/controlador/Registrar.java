package com.nitrocanar.fundacionhuellas.controlador;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nitrocanar.fundacionhuellas.R;
import com.nitrocanar.fundacionhuellas.modelo.Lienzo;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    private Button btnBorrar, btnDibujar;
    private Lienzo lienzo;

    EditText etNombre, etApellido,etTelefono,etEmail,etContrasenia,etEdad;
    Button btnGuardar;

    int tamanioLapiz,largeBorrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        referent();

    }

    private void referent() {

        lienzo = findViewById(R.id.view2);

        btnBorrar = findViewById(R.id.btnBorrador);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lienzo.clear(true);
            }
        });

        btnDibujar = findViewById(R.id.btnPencil);
        btnDibujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lienzo.clear(false);
            }
        });

        etNombre = findViewById(R.id.etNombreReg);
        etApellido = findViewById(R.id.etApellidoReg);
        etContrasenia = findViewById(R.id.etContraseniaReg);
        etEmail = findViewById(R.id.etEmailReg);
        etEdad= findViewById(R.id.etEdadReg);
        etTelefono = findViewById(R.id.etTelefonoReg);

        btnGuardar=findViewById(R.id.btnEnviarDatosReg);
        btnGuardar.setOnClickListener(this);


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
