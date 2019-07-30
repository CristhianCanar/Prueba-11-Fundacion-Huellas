package com.nitrocanar.fundacionhuellas.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.crearTablaNinios);
        db.execSQL(Constantes.crearTablaDonante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
