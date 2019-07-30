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

                    content = line.split(",");

                    for (int i = 0; i < (content.length/(3)); i++){


                        for (int x = 0;  x < content.length; x++){
                            int col1 = 0;
                            int col2 = 1;
                            int col3 = 3;
                            boy.setNinNombre(content[col1]);
                            boy.setNinApellido(content[col2]);
                            boy.setNinEdad(content[col3]);
                            col1 = col1 +3;
                            col2 = col2 + 3;
                            col3 = col3 + 3;

                        }

                        listData.add(boy);


                    }
                }
            }


            bufferedReader.close();


        } catch (Exception e) {
            Log.e("Fichero", "Error al leer");
        }

        return listData;

    }

}
