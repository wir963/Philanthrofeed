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
		addItem(new Recipient("1", "Mark", "Federal Triangle, Washington, DC", "mark",
				"Balance: $5.00 \n\nMark just lost his job five months ago for reasons beyond his control. Also, because he recently hurt his back, he's having trouble finding work. In the meantime,"
				+ " he really appreciates any donations for food to keep his spirits high.", 5.00));
		
		addItem(new Recipient("2", "Kristen", "Washington, DC", "kristen",
				"Balance: $6.00 \n\nKristen just signed up for PhilanthroFeed and has already started eating much better.", 6.00));
		
		addItem(new Recipient("3", "Welles", "Georgetown, Washington, DC", "welles",
				"Balance: $75.50 \n\nHis favorite restaurant is Morton's, and he sleeps on Couches. ", 75.50));
		
		addItem(new Recipient("4", "Andrew", "Washington, DC", "andrew",
				"Balance: $2.50 \n\nAndrew's favorite restaurant is McDonalds. He is really grateful for the one meal a day he usually gets through philanthroFeed.", 2.50));
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
