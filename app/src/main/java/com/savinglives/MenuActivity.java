package com.savinglives;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

public class MenuActivity extends ListActivity {
    String[] listItems = {"Giving Goals", "android",
            "list", "activities"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
    }
}
