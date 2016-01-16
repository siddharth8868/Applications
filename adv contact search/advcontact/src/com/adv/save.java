package com.adv;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class save extends Activity {
	TextView tname,tmobile,taltmobile,tmale,tskill1,tskill2,tskill3,tadd;
	EditText ename,emobile,ealtmobile,emale,edob,eskill1,eskill2,eskill3,eadd;
	String sname,smobile,saltmobile,smale,sdob,sskill1,sskill2,sskill3,sadd;
	ImageButton  add1,add2,save,cancel;
	
	//database
	MyDBHelper helper;
	SQLiteDatabase db;
	SQLiteStatement st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save);
		ename=(EditText)findViewById(R.id.saveNameet);
		emobile=(EditText)findViewById(R.id.savemobileet);
		ealtmobile=(EditText)findViewById(R.id.savealtmobileet);
		emale=(EditText)findViewById(R.id.saveEmailet);
		edob=(EditText)findViewById(R.id.savedateofbirthet);
		eskill1=(EditText)findViewById(R.id.saveskillet);
		eskill2=(EditText)findViewById(R.id.saveskill2et);
		eskill3=(EditText)findViewById(R.id.saveskill3et);
		eadd=(EditText)findViewById(R.id.saveaddresset);
		
		//database
		helper=new MyDBHelper(this);
		db = helper.getWritableDatabase();
	}
	public void save1(View v)
	{
	
		sname=ename.getText().toString();
		smobile=emobile.getText().toString();
		saltmobile=ealtmobile.getText().toString();
		smale=emale.getText().toString();
		sdob=edob.getText().toString();
		sskill1=eskill1.getText().toString();
		sskill2=eskill2.getText().toString();
		sskill3=eskill3.getText().toString();
		sadd=eadd.getText().toString();
		
		if(sname.endsWith(""))
		{
		  try{	
			st=db.compileStatement("insert into emp values(?,?,?,?,?,?,?,?,?,?)");
			st.bindString(2,sname);
			st.bindString(3,smobile);
			st.bindString(4,saltmobile);
			st.bindString(5,smale);
			st.bindString(6,sdob);
			st.bindString(7,sskill1);
			st.bindString(8,sskill2);
			st.bindString(9,sskill3);
			st.bindString(10,sadd);
			st.executeInsert();
			Toast.makeText(getApplicationContext(),"saved successfully",Toast.LENGTH_SHORT).show();
			Intent i=new Intent(this,AdvcontactActivity.class);
			startActivity(i);
			this.finish();
		  }
		  catch (Exception e) {
			//String s=e.getMessage();
			Toast.makeText(getApplicationContext(),"contact alread exits",Toast.LENGTH_SHORT).show();	
		  }
		}//if
		else
		{
			Toast.makeText(getApplicationContext(),"please enter name",Toast.LENGTH_SHORT).show();
		}
	}
	public void cancel(View v)
	{
		ename.setText("");
		emobile.setText("");
		ealtmobile.setText("");
		emale.setText("");
		edob.setText("");
		eskill1.setText("");
		eskill2.setText("");
		eskill3.setText("");
		eadd.setText("");
	}

}
