package com.example.segundapregunta;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText campo1;
	private EditText campo2;
	private EditText campo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        campo1=(EditText)findViewById(R.id.editText1);
        campo2=(EditText)findViewById(R.id.editText2);
        campo3=(EditText)findViewById(R.id.editText3);
    }
public void guardar (View View){
	//llamando al administrador
	AdminSQLite adminsql=new AdminSQLite(this,"administrador",null,1);
	//llamando a la base de datos
	SQLiteDatabase bdcanchis=adminsql.getWritableDatabase();
	//lllamando los datos a ingresar
	String campo1_temporal1=campo1.getText().toString();
	String campo2_temporal2=campo2.getText().toString();
	String campo3_temporal3=campo3.getText().toString();
	ContentValues formulario= new ContentValues();
	formulario.put("nombres", campo1_temporal1);
	formulario.put("apellidos", campo2_temporal2);
	formulario.put("edad", campo3_temporal3);
	
	try {
		bdcanchis.insert("registro", null, formulario);
		Toast.makeText(this, "dato guardado", Toast.LENGTH_LONG).show();
		campo1.setText(" ");
		campo2.setText(" ");
		campo3.setText(" ");
	} catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(this, "error"+e.getMessage(), Toast.LENGTH_LONG).show();
	}
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
