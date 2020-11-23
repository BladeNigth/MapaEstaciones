package com.example.mapaestaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Gasolinera g;
    GasolineraController gc;
    EditText nombre,empresa,departamento,municipio,latitud,longitud;
    Button agregar,vmapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        gc = new GasolineraController(this);
        g = new Gasolinera("aguas","texaco","magdalena","santa Marta","11.245528","-74.203068");
        gc.agregarGasolinera(g);
        g = new Gasolinera("aguas","texaco","magdalena","santa Marta","11.245528","-74.203068");
        gc.agregarGasolinera(g);
    /*
        Cursor Vista = gc.allContadores();
        if( Vista != null){
            Vista.moveToFirst();
            Toast.makeText(this, Vista.getString(5), Toast.LENGTH_SHORT).show();
        }
*/

        Intent i = new Intent(this,MapsActivity.class);
        //startActivity(i);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}