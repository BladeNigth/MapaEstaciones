package com.example.mapaestaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class GasolineraController {
    private BaseDatos bd;
    private Context c;

    public GasolineraController(Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }

    public void agregarGasolinera(Gasolinera gasolinera){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_nombre,gasolinera.getNombre());
            valores.put(DefBD.col_empresa,gasolinera.getEmpresa());
            valores.put(DefBD.col_departamento,gasolinera.getDepartamento());
            valores.put(DefBD.col_municipio,gasolinera.getMunicipio());
            valores.put(DefBD.col_latitud,gasolinera.getLatitud());
            valores.put(DefBD.col_longitud,gasolinera.getLongitud());
            long id =sql.insert(DefBD.tabla_estaciones,null,valores);
           // Toast.makeText(c, "Gasolinera Registrada", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor allContadores(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor d = sql.rawQuery("select nombre as _id, empresa, departamento, municipio, longitud,latitud from estaciones",null);
            return d;
        }catch (Exception ex){
            Toast.makeText(c, "Error en la consulta" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}
