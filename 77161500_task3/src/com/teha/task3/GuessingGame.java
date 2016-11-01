package com.teha.task3;
import java.util.Random;

import cct.mad.lab.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import cct.mad.AssignmentTask12.R;

public class GuessingGame extends Activity {
	
	int randomCode;
	TextView tvOutGuess;
	EditText etInGuess;
	int tries =0;
  
  String valueReceived;
  
  public void onCreate(Bundle bundle) {
   super.onCreate(bundle);
    setContentView(R.layout.guessing_game);
    Bundle extras = getIntent().getExtras();
    if (extras != null) {
	    valueReceived = extras.getString("Value1");
	    if (valueReceived  != null) {
	      TextView dataRcvd = (TextView) findViewById(R.id.Player);
	      dataRcvd.setText("Player: " + valueReceived );
	      
	    etInGuess = (EditText)findViewById(R.id.etGuess);
		tvOutGuess = (TextView)findViewById(R.id.tvGuess);
	    }  
	 }
  }
  
   public void onClick(View view) {
	    Intent data = new Intent();
	    if(!etInGuess.getText().toString().isEmpty()){
	    // Return some hard-coded values
	    	if (this.tries <= 3) {
	    int guessed = Integer.parseInt(etInGuess.getText().toString());
		if (guessed < randomCode){
		data.putExtra("returnKey1", "Your last guess was "+ guessed + " and " + "it was too low");
		}
		else if (guessed > randomCode){
		data.putExtra("returnKey1", "Your last guess was "+ guessed + " and " + "it was too high");
		}
		else if (guessed == randomCode){
		data.putExtra("returnKey1", "Your last guess was "+ guessed + " and " + "you are correct!");
		}
	    	}
	    data.putExtra("returnKey1", "Wishing you the best of luck next time...");
	    data.putExtra("returnKey2", "Thanks for playing!");
		setResult(RESULT_OK, data);
	    super.finish();
    }
   }

   public void randomNumberGenerator(View button){
		tvOutGuess.setText("");
		Random randNum = new Random();
		randomCode = randNum.nextInt(21);	
	      Toast.makeText(this, " The Game is On", Toast.LENGTH_LONG).show();
	      Toast.makeText(this, " Try Guessing In 3 Attempts!", Toast.LENGTH_LONG).show();
	}

	public void displayResult(View button){
		if (this.tries < 3) {
			int guessed = Integer.parseInt(etInGuess.getText().toString());
			if(guessed > randomCode) {
				tvOutGuess.setTextColor(Color.RED);
				tvOutGuess.setText("Too Large!");
			}
			else if (guessed < randomCode) {
				tvOutGuess.setTextColor(Color.MAGENTA);
				tvOutGuess.setText("Too Small!");
			}
			else if (guessed == randomCode){
				tvOutGuess.setTextColor(Color.GREEN);
				tvOutGuess.setText("You Win!" + "\n" + "Game Over...");
			}
			this.tries++;
			
			}
				else {
					tvOutGuess.setText("You Have Failed To Guess In 3 Tries.. Game Over!");
			}
		}
} 
