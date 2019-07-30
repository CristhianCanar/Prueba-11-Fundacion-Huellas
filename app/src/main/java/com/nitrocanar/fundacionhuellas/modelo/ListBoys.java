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

public class ListBoys {

    public Boolean createFile(){

        try {
            File ruta = Environment.getExternalStorageDirectory();

            File file = new File(ruta.getAbsolutePath(), "datos.txt");

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));

            writer.write(Constantes.DATOS_NINOS);
            writer.close();

            return true;

        }catch (Exception e){

            Log.e("Fichero", "Error al escribir fichero");

        }

        return false;
    }

    public void bringData(){

        ArrayList<String> listData = new ArrayList<>();

        Boolean create = createFile();

        if (create){

            try{


                File ruta = Environment.getExternalStorageDirectory();

                File file = new File(ruta.getAbsolutePath(), "fichero.txt");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                String content = bufferedReader.readLine();

                while (bufferedReader.ready()){

                    listData.add(content);



                }


                bufferedReader.close();


            }catch (Exception e){
                Log.e("Fichero", "Error al leer");
            }

        }

    }

}
