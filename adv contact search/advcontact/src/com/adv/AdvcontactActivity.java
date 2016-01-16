package com.adv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AdvcontactActivity extends Activity {
	
	ImageButton add;
	Button next;
	AutoCompleteTextView atv;
	RadioButton rbname,rbskill;
	
	//database
	SQLiteDatabase db;
	MyDBHelper helper;
	Cursor cr;
	ArrayList<String> al=new ArrayList<String>(); //common al for all
	ArrayAdapter<String> adforatv;
	ListView lv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        next=(Button)findViewById(R.id.bb); 
        atv=(AutoCompleteTextView)findViewById(R.id.mainatv);
        rbname=(RadioButton)findViewById(R.id.rbname);
        rbskill=(RadioButton)findViewById(R.id.rbskill);
        
        lv=(ListView)findViewById(R.id.mainlistView);
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
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
        
        rbskill.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				atv.setText("");
				Search search=new Search();
				ArrayList<String> skillArray =search.skill(getApplicationContext());
				HashSet<String> skillSet = new HashSet<String>(skillArray);
				skillArray.clear();
				skillArray.addAll(skillSet);
				skillSet.clear();
				adforatv = new ArrayAdapter<String>(getBaseContext(),
						android.R.layout.simple_dropdown_item_1line, skillArray);
				atv.setText("");
				atv.setHint("Enter skill");
				atv.setThreshold(1);
				atv.setAdapter(adforatv);
				
			}
		});
        
        rbname.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<String> nameArray = new ArrayList<String>();
				/*adforatv = new ArrayAdapter<String>(getBaseContext(),
						android.R.layout.simple_dropdown_item_1line, nameArray);
				adforatv.clear();
				atv.setHint("Enter Name");
				atv.setThreshold(1);
				atv.setAdapter(adforatv);*/
				atv.setText("");
				/*Search search=new Search();
				ArrayList<String> skillArray =search.name(getApplicationContext());
				HashSet<String> skillSet = new HashSet<String>(skillArray);
				skillArray.clear();
				skillArray.addAll(skillSet);
				skillSet.clear();*/
				adforatv = new ArrayAdapter<String>(getBaseContext(),
						android.R.layout.simple_dropdown_item_1line,nameArray);
				atv.setHint("Enter name");
				atv.setThreshold(1);
				atv.setAdapter(adforatv);
				
			}
		});
       
       
        
        
        //database
        helper=new MyDBHelper(this);
        db=helper.getWritableDatabase();
        
        
        atv.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) 
			{
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) 
			{	
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			 if(s.length()==0)
			 {
				getall(); 
			 }
				else
				{
					searchEmpMethod();
				}
			 }//onTextChanged
			
			});
        
       
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("View All");
		menu.add("Delete all");
		menu.add("All Skills");
		menu.add("Clear");
		return true;
	}
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getTitle()=="View All")
    	{
    		Intent in=new Intent(this,DisplayAllContacts.class);
    		startActivity(in);
    	}
    	else if(item.getTitle()=="Delete all")
    	{
    		db=helper.getReadableDatabase();
    		try
    		{
    		db.execSQL("DELETE FROM emp");
    		Toast.makeText(getApplicationContext(),"deleted all contacts",Toast.LENGTH_SHORT).show();
    		getall();
    		}
    		catch (Exception e) {
			Toast.makeText(getApplicationContext(),"not deleted",Toast.LENGTH_SHORT).show();
			}
    		
    	}
    	else if(item.getTitle()=="All Skills")
    	{
    		
    		
    		
    		atv.setText("");
			Search search=new Search();
			ArrayList<String> skillArray =search.skill(getApplicationContext());
			HashSet<String> skillSet = new HashSet<String>(skillArray);
			skillArray.clear();
			skillArray.addAll(skillSet);
			skillSet.clear();
			Collections.sort(skillArray);
			adforatv = new ArrayAdapter<String>(getBaseContext(),
					android.R.layout.simple_list_item_1, skillArray);
			
			lv.setAdapter(adforatv);
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					rbskill.setChecked(true);
					atv.setText((String)lv.getItemAtPosition(arg2));
					setlv(); //for again setting the lv to original
				}

				private void setlv() {
					
					lv.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							// TODO Auto-generated method stub
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
					
				}//setlv()
			});	//onCilckListeren		
    		
    	}
    	
    	else if(item.getTitle()=="Clear")
    	{
    		atv.setText("");
    	}
    	return true;
	}
  
    
    
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getall();
	}

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
						//String id=cr.getString(cr.getColumnIndex("id"));
						String name=cr.getString(cr.getColumnIndex("name"));
						String mobile=cr.getString(cr.getColumnIndex("mobile"));
						//String altmobile=cr.getString(cr.getColumnIndex("altmobile"));
						//String email=cr.getString(cr.getColumnIndex("email"));
						//String dob=cr.getString(cr.getColumnIndex("bday"));
						//String skill1=cr.getString(cr.getColumnIndex("skill1"));
						//String skill2=cr.getString(cr.getColumnIndex("skill2"));
						//String skill3=cr.getString(cr.getColumnIndex("skill3"));
						//String add=cr.getString(cr.getColumnIndex("address"));
						/*al.add("Id :"+id+"\n"+
						       "name :"+name+"\n"+
						       "mobile :"+mobile+"\n"+
						       "altmobile :"+altmobile+"\n"+
						       "email :"+email+"\n"+
						       "dob :"+dob+"\n"+
						       "skill1 :"+skill1+"\n"+
						       "skill2 :"+skill2+"\n"+
						       "skill3 :"+skill3+"\n"+
						       "add :"+add+"\n");*/
						al.add(name+"\n"+mobile);
						
					} while (cr.moveToNext());
    			}
    		}
    	}
    	catch (Exception e) {
    		
		}
    	Collections.sort(al);
    	ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
		lv.setAdapter(ad);
		//Toast.makeText(getApplicationContext(), "got", Toast.LENGTH_SHORT).show();
    }//getall
	
	private void searchEmpMethod() {
		
		if(rbname.isChecked())
		{
			Search ser=new Search();
			al.clear();
			al=ser.searchforatv(getApplicationContext(),atv.getText().toString().trim(),null);
			ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
			lv.setAdapter(ad);
		}
		if(rbskill.isChecked())
		{
			Search ser=new Search();
			al.clear();
			al=ser.searchforatv(getApplicationContext(),null,atv.getText().toString().trim());
			ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
			lv.setAdapter(ad);
		}
		
	}

	
    public void add(View v)
    {
    	Intent i=new Intent(getApplicationContext(),save.class);
    	startActivity(i);
    	
    }

     
}