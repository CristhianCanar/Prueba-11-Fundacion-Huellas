package com.nitrocanar.fundacionhuellas.modelo;

public class Constantes {
    public static String NOMBRE_BD = "bdHuellas";
    public static int VERSION = 1;

    public static final String nom_tabla_ninios = "ninios";
    public static final String columna_0_ninios = "ninId";
    public static final String columna_1_ninios = "ninNombre";
    public static final String columna_2_ninios = "ninApellido";
    public static final String columna_3_ninios = "ninFoto";
    public static final String columna_4_ninios = "ninEdad";

    public static final String crearTablaNinios = ("CREATE TABLE IF NOT EXISTS "+ nom_tabla_ninios + " ( "+
            columna_0_ninios+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+columna_1_ninios+" TEXT, "+columna_2_ninios+" TEXT,"
            +columna_3_ninios+" BLOB, "+columna_4_ninios+" INTEGER )");

    public static final String nom_tabla_donante = "donante";
    public static final String columna_0_donante = "donId";
    public static final String columna_1_donante = "donNombre";
    public static final String columna_2_donante = "donApellido";
    public static final String columna_3_donante = "donTelefono";
    public static final String columna_4_donante = "donEmail";
    public static final String columna_5_donante = "donContrasenia";
    public static final String columna_6_donante = "donTipo";
    public static final String columna_7_donante = "donFirma";

    public static final String crearTablaDonante = ("CREATE TABLE IF NOT EXISTS "+ nom_tabla_donante + " ( "+
            columna_0_donante+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+columna_1_donante+" TEXT, "+columna_2_donante+" TEXT,"
            +columna_3_donante+" TEXT, "+columna_4_donante+" TEXT, "+columna_5_donante+" TEXT,"+columna_6_donante+ " TEXT,"+columna_7_donante+" BLOB)");


}
