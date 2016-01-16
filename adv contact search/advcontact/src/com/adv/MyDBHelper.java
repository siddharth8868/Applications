 package com.adv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

	public MyDBHelper(Context context) {
		super(context, "advdatabase",null , 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table "
				+"emp"
				+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
						"name text unique," +
						"mobile text," +
						"altmobile text," +
						"email text," +
						"bday text," +
						"skill1 text," +
						"skill2 text," +
						"skill3 text," +
						"address text)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS emp");
		onCreate(db);
		
	}

}
