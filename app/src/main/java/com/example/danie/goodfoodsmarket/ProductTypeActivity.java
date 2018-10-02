package com.example.danie.goodfoodsmarket;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductTypeActivity extends ListActivity {

    public static int categoryIndexGloabal = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        int categoryIndex = (Integer) getIntent().getExtras().get( "index" );

        categoryIndexGloabal = categoryIndex;

        ArrayAdapter<Food> arrayAdapter = null;

        switch ( categoryIndex ) {
            case 0:
                arrayAdapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, Food.fruits );
                break;
            case 1:
                arrayAdapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, Food.vegetables );
                break;
            case 2:
                arrayAdapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, Food.bakery );
                break;
        }

        ListView listCountries = getListView();
        listCountries.setAdapter( arrayAdapter );

    }

    @Override
    protected void onListItemClick( ListView l, View v, int position, long id ) {
        Intent i = new Intent( this, ProductDetailsActivity.class );
        i.putExtra( "index", (int) id );
        i.putExtra( "type",  categoryIndexGloabal);
        startActivity( i );
    }
}
