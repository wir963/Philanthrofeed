package com.example.philanthrofeed;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button loginButton = (Button) findViewById(R.id.login_button);
		
		loginButton.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
		        Intent loginIntent = new Intent();
				
				EditText username_text = (EditText) findViewById(R.id.user_edit_text);
				EditText password_text = (EditText) findViewById(R.id.password_edit_text);
				
				String username = username_text.getText().toString();
				String password = password_text.getText().toString();
				
				//Toast newToast = Toast.makeText(getApplicationContext(), username + password, Toast.LENGTH_LONG);
				//newToast.show();
    			Intent moveToMenuSelection = new Intent(getApplicationContext(), Recipient_Selection.class); //will launch the menuSelection application
    			startActivity(moveToMenuSelection);
			}});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
