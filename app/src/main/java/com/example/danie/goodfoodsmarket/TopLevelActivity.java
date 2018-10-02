package com.example.danie.goodfoodsmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_top_level );

        ListView list_continents = findViewById( R.id.list_categories );
        list_continents.setOnItemClickListener( ( adapterView, view, position, id ) -> {
            Intent i = new Intent( TopLevelActivity.this, ProductTypeActivity.class );
            i.putExtra( "index", (int) id );
            startActivity( i );
        } );
    }
}
