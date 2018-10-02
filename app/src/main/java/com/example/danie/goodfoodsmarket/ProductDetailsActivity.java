package com.example.danie.goodfoodsmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_product_details );

        int foodIndex = (Integer) getIntent().getExtras().get( "index" );
        int categoryIndex = (Integer) getIntent().getExtras().get( "type" );

        Food[] food = null;

        switch ( categoryIndex ) {
            case 0:
                food = Food.fruits;
                break;
            case 1:
                food = Food.vegetables;
                break;
            case 2:
                food = Food.bakery;
                break;
        }


        getCorrespondingInfo( food[ foodIndex ] );
    }

    void getCorrespondingInfo( Food food ) {
        ImageView photo = findViewById( R.id.photo );
        photo.setImageResource( food.getImageResourceId() );
        photo.setContentDescription( food.getCategory() );
        photo.setContentDescription( food.getCountryOfOrigin() );
        photo.setContentDescription( food.getUnit() );
        photo.setContentDescription( String.valueOf( food.getPrice() ) );

        TextView name = findViewById( R.id.name );
        name.setText( food.getName() );

        TextView category = findViewById( R.id.category );
        category.setText( "Category: " + food.getCategory() );

        TextView origin = findViewById( R.id.origin );
        origin.setText( "Country of origin: " + food.getCountryOfOrigin() );

        TextView unit = findViewById( R.id.unit );
        unit.setText( "Unit" + food.getUnit() );

        TextView price = findViewById( R.id.price );
        price.setText( "Price: " + String.valueOf( food.getPrice() ) );
    }
}
