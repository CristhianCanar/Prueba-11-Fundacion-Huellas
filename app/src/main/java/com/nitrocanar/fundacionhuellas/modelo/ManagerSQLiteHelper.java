package com.nitrocanar.fundacionhuellas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ManagerSQLiteHelper {

    //REFERENCIAS
    ArrayList<Ninios> listaNinios = new ArrayList<Ninios>();
    ArrayList<Donante> listaDonante = new ArrayList<Donante>();
    Ninios ninios;
    Donante donante;
    ConexionSQLiteHelper conexionSQLiteHelper;
    SQLiteDatabase db;

    //conexion a bd
    public ManagerSQLiteHelper (Context context){
        conexionSQLiteHelper = new ConexionSQLiteHelper(context);
    }

    public void OpenLeerBD(){
        db = conexionSQLiteHelper.getReadableDatabase();
    }

    public void OpenBD(){
        db = conexionSQLiteHelper.getWritableDatabase();
    }

    public void CerrarBD(){
        if (db != null)
            db.close();
    }

    //insertar datos Niño
    public boolean InsertarDatosNinios (Ninios ninios){
        OpenBD();
        ContentValues contenedor = new ContentValues();
        contenedor.put(Constantes.columna_1_ninios,ninios.getNinNombre());
        contenedor.put(Constantes.columna_2_ninios,ninios.getNinApellido());
        contenedor.put(Constantes.columna_3_ninios,ninios.getNinEdad());
        contenedor.put(Constantes.columna_4_ninios,ninios.getNinFoto());

        return (db.insert(Constantes.nom_tabla_ninios,null,contenedor))>0;

    }

    public boolean InsertarDatosDonante (Donante donante){
        OpenBD();
        ContentValues contenedor = new ContentValues();
        contenedor.put(Constantes.columna_1_donante,donante.getDonNombre());
        contenedor.put(Constantes.columna_2_donante,donante.getDonApellido());
        contenedor.put(Constantes.columna_3_donante,donante.getDonTelefono());
        contenedor.put(Constantes.columna_4_donante,donante.getDonEmail());
        contenedor.put(Constantes.columna_5_donante,donante.getDonContrasenia());
        contenedor.put(Constantes.columna_6_donante,donante.getDonTipo());

        return (db.insert(Constantes.nom_tabla_donante,null,contenedor))>0;
    }


    //actualizar BD
    public boolean ActualizarDatosNinio (Ninios ninios){
        OpenBD();
        ContentValues contenedor = new ContentValues();
        contenedor.put(Constantes.columna_1_ninios,ninios.getNinNombre());
        contenedor.put(Constantes.columna_2_ninios,ninios.getNinApellido());
        contenedor.put(Constantes.columna_3_ninios,ninios.getNinEdad());
        contenedor.put(Constantes.columna_4_ninios,ninios.getNinFoto());

        String campoParaActualizar = "ninId = ?";

        String[] argumentosParaActualizar = {String.valueOf(ninios.getNinId())};

        return (db.update(Constantes.nom_tabla_ninios,contenedor,campoParaActualizar,argumentosParaActualizar))>0;

    }

    public boolean ActualizarDatosDonante (Donante donante){
        OpenBD();
        ContentValues contenedor = new ContentValues();
        contenedor.put(Constantes.columna_1_donante,donante.getDonNombre());
        contenedor.put(Constantes.columna_2_donante,donante.getDonApellido());
        contenedor.put(Constantes.columna_3_donante,donante.getDonTelefono());
        contenedor.put(Constantes.columna_4_donante,donante.getDonEmail());
        contenedor.put(Constantes.columna_5_donante,donante.getDonContrasenia());
        contenedor.put(Constantes.columna_6_donante,donante.getDonTipo());

        String campoParaActualizar = "donId = ?";

        String [] argumentosPAraActualizar = {String.valueOf(donante.getDonId())};

        return (db.update(Constantes.nom_tabla_donante,contenedor,campoParaActualizar,argumentosPAraActualizar))>0;
    }


    //eliminar de bd

    public boolean EliminarDatosNinios(Ninios ninios){
        OpenBD();
        String[] argumentos = {String.valueOf(ninios.getNinId())};
        return (db.delete(Constantes.nom_tabla_ninios,"ninId = ?",argumentos))>0;
    }

    public boolean EliminarDatosDonante(Donante donante){
        OpenBD();
        String[] argumentos = {String.valueOf(donante.getDonId())};
        return (db.delete(Constantes.nom_tabla_donante,"donId = ?",argumentos))>0;
    }

    //Mostrar datos bd
    public ArrayList<Ninios> MostrarDatosNinios (){
        OpenLeerBD();
        String[] columasAConsultar = {Constantes.columna_1_ninios,Constantes.columna_2_ninios,
                                        Constantes.columna_3_ninios,Constantes.columna_4_ninios};
        Cursor cursor = db.query(
                Constantes.nom_tabla_ninios,columasAConsultar,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null){
            return listaNinios;
        }
        if (!cursor.moveToFirst()) return listaNinios;
        do {
            Ninios ninios = new  Ninios();
            ninios.setNinNombre(cursor.getString(1));
            ninios.setNinApellido(cursor.getString(2));
            ninios.setNinFoto(cursor.getBlob(3));
            ninios.setNinEdad(cursor.getString(4));

            listaNinios.add(ninios);
        }while (cursor.moveToNext());

        return listaNinios;
    }

    public ArrayList<Donante> MostrarDatosDonante (){
        OpenLeerBD();
        String[] columasAConsultar = {Constantes.columna_1_donante,Constantes.columna_2_donante,
                Constantes.columna_3_donante,Constantes.columna_4_donante, Constantes.columna_5_donante,
                Constantes.columna_6_donante,Constantes.columna_7_donante};
        Cursor cursor = db.query(
                Constantes.nom_tabla_donante,columasAConsultar,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null){
            return listaDonante;
        }
        if (!cursor.moveToFirst()) return listaDonante;
        do {
            Donante donante = new Donante();
            donante.setDonNombre(cursor.getString(1));
            donante.setDonApellido(cursor.getString(2));
            donante.setDonTelefono(cursor.getString(3));
            donante.setDonEmail(cursor.getString(4));
            donante.setDonContrasenia(cursor.getString(5));
            donante.setDonTipo(cursor.getString(6));
            donante.setDonFirma(cursor.getBlob(7));

            listaDonante.add(donante);
        }while (cursor.moveToNext());

        return listaDonante;
    }

}
