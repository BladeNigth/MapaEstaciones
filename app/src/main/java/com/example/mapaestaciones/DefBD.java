package com.example.mapaestaciones;

public class DefBD {

    public static final String nameDb ="Gasolineras";
    public static final String tabla_estaciones = "estaciones";
    public static final String col_nombre = "nombre";
    public static final String col_empresa = "empresa";
    public static final String col_departamento = "departamento";
    public static final String col_municipio = "municipio";
    public static final String col_longitud = "longitud";
    public static final String col_latitud = "latitud";
    public static final String col_cod = "codigo";

    public static final String create_tabla_estaciones = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_estaciones + " ( " +
            DefBD.col_cod + " integer primary key autoincrement," +
            DefBD.col_nombre + " text," +
            DefBD.col_empresa + " text," +
            DefBD.col_departamento + " text," +
            DefBD.col_municipio + " text," +
            DefBD.col_latitud + " text," +
            DefBD.col_longitud + " text" +
            ");";
}
