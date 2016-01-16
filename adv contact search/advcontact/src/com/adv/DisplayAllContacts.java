package com.adv;

import java.util.ArrayList;
import java.util.Collections;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DisplayAllContacts extends Activity {
ListView lv;
ArrayList<String> al;
//database
MyDBHelper helper;
SQLiteDatabase db;
Cursor cr;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.displayall);
	lv=(ListView)findViewById(R.id.displayalllv);
	al=new ArrayList<String>();
	
	//database
	helper=new MyDBHelper(this);
	db=helper.getReadableDatabase();
	
	getall();
	lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {

			 String s1 = null,selected =(String) (lv.getItemAtPosition(arg2));
			 for(int i=0;i<selected.length();i++)
			 {
				 if(selected.charAt(i)=='\n')
				 {
					s1=selected.substring(0,i); 
				 }
			 }
			 Intent i=new Intent(getApplicationContext(),Display.class);
			 i.putExtra("name", s1);
			 startActivity(i);
			
		}
	});
} 


//getall()
public void getall()
{
	al.clear();
	try{
		cr=db.rawQuery("select * from emp",null);
		if(cr!=null)
		{
			if(cr.moveToFirst())
			{
				do {
					String name=cr.getString(cr.getColumnIndex("name"));
					String mobile=cr.getString(cr.getColumnIndex("mobile"));
					al.add(name+"\n"+mobile);
					
				} while (cr.moveToNext());
			}
		}
	}
	catch (Exception e) 
	{	
	}
	Collections.sort(al);
	ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
	lv.setAdapter(ad);
}
}
