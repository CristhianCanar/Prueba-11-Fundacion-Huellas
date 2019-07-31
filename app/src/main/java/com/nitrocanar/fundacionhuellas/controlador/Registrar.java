package com.nitrocanar.fundacionhuellas.controlador;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nitrocanar.fundacionhuellas.R;
import com.nitrocanar.fundacionhuellas.modelo.Lienzo;

public class Registrar extends AppCompatActivity {

    private Button btnBorrar, btnDibujar;
    private Lienzo lienzo;

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

    }

}
