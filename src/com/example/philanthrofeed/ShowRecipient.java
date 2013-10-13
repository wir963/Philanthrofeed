package com.example.philanthrofeed;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRecipient extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String s = getIntent().getExtras().getString("key");
		setContentView(R.layout.activity_show_recipient);
		TextView nameView = (TextView)findViewById(R.id.recipientName);
		TextView locationView = (TextView)findViewById(R.id.recipientLocation);
		ImageView imageView = (ImageView)findViewById(R.id.recipientImage);

		RecipientList.Recipient mItem;

		if (RecipientList.ITEM_MAP.containsKey(s)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = RecipientList.ITEM_MAP.get(s);
			nameView.setText(mItem.name);
			locationView.setText(mItem.location);
			Context context = getApplicationContext();
			int imageId = context.getResources().getIdentifier(mItem.imgFileLoc, "drawable", context.getPackageName());
			imageView.setImageResource(imageId);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_recipient, menu);
		return true;
	}

}
