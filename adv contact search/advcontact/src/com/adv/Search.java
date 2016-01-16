package com.adv;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Search extends Activity{
	SQLiteDatabase db;
	MyDBHelper helper;
	Cursor cr;
	ArrayList<String> al=new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		helper=new MyDBHelper(this);
		db = helper.getWritableDatabase();
	}

	public ArrayList<String> name(Context application)
	{
		helper=new MyDBHelper(application);
		db = helper.getWritableDatabase();
		try{
			cr=db.rawQuery("select * from emp", null);
			if(cr!=null)
			{
				if(cr.moveToFirst())
				{
					do {
						String name=cr.getString(cr.getColumnIndex("name"));
						al.add(name);
					} while (cr.moveToNext());
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return al;	
	}//name
	
	public ArrayList<String> skill(Context application)
	{
		helper=new MyDBHelper(application);
		db = helper.getWritableDatabase();
		try{
			cr=db.rawQuery("select * from emp", null);
			if(cr!=null)
			{
				if(cr.moveToFirst())
				{
					do {
						String skill1=cr.getString(cr.getColumnIndex("skill1"));
						String skill2=cr.getString(cr.getColumnIndex("skill2"));
						String skill3=cr.getString(cr.getColumnIndex("skill3"));
						if(skill1.equals("")==false)
						{
						al.add(skill1);
						}
						if(skill2.equals("")==false)
						{
						al.add(skill2);
						}
						if(skill3.equals("")==false)
						{
						al.add(skill3);
						}
					} while (cr.moveToNext());
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return al;	
	}//skill

	public ArrayList<String> searchforatv(Context applicationContext,
			String name, String skill) {
		ArrayList<String> al=new ArrayList<String>();
		helper=new MyDBHelper(applicationContext);
		db=helper.getWritableDatabase();
		
		if(name!=null)
		{
		try {
			cr=db.rawQuery("select * from emp where name LIKE ?",new String[] {name + "%" });
			if(cr!=null)
			{
				if(cr.moveToFirst())
				{
					do {
						String name1=cr.getString(cr.getColumnIndex("name"));
						String mobile=cr.getString(cr.getColumnIndex("mobile"));
						al.add(name1+"\n"+mobile);
					} while (cr.moveToNext());
				}
			}
		} catch (Exception e) {
			
		}
		}//if
		else {
			try {
				cr=db.rawQuery("select * from emp where skill1 LIKE ? or skill2 LIKE ? or skill3 LIKE ?",new String[] {skill,skill,skill});
				if(cr!=null)
				{
					if(cr.moveToFirst())
					{
						do {
							String name1=cr.getString(cr.getColumnIndex("name"));
							String mobile=cr.getString(cr.getColumnIndex("mobile"));
							al.add(name1+"\n"+mobile);
						} while (cr.moveToNext());
					}
				}
			} catch (Exception e) {
	
			}
		}//else
		db.close();
		helper.close();
		return al;
	}//searchforatv
	
}
