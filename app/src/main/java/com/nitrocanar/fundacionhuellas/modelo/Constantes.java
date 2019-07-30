package com.nitrocanar.fundacionhuellas.modelo;

public class Constantes {
    public static String NOMBRE_BD = "bdHuellas";
    public static int VERSION = 1;

    public static final String nom_tabla_ninios = "ninios";
    public static final String columna_0_ninios = "ninId";
    public static final String columna_1_ninios = "ninNombre";
    public static final String columna_2_ninios = "ninApellido";
    public static final String columna_3_ninios = "ninTelefono";
    public static final String columna_4_ninios = "ninEdad";
    public static final String columna_5_ninios = "ninEmail";

    public static final String crarTablaNinios = ("CREATE TABLE IF NOT EXISTS "+ nom_tabla_ninios + " ( "+
            columna_0_ninios+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+columna_1_ninios+" TEXT, "+columna_2_ninios+" TEXT,"
            +columna_3_ninios+" TEXT, "+columna_4_ninios+" INTEGER, "+columna_5_ninios+" TEXT)");

}
