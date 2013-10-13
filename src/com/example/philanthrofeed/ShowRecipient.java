package com.example.philanthrofeed;

import java.math.BigDecimal;

import org.json.JSONException;

import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRecipient extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
		super.onCreate(savedInstanceState);
		
		
		Intent intent = new Intent(this, PayPalService.class);

	    // live: don't put any environment extra
	    // sandbox: use PaymentActivity.ENVIRONMENT_SANDBOX
	    intent.putExtra(PaymentActivity.EXTRA_PAYPAL_ENVIRONMENT, PaymentActivity.ENVIRONMENT_NO_NETWORK);
	    intent.putExtra(PaymentActivity.EXTRA_CLIENT_ID, "AVZ0jRB7XveAdyS4VEkpY1-s4xUoLr-yo8hZ2U8pbGgM5vPW5EnYHzVBhGa-");
	    startService(intent);
		
		
		
		String s = getIntent().getExtras().getString("key");
		setContentView(R.layout.activity_show_recipient);
		ImageView imageView = (ImageView)findViewById(R.id.recipientImage);
		TextView nameView = (TextView)findViewById(R.id.recipientName);
		TextView locationView = (TextView)findViewById(R.id.recipientLocation);
		TextView descView = (TextView)findViewById(R.id.recipientDescription);

		RecipientList.Recipient mItem;

		if (RecipientList.ITEM_MAP.containsKey(s)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = RecipientList.ITEM_MAP.get(s);
			nameView.setText(mItem.name);
			locationView.setText(mItem.location);
			descView.setText(mItem.description);
			Context context = getApplicationContext();
			int imageId = context.getResources().getIdentifier(mItem.imgFileLoc, "drawable", context.getPackageName());
			imageView.setImageResource(imageId);
			imageView.getLayoutParams().height = 350;
			imageView.getLayoutParams().width = 264;

		}
		
		Button donate_button = (Button) findViewById(R.id.donate_button);
		donate_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onBuyPressed(arg0);
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_recipient, menu);
		return true;
	}
	
	@Override
	public void onDestroy() {
	    stopService(new Intent(this, PayPalService.class));
	    super.onDestroy();
	}
	
	
	public void onBuyPressed(View pressed) {
	    PayPalPayment payment = new PayPalPayment(new BigDecimal("0.75"), "USD", "Donate Food to Charity");

	    Intent intent = new Intent(this, PaymentActivity.class);

	    // comment this line out for live or set to PaymentActivity.ENVIRONMENT_SANDBOX for sandbox
	    intent.putExtra(PaymentActivity.EXTRA_PAYPAL_ENVIRONMENT, PaymentActivity.ENVIRONMENT_NO_NETWORK);

	    // it's important to repeat the clientId here so that the SDK has it if Android restarts your
	    // app midway through the payment UI flow.
	    intent.putExtra(PaymentActivity.EXTRA_CLIENT_ID, "AVZ0jRB7XveAdyS4VEkpY1-s4xUoLr-yo8hZ2U8pbGgM5vPW5EnYHzVBhGa-");

	    // Provide a payerId that uniquely identifies a user within the scope of your system,
	    // such as an email address or user ID.
	    intent.putExtra(PaymentActivity.EXTRA_PAYER_ID, "anhiancheong-facilitator@gmail.com");

	    intent.putExtra(PaymentActivity.EXTRA_RECEIVER_EMAIL, "anhiancheong-facilitator@gmail.com");
	    intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

	    startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
	    if (resultCode == Activity.RESULT_OK) {
	        PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
	        if (confirm != null) {
	            try {
	                Log.i("paymentExample", confirm.toJSONObject().toString(4));

	                // TODO: send 'confirm' to your server for verification.
	                // see https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
	                // for more details.
	                
	                

	            } catch (JSONException e) {
	                Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
	            }
	        }
	    }
	    else if (resultCode == Activity.RESULT_CANCELED) {
	        Log.i("paymentExample", "The user cancelled.");
	    }
	    else if (resultCode == PaymentActivity.RESULT_PAYMENT_INVALID) {
	        Log.i("paymentExample", "An invalid payment was submitted. Please see the docs.");
	    }
	    
	    
		Intent intent = new Intent(getApplicationContext(), DonateThanks.class); //will launch the menuSelection application
		startActivity(intent);
		
	}
	
}
