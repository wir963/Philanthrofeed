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
				"Keith especially enjoys Chipotle. Information about Keith. Information about Keith. Information about Keith. Information about Keith. Information about Keith."));
		
		addItem(new Recipient("2", "Janet", "Washington, DC", "blank_female",
				"Information about Andrew. Information about Andrew. Information about Andrew. Information about Andrew. Information about Andrew. Information about Andrew."));
		
		addItem(new Recipient("3", "Welles", "Washington, DC", "blank_male",
				"Information about Welles. Information about Welles. Information about Welles. Information about Welles. Information about Welles. Information about Welles. "));
		
		addItem(new Recipient("4", "Whale Hat", "Washington, DC", "blank_male",
				"Information about Whale Hat. Information about Whale Hat. Information about Whale Hat. Information about Whale Hat. Information about Whale Hat. "));
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
		public String imgFileLoc;

		public Recipient(String in_id, String in_name, String in_location, String in_imgFileLoc, String in_description) {
			id = in_id;
			name = in_name;
			location = in_location;
			description = in_description;
			imgFileLoc = in_imgFileLoc;
		}

	}

}
