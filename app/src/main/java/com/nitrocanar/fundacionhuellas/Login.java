package com.nitrocanar.fundacionhuellas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nitrocanar.fundacionhuellas.modelo.ConexionSQLiteHelper;
import com.nitrocanar.fundacionhuellas.modelo.Constantes;
import com.nitrocanar.fundacionhuellas.modelo.ManagerSQLiteHelper;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario, etContrasenia;
    private Cursor fila;
    ManagerSQLiteHelper manager;
    ConexionSQLiteHelper conexion;
    Button btnIngresar;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsuario = findViewById(R.id.etNombreIniciarSes);
        etContrasenia = findViewById(R.id.etContraseniaIniciarSesion);
        btnIngresar = findViewById(R.id.btnIniciarSesion);
        btnIngresar.setOnClickListener(this);
        btnRegistrar = findViewById(R.id.btnRegistrarse);
        btnRegistrar.setOnClickListener(this);
    }

    //metodo para ingreso
    public void Ingresar(View view){
        SQLiteDatabase db = conexion.getWritableDatabase();
        String usuario = etUsuario.getText().toString();
        String contrasenia = etContrasenia.getText().toString();
        fila = db.rawQuery("SELECT "+ Constantes.columna_4_donante+" , "+Constantes.columna_5_donante+" FROM "+
                Constantes.nom_tabla_donante+" WHERE "+Constantes.columna_4_donante+" = "+usuario+" AND "+
                Constantes.columna_5_donante+" = "+contrasenia,null);

        //preguntamos si el cursor tiene algun valor almacenado

        try {

            if (fila.moveToFirst()==true){
                //capturamos los valores del cursos y lo almacenamos en variable
                String usu = fila.getString(0);
                String con = fila.getString(1);

                //preguntamos si los datos ingresados son iguales

                if (usuario.equals(usu) && contrasenia.equals(con)){
                    //si son iguales entonces vamos a otra ventana
                    Intent intent = new Intent(Login.this,EspacioDespuesDeLogin.class);
                    startActivity(intent);
                    etUsuario.setText("");
                    etContrasenia.setText("");
                }
            }
        }catch (Exception e){
            Log.e("BD","No hay datos ingredsados");
        }

        if (fila==null || etUsuario.equals("") || etContrasenia.equals("")){
            Toast.makeText(this, "Por favor ingrese sus datos", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIniciarSesion:
                Ingresar(view);
                break;

            case R.id.btnRegistrarse:
                Intent intent =new Intent(Login.this,Registrar.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
