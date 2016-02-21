package com.savinglives;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BetterMeActivity extends ListActivity {
    String[] listItems = {
            "Jan  5 183.5 lbs",
            "Jan 15 182   lbs",
            "Jan 28 180   lbs",
            "Jan 28 Gave $50 nets",

            "Feb 7  179   lbs",
            "Gave $11 for losing 1 lb",
            "Feb 20 $5 UberGives,$2 Tip",
            "Feb 21 177.2 lbs"
    };
    String[] messages = {
            "Resolve: Lose and Give!",
            "Wow! Lost 1.5 lb, Give $15",
            "Super! Lost 2 lb, Give $20+$20 for month",
            "Saved 32 kids lives in Congo",

            "#2 in Pinterst Group! Lost 1 lb, Give $10",
            "Good Job",
            "UberTips $2, UberGives Saved 5 lives",
            "Keep it up! Give $20 for month +$12 "
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weights_activity);
        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listItems));
    }
    // If you want to process click on a row in ListActivity override the onListItemClick() method ..
    // Here you are simply overriding the item click method ..
    @Override
    public void onListItemClick(ListView par, View v, int pos,long id) {
        Toast.makeText(this,messages[pos], Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(this,activities[pos]);
        //x i.putExtra("key","value");
        // startActivity(i);
    }

}
