package com.example.memoriainterna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button guardarArchivo;
    Button leerArchivo;
    TextView textoContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        guardarArchivo = findViewById( R.id.button );
        leerArchivo = findViewById( R.id.button2 );
        textoContenido = findViewById( R.id.textView );
        guardarArchivo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    OutputStreamWriter fout=
                            new OutputStreamWriter(
                                    openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

                    fout.write("Texto de prueba.");
                    fout.close();
                }
                catch (Exception ex)
                {
                    Log.e("Ficheros", "Error al escribir fichero a memoria interna");
                }
            }
        } );
        leerArchivo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("prueba_int.txt")));

                    String texto = fin.readLine();
                    textoContenido.setText( texto );
                    fin.close();
                }
                catch (Exception ex)
                {
                    Log.e("Ficheros", "Error al leer fichero desde memoria interna");
                }
            }
        } );
    }
}