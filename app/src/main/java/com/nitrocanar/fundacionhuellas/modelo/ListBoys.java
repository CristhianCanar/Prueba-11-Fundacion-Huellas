package com.nitrocanar.fundacionhuellas.modelo;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ListBoys {

    public void createFile() {

        try {

            File ruta = Environment.getExternalStorageDirectory();

            File file = new File(ruta.getAbsolutePath(), "datos.txt");

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));

            writer.write(Constantes.DATOS_NINOS);

            writer.close();

        } catch (Exception e) {

            Log.e("Fichero", "Error al escribir fichero");

        }
    }

    public List<Ninios> bringData() {

        ArrayList<Ninios> listData = new ArrayList<>();

        try {

            createFile();

            File ruta = Environment.getExternalStorageDirectory();

            File file = new File(ruta.getAbsolutePath(), "datos.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String content[];
            String line = "";

            while (bufferedReader.ready()) {

                if ((line = bufferedReader.readLine())!= null){

                    Ninios boy = new Ninios();

                    content = line.split(";");

                    boy.setNinNombre(content[0]);
                    boy.setNinApellido(content[1]);
                    boy.setNinEdad(content[2]);

                    listData.add(boy);

                }
            }


            bufferedReader.close();


        } catch (Exception e) {
            Log.e("Fichero", "Error al leer");
        }

        return listData;

    }

}
