package com.example.edward.carteraclientes;

import android.content.Intent;
import android.os.Bundle;

import com.example.edward.carteraclientes.BaseDatos.DatosOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends AppCompatActivity implements View.OnClickListener {
    Button btnBuscar, btnEliminar;
    EditText Bnombre;
    TextView Busnombre, Busdireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bnombre=(EditText)findViewById(R.id.Bnombre);
        Busnombre=(TextView)findViewById(R.id.Busnombre);
        Busdireccion=(TextView)findViewById(R.id.Busdireccion);
        btnBuscar=(Button)findViewById(R.id.btnBuscar2);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnBuscar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnBuscar.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View v){
                DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
                String  buscar = Bnombre.getText().toString();
                String[] datos;
                datos=db.buscar_reg(buscar);
                Busnombre.setText(datos[0]);
                Busdireccion.setText(datos[1]);
                Toast.makeText(getApplicationContext(),datos[2],Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(new  View.OnClickListener(){
            public void onClick(View v){
                DatosOpenHelper db = new DatosOpenHelper(getApplicationContext(),null,null,1);
               String Nombre = Busnombre.getText().toString();
               String mensaje = db.eliminar(Nombre);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}