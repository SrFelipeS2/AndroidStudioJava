package com.example.basededatoscrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_Codigo, txt_Desc, txt_Precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_Codigo = findViewById(R.id.txt_Codigo);
        txt_Desc = findViewById(R.id.txt_Desc);
        txt_Precio = findViewById(R.id.txt_Precio);
    }

    // metodo para guardar

    public void Registrar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = txt_Codigo.getText().toString();
        String descripcion = txt_Desc.getText().toString();
        String precio = txt_Precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo );
            registro.put("descripcion", descripcion );
            registro.put("precio", precio );

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();
            txt_Codigo.setText("");
            txt_Precio.setText("");
            txt_Desc.setText("");
        }else{
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para buscar

    public void Buscar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = txt_Codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select descripcion,precio from articulos where codigo =" + codigo, null);

            if(fila.moveToFirst()){
                txt_Desc.setText(fila.getString(0));
                txt_Precio.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "Articulo inexistente", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this, "Debes ingresar el codigo del articulo", Toast.LENGTH_SHORT).show();
        }

    }

    // metodo para eliminar

    public void Eliminar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = txt_Codigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDeDatos.delete("articulos", "codigo=" + codigo, null);
            BaseDeDatos.close();

            txt_Codigo.setText("");
            txt_Precio.setText("");
            txt_Desc.setText("");

            if(cantidad>0){
                Toast.makeText(this, "Articulo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "el articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debes ingresar el codigo del articulo para poder eliminarlo", Toast.LENGTH_SHORT).show();
        }
    }

    // metodo para editar
    public void Editar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = txt_Codigo.getText().toString();
        String descripcion = txt_Desc.getText().toString();
        String precio = txt_Precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDeDatos.update("articulos", registro, "codigo=" + codigo, null);
            BaseDeDatos.close();

            if(cantidad>0){
                txt_Codigo.setText("");
                txt_Precio.setText("");
                txt_Desc.setText("");

                Toast.makeText(this, "Articulo modificado  exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "el articulo no existe", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}