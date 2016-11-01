package com.teha.task3;

import cct.mad.lab.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;



public class GameCentral extends Activity {
	  private static final int REQUEST_CODE = 10;

	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.game_central);
	  
	  }

	  public void onClick(View view) {
	    Intent i = new Intent(this, GuessingGame.class);
	    
	    EditText playerName = (EditText) findViewById(R.id.plyrname);
	    i.putExtra("Value1", playerName.getText().toString());
	    
	    startActivityForResult(i, REQUEST_CODE);  
	  }

	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
	      if (data.hasExtra("returnKey1")) {
	    	String msg = data.getExtras().getString("returnKey1");
	    	msg = msg + "\n"+ data.getExtras().getString("returnKey2") ; 
	    	Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	     }
	    }
	  }
	  
	  public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater(); 
	        inflater.inflate(R.menu.walk_options_menu,menu); 
	        return true;
	    }
	  
	  
	    public boolean onOptionsItemSelected(MenuItem item) {
	        
	    	  switch (item.getItemId()) {
	          case R.id.share:
	          	Toast.makeText(this, "Share To External", Toast.LENGTH_SHORT).show();
	              return true;
	          case R.id.play:
	        	  Intent i = new Intent(this, GuessingGame.class);
	      	    
	      	    EditText playerName = (EditText) findViewById(R.id.plyrname);
	      	    i.putExtra("Value1", playerName.getText().toString());
	      	    
	      	    startActivityForResult(i, REQUEST_CODE);  
	              return true;
	          case R.id.close:
	          	Toast.makeText(this, "Close Game", Toast.LENGTH_SHORT).show();
	              return true;
	          case R.id.highest_score:
	          	Toast.makeText(this, "View Highest Score", Toast.LENGTH_SHORT).show();
	              return true; 
	          case R.id.twitter:
	          	Toast.makeText(this, "Visit Twitter", Toast.LENGTH_SHORT).show();
	              return true;    
	          case R.id.facebook:
	            	Toast.makeText(this, "Visit Facebook", Toast.LENGTH_SHORT).show();
	                return true;  
	          default    
	          :
	              return super.onOptionsItemSelected(item);
	        }
	    }
		
	  
	    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	        super.onCreateContextMenu(menu, v, menuInfo);
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.walk_context_menu, menu); 
	      }
	    
	    //Respond to item selected on the CONTEXT menu
	    public boolean onContextItemSelected(MenuItem item) {
	    	  AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    	  String itemTitle = (String) item.getTitle();
	    	  switch (item.getItemId()) {  	  
	    	  case R.id.register:
	    		  Toast.makeText(this, itemTitle, Toast.LENGTH_SHORT).show();
	             return true;
	    	  case R.id.view:
	      		Toast.makeText(this,  itemTitle, Toast.LENGTH_SHORT).show();
	      	    return true;
	    	  default:
	    	    return super.onContextItemSelected(item);
	    	  }
	    	}

} 