package com.example.segundapregunta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {

	public AdminSQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bdcanchis) {
		// TODO Auto-generated method stub
		bdcanchis.execSQL("CREATE table registro(nombres integer primary key,apellidos text,edad int)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bdcanchis, int versionantigua, int versionnueva) {
		// TODO Auto-generated method stub
		bdcanchis.execSQL("selec * from registro");
		bdcanchis.execSQL("update set");
		bdcanchis.execSQL("drop table if exists registro");
		bdcanchis.execSQL("CREATE  table registro(nombres integer primary key, apellidos text,edad ints)");
	}

}
