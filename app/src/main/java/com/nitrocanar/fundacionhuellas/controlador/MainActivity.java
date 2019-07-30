package com.nitrocanar.fundacionhuellas.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.nitrocanar.fundacionhuellas.R;
import com.nitrocanar.fundacionhuellas.modelo.ListBoys;

public class MainActivity extends AppCompatActivity {


    private static final String[] MY_PERMISSONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static final int PERMISSONS = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if (checkSelfPermission(MY_PERMISSONS[0]) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(MY_PERMISSONS[1]) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this, MY_PERMISSONS, PERMISSONS);

            }

        }

        ListBoys listBoys = new ListBoys();

        Toast.makeText(this, "Datos" + listBoys.bringData().size(), Toast.LENGTH_SHORT).show();

    }

}
