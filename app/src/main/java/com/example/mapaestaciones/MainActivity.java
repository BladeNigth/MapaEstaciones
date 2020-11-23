package com.example.mapaestaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        nombre = findViewById(R.id.edtnombre);
        empresa = findViewById(R.id.edtempresa);
        departamento = findViewById(R.id.edtdepartamento);
        municipio = findViewById(R.id.edtmunicipio);
        latitud = findViewById(R.id.edtlatitud);
        longitud = findViewById(R.id.edtlongitud);
        agregar = findViewById(R.id.btnagregar);
        vmapa = findViewById(R.id.btnmapa);
        agregar.setOnClickListener(this);
        vmapa.setOnClickListener(this);
        gc = new GasolineraController(this);

    /*
        Cursor Vista = gc.allContadores();
        if( Vista != null){
            Vista.moveToFirst();
            Toast.makeText(this, Vista.getString(5), Toast.LENGTH_SHORT).show();
        }
        11.245528","-74.203068
*/



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnagregar:
                if(TextUtils.isEmpty(nombre.getText().toString()) || TextUtils.isEmpty(empresa.getText().toString()) ||
                        TextUtils.isEmpty(departamento.getText().toString()) || TextUtils.isEmpty(municipio.getText().toString())
                        || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString())) {
                    Toast.makeText(this, "no puede haber Datos Vacios en el Formulario", Toast.LENGTH_SHORT).show();
                }else{
                    g = new Gasolinera(nombre.getText().toString(),empresa.getText().toString(),departamento.getText().toString(),
                            municipio.getText().toString(),latitud.getText().toString(),longitud.getText().toString());
                    gc.agregarGasolinera(g);
                }
                break;
            case R.id.btnmapa:
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
        }
    }
}