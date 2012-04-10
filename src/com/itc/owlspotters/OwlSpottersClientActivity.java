package com.itc.owlspotters;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class OwlSpottersClientActivity extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Reusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, FriendsActivity.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("friends")
				.setIndicator("Friends",
						res.getDrawable(R.drawable.ic_tab_friends))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, EventsActivity.class);
		spec = tabHost
				.newTabSpec("events")
				.setIndicator("Events",
						res.getDrawable(R.drawable.ic_tab_events))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, FavoritesActivity.class);
		spec = tabHost
				.newTabSpec("favorites")
				.setIndicator("Favorites",
						res.getDrawable(R.drawable.ic_tab_favorites))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(2);
	}
}