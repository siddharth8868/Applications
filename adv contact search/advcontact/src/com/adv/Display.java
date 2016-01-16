package com.adv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends Activity{

	TextView tname,tmobile,taltmobile,tmale,tskill1,tskill2,tskill3,tadd;
	EditText ename,emobile,ealtmobile,emale,edob,eskill1,eskill2,eskill3,eadd;
	String sname,smobile,saltmobile,smale,sdob,sskill1,sskill2,sskill3,sadd;
	String expname; //for exported name
	ImageButton  add1,add2;
	Button cancel,save;
	 TableRow tr;
	
	//database
	MyDBHelper helper;
	SQLiteDatabase db;
	SQLiteStatement st;
	Cursor cr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save);
		 Intent i=getIntent();
		expname=i.getStringExtra("name");
		ename=(EditText)findViewById(R.id.saveNameet);
		emobile=(EditText)findViewById(R.id.savemobileet);
		ealtmobile=(EditText)findViewById(R.id.savealtmobileet);
		emale=(EditText)findViewById(R.id.saveEmailet);
		edob=(EditText)findViewById(R.id.savedateofbirthet);
		eskill1=(EditText)findViewById(R.id.saveskillet);
		eskill2=(EditText)findViewById(R.id.saveskill2et);
		eskill3=(EditText)findViewById(R.id.saveskill3et);
		eadd=(EditText)findViewById(R.id.saveaddresset);
		add1=(ImageButton)findViewById(R.id.addskillbutton1);
		add2=(ImageButton)findViewById(R.id.addskillbutton2);
		save=(Button)findViewById(R.id.savesavebutton);
		cancel=(Button)findViewById(R.id.savecancelbutton);
		tr=(TableRow)findViewById(R.id.tableRowforlast);
		//database
		helper=new MyDBHelper(this);
		db = helper.getWritableDatabase();
		
		//disabling function
		disable();
		calibarate();
	}
	
	//onCreate ends here
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add("Edit").setIcon(R.drawable.editfoto);
		//message
		SubMenu sm=menu.addSubMenu("send message").setIcon(R.drawable.send_sms);
		sm.setHeaderIcon(R.drawable.send_sms);
		sm.setHeaderTitle("select phone number");
		if((emobile.getText().toString()).equals(""))
		{	
		}
		else {
			sm.add(emobile.getText().toString()+" ");
		}
		if((ealtmobile.getText().toString()).equals(""))
		{	
		}
		else {
			sm.add(ealtmobile.getText().toString()+" ");
		}
		
		//call
		SubMenu sc=menu.addSubMenu("call").setIcon(R.drawable.googlevoice);
		sc.setHeaderIcon(R.drawable.call);
		sc.setHeaderTitle("select phone number");
		if((emobile.getText().toString()).equals(""))
		{	
		}
		else {
			sc.add(emobile.getText().toString());
		}
		if((ealtmobile.getText().toString()).equals(""))
		{	
		}
		else {
			sc.add(ealtmobile.getText().toString());
		}
		menu.add("delete").setIcon(R.drawable.bin);
		return true;
	}
 @Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	 if(item.getTitle()=="Edit")
	 {
		enable();
	 }
	 else if (item.getTitle().equals("send message")) {
			if (emobile.getText().toString().equals("") && ealtmobile.getText().toString().equals("")) 
			{
				Toast.makeText(this, "sorry thre is no numbers to send message",Toast.LENGTH_LONG).show();
			}
	}
	 else if (item.getTitle().equals("call")) {
			if (emobile.getText().toString().equals("") && ealtmobile.getText().toString().equals("")) 
			{
				Toast.makeText(this, "sorry thre is no numbers to make call",Toast.LENGTH_LONG).show();
			}
	}
	 
	 //message number select
	 else if (item.getTitle().equals(emobile.getText().toString()+" ")) {
		 Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+emobile.getText().toString()));
		 startActivity(intent);
	} 
	 else if (item.getTitle().equals(ealtmobile.getText().toString()+" ")) {
		 Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+ealtmobile.getText().toString()));
		 startActivity(intent);
	}
	 
	 
	 
	 //call number select
	 else if (item.getTitle().equals(emobile.getText().toString())) {
		 Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+emobile.getText().toString()));
		 startActivity(intent);
	} 
	 else if (item.getTitle().equals(ealtmobile.getText().toString())) {
		 Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+emobile.getText().toString()));
		 startActivity(intent);
	}
	 
	 //delete option selected
	 else if (item.getTitle()=="delete") {
		 AlertDialog.Builder alt=new AlertDialog.Builder(this);
		 alt.setTitle("do you want to delete it?");
		 alt.setPositiveButton("Yes",
					new android.content.DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							delete();
						}
					});
			alt.setNegativeButton("No",
					new android.content.DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
			alt.show();
			
	}
	return true;//option menu
}
  public void delete()
  {
	  try
	  {
	    db.delete("emp","name=?",new String[]{ename.getText().toString()});
	    Toast.makeText(getApplicationContext(),"deleted", Toast.LENGTH_SHORT).show();
	    Intent in=new Intent(this,AdvcontactActivity.class);
	    startActivity(in);
	  }
	  catch (Exception e) 
	  {
	    Toast.makeText(getApplicationContext(),"not deleted", Toast.LENGTH_SHORT).show();
	  }
  }
	
	private void disable() {
		// TODO Auto-generated method stub
		ename.setEnabled(false);
		emobile.setEnabled(false);
		ealtmobile.setEnabled(false);
		emale.setEnabled(false);
		edob.setEnabled(false);
		eskill1.setEnabled(false);
		eskill2.setEnabled(false);
		eskill3.setEnabled(false);
		eadd.setEnabled(false);
		tr.setVisibility(View.GONE);
		//save.setVisibility(View.GONE);
		//cancel.setVisibility(View.GONE);
		add1.setVisibility(View.INVISIBLE);
		add2.setVisibility(View.INVISIBLE);

		
		//color
		ename.setTextColor(Color.WHITE);
		emobile.setTextColor(Color.WHITE);
		ealtmobile.setTextColor(Color.WHITE);
		emale.setTextColor(Color.WHITE);
		edob.setTextColor(Color.WHITE);
		eskill1.setTextColor(Color.WHITE);
		eskill2.setTextColor(Color.WHITE);
		eskill3.setTextColor(Color.WHITE);
		eadd.setTextColor(Color.WHITE);			
	}

	private void enable() {
		// TODO Auto-generated method stub
		ename.setEnabled(true);
		emobile.setEnabled(true);
		ealtmobile.setEnabled(true);
		emale.setEnabled(true);
		edob.setEnabled(true);
		eskill1.setEnabled(true);
		eskill2.setEnabled(true);
		eskill3.setEnabled(true);
		eadd.setEnabled(true);
		add1.setClickable(true);
		tr.setVisibility(View.VISIBLE);
		//save.setVisibility(View.VISIBLE);
		//cancel.setVisibility(View.VISIBLE);
		add1.setVisibility(View.INVISIBLE);
		add2.setVisibility(View.INVISIBLE);

		
		//color
		ename.setTextColor(Color.BLACK);
		emobile.setTextColor(Color.BLACK);
		ealtmobile.setTextColor(Color.BLACK);
		emale.setTextColor(Color.BLACK);
		edob.setTextColor(Color.BLACK);
		eskill1.setTextColor(Color.BLACK);
		eskill2.setTextColor(Color.BLACK);
		eskill3.setTextColor(Color.BLACK);
		eadd.setTextColor(Color.BLACK);			
	}
	
	private void calibarate() {
		
    	try{
    		cr=db.rawQuery("select * from emp where name=?",new String[] {expname});
    		if(cr!=null)
    		{
    			if(cr.moveToFirst())
    			{
    				do {
						String name=cr.getString(cr.getColumnIndex("name"));
						String mobile=cr.getString(cr.getColumnIndex("mobile"));
						String altmobile=cr.getString(cr.getColumnIndex("altmobile"));
						String email=cr.getString(cr.getColumnIndex("email"));
						String dob=cr.getString(cr.getColumnIndex("bday"));
						String skill1=cr.getString(cr.getColumnIndex("skill1"));
						String skill2=cr.getString(cr.getColumnIndex("skill2"));
						String skill3=cr.getString(cr.getColumnIndex("skill3"));
						String add=cr.getString(cr.getColumnIndex("address"));
								
						ename.setText(name);
						emobile.setText(mobile);
						ealtmobile.setText(altmobile);
						emale.setText(email);
						edob.setText(dob);
						eskill1.setText(skill1);
						eskill2.setText(skill2);
						eskill3.setText(skill3);
						eadd.setText(add);
					} while (cr.moveToNext());
    			}
    		}
    	}
    	catch (Exception e) {
    		Toast.makeText(getApplicationContext(),"exception", Toast.LENGTH_LONG).show();
		}
		
		
	}
	public void save1(View v)
	{
	
		sname=ename.getText().toString();
		smobile=emobile.getText().toString();
		saltmobile=ealtmobile.getText().toString();
		//int kk=Integer.parseInt(smobile);
		//int kk1=Integer.parseInt(saltmobile);
		smale=emale.getText().toString();
		sdob=edob.getText().toString();
		sskill1=eskill1.getText().toString();
		sskill2=eskill2.getText().toString();
		sskill3=eskill3.getText().toString();
		sadd=eadd.getText().toString();
		db=helper.getWritableDatabase();
		if(sname.equals("")==false)
		{
		  try{	
			//cr=db.rawQuery("update emp set mobile=? where name=?",new String[]{smobile,sname});
			
			 ContentValues cv = new ContentValues();
			 cv.put("name", sname);
		     cv.put("mobile",smobile);   
			 cv.put("altmobile",saltmobile);
			 cv.put("email",smale );
			 cv.put("bday", sdob);
			 cv.put("skill1", sskill1);
			 cv.put("skill2", sskill2);
			 cv.put("skill3", sskill3);
			 cv.put("address",sadd ); 
			 db.update("emp", cv,"name=?", new String []{expname});
			 Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_SHORT).show();
			 disable();
		  	}
		  catch (Exception e) {
		  	 Toast.makeText(getApplicationContext(),"contact already exist",Toast.LENGTH_SHORT).show();
		  	}
		}
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
