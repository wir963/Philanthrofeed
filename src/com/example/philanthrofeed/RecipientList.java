package com.example.philanthrofeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class RecipientList {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Recipient> ITEMS = new ArrayList<Recipient>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Recipient> ITEM_MAP = new HashMap<String, Recipient>();

	static {
		// Add items.
		addItem(new Recipient("1", "Keith", "Washington, DC", "blank_male",
				"Balance: $5.00 \n\nKeith especially enjoys chicken burritos at Chipotle. He's lived in DC for the last two and a half years. He is usually around M Street in Georgetown and is well known for wearing his vineyard vine whale hat", 5.00));
		
		addItem(new Recipient("2", "Janet", "Washington, DC", "blank_female",
				"Balance: $6.00 \n\nJanet just signed up for PhilanthroFeed and has already started eating much better.", 6.00));
		
		addItem(new Recipient("3", "Welles", "Washington, DC", "blank_male",
				"Balance: $75.50 \n\nInformation about Welles. Information about Welles. Information about Welles. Information about Welles. Information about Welles. Information about Welles. ", 75.50));
		
		addItem(new Recipient("4", "Evan", "Washington, DC", "blank_male",
				"Balance: $2.50 \n\nEvan's favorite restaurant is McDonalds. He is really grateful for the one meal a day he usually gets through PhilanthroFeed.", 2.50));
	}

	private static void addItem(Recipient recipient) {
		ITEMS.add(recipient);
		ITEM_MAP.put(recipient.id, recipient);
	}

	public static class Recipient {

		public String id;
		public String name;
		public String location;
		public String description;
		public Double balance;
		public String imgFileLoc;

		public Recipient(String in_id, String in_name, String in_location, String in_imgFileLoc, String in_description, Double balance) {
			id = in_id;
			name = in_name;
			location = in_location;
			description = in_description;
			this.balance = balance;
			imgFileLoc = in_imgFileLoc;
		}

	}

}
