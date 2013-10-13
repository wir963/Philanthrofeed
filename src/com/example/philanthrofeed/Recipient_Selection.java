package com.example.philanthrofeed;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class Recipient_Selection extends Activity {

	ArrayList<Recipient> recipientList = new ArrayList<Recipient>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipient__selection);
		
		initList();
		
		menuAdapter adapter = new menuAdapter(getApplicationContext(), recipientList);
		ListView lView = (ListView) findViewById(R.id.recipient_list);
		lView.setAdapter(adapter);
	}
	
	public void initList() {
		recipientList.add(new Recipient("Keith", "imgAAA"));
		recipientList.add(new Recipient("Andrew", "imgBBB"));
		recipientList.add(new Recipient("Welles", "imgCCC"));
		recipientList.add(new Recipient("Whale Hat", "imgDDD"));
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
		private ArrayList<Recipient> listItems; //a localList that the adapter will gerated its views off of
		
		
		//basic constructor
		public menuAdapter(Context inputContext, ArrayList<Recipient> inputMenuItems)
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
			}
			else
			{
				outputView = (RelativeLayout)convertView; //otherwise recreate the previous view
			}
			
			outputView.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					TextView getNameView = (TextView) v.findViewById(R.id.recipientListItemName);
					String getName = getNameView.getText().toString();
					
					Toast nameToast = Toast.makeText(getApplicationContext(), getName, Toast.LENGTH_LONG);
					nameToast.show();
					
				}
				
				
			});
			
			return outputView; //return the new composite view
		}
	}//end class

}//end class