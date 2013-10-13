package com.example.philanthrofeed;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.philanthrofeed.RecipientList.Recipient;


public class Recipient_Selection extends Activity {

	RecipientList dummyRecipients = new RecipientList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipient__selection);

		menuAdapter adapter = new menuAdapter(getApplicationContext(), dummyRecipients.ITEMS);
		ListView lView = (ListView) findViewById(R.id.recipient_list);
		lView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipient__selection, menu);
		return true;
	}

	public class menuAdapter extends BaseAdapter
	{
		private Context currentContext; //necessarily member variable
		private List<Recipient> listItems; //a localList that the adapter will gerated its views off of


		//basic constructor
		public menuAdapter(Context inputContext, List<Recipient> inputMenuItems)
		{
			currentContext = inputContext;
			listItems = inputMenuItems;
		}

		//required basic accessor method
		public int getCount()
		{
			return listItems.size();
		}

		//required basic accessor method
		public Object getItem(int index)
		{
			return listItems.get(index);
		}


		public long getItemId(int index)
		{
			return 0;
		}




		//This is the real McCoy
		//This will return the view I want to be the standard item in the gridView
		public View getView(int index, View convertView, ViewGroup Parent)
		{
			//LayoutInflater used to create the composite layout (based on tutorial cited above)
			LayoutInflater inflater = (LayoutInflater) currentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View outputView; //the view I will return
			if(convertView == null) //A view can exist previously
			{
				outputView = new View(currentContext); //initialize object
				//this is where I call a templated view
				outputView = inflater.inflate(R.layout.recipient_list_item, null); //set the bsic layout of the view to the view I defined in menuViewItem.xml

				//set the imageView to the image as specified in the ArrayList menuList
				ImageView menuItemLogo = (ImageView)outputView.findViewById(R.id.recipientListItemImage);
				int resourceImageId = getResources().getIdentifier(listItems.get(index).imgFileLoc, "drawable", getPackageName()); //get the int of the identifier of the image

				if(resourceImageId != 0) //basic handling for if the image is not found
				{
					menuItemLogo.setImageResource(resourceImageId);
				}
				else
				{
					menuItemLogo.setImageResource(R.drawable.ic_launcher); //default image
				}

				//set up the textView for the dish name
				TextView nameView = (TextView) outputView.findViewById(R.id.recipientListItemName);
				nameView.setText(listItems.get(index).name);
				nameView.setTextColor(Color.BLACK);
				
				TextView idView = (TextView) outputView.findViewById(R.id.recipientListItemID);
				idView.setText(listItems.get(index).id);				
			}
			else
			{
				outputView = (RelativeLayout)convertView; //otherwise recreate the previous view
			}

			outputView.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					TextView getIDView = (TextView) v.findViewById(R.id.recipientListItemID);
					String getID = getIDView.getText().toString();

					Intent detailIntent = new Intent(getApplicationContext(), ShowRecipient.class);
					detailIntent.putExtra("key", getID);
					startActivity(detailIntent);

					Toast nameToast = Toast.makeText(getApplicationContext(), getID, Toast.LENGTH_LONG);
					nameToast.show();

				}


			});

			return outputView; //return the new composite view
		}
	}//end class

}//end class