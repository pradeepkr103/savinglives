package com.savinglives;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {
    String[] listItems = {
            "My Life and Giving Goals",
            "My Causes, Select Charity",
            "Better Me History",
            "Group Inbox",
            "My Impact",
            "UberEats, UberGives"
    };
    Class[] activities = {
            GoalsActivity.class,
            CharityGridViewActivity.class,
            BetterMeActivity.class,
            GivingGroupInboxActivity.class,
            //TODO notifications
            ImpactActivity.class,
            CategoryActivity.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listItems));
    }
    // If you want to process click on a row in ListActivity override the onListItemClick() method ..
    // Here you are simply overriding the item click method ..
    @Override
    public void onListItemClick(ListView par, View v, int pos,long id) {
        //Toast.makeText(this,"Row selected"+listItems[pos], Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,activities[pos]);
        //i.putExtra("key","value");
        startActivity(i);
    }
}
