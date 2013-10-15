package com.example.philanthrofeed;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DonateThanks extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);

				//Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate_thanks);
		
		Button button = (Button) findViewById(R.id.menu_selection_button);
		
		button.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				
    			Intent moveToMenuSelection = new Intent(getApplicationContext(), Recipient_Selection.class); //will launch the menuSelection application
    			startActivity(moveToMenuSelection);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate_thanks, menu);
		return true;
	}

}
