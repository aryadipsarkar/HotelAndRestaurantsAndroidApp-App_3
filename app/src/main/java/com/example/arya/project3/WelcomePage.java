package com.example.arya.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by arya's on 10/25/2016.
 */

//It is just a Welcome Page to give user the flexibility to choose which one among "Hotels" and "Restaurants", he wants to choose from
//It is not there in the Project Synopsis
//If somebody wants to run the App A3 alone, without invoking from the broadcast of app A1, then it will act as Welcome Screen
// Has two buttons when pressed to route the user to the chosen activity
public class WelcomePage extends AppCompatActivity implements View.OnClickListener {
    Button button_hotel;
    Button button_restaurant;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page_layout);
        button_hotel= (Button) findViewById(R.id.button1);
        button_restaurant= (Button) findViewById(R.id.button2);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button_hotel.setOnClickListener(this);
        button_restaurant.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button1){
            Intent intent= new Intent(this,MainActivityHotels.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.button2){
            Intent intent=new Intent(this, MainActivityRestaurants.class);
            startActivity(intent);
        }
    }
}
