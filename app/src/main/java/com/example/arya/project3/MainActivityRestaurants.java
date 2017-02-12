package com.example.arya.project3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by arya's on 10/25/2016.
 */
public class MainActivityRestaurants extends AppCompatActivity implements RestaurantCommunicator{

    FrameLayout nameFrame;
    FrameLayout imageFrame;
    Toolbar toolbar1;
    FragmentManager fragmentManager;
    NameFragmentRestaurants nameFragment=new NameFragmentRestaurants();
    ImageFragmentRestaurants imageFragment=new ImageFragmentRestaurants();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_restaurants);
        // Get references to the NameFragment and to the TitleFragment
        nameFrame= (FrameLayout) findViewById(R.id.restaurant_name_frame);
        imageFrame= (FrameLayout) findViewById(R.id.restaurant_image_frame);
        //Setting up the Toolbar
        toolbar1= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        // Get a reference to the FragmentManager
        fragmentManager=getSupportFragmentManager();
        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add the NameFragment to the layout
        fragmentTransaction.add(R.id.restaurant_name_frame, nameFragment);
        // Commit the FragmentTransaction
        fragmentTransaction.commit();
        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                setLayout();
            }
        });
    }
    private void setLayout() {
        int screenOrientation = getResources().getConfiguration().orientation;
        //Checking the screen-orientation (if its in PORTRAIT mode)
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            // Determine whether the ImageFragment has been added
            if (!imageFragment.isAdded()) {
                //Setting the LayoutParams
                LinearLayout.LayoutParams paramsExample1 =
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                // Make the NameFragment occupy the entire layout
                nameFrame.setLayoutParams(paramsExample1);
                LinearLayout.LayoutParams paramsExample2 =
                        new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                imageFrame.setLayoutParams(paramsExample2);

            } else {
                // Make the ImageFragment occupy the entire layout if imageFragment added
                LinearLayout.LayoutParams paramsExample3 =
                        new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                nameFrame.setLayoutParams(paramsExample3);
                LinearLayout.LayoutParams paramsExample4 =
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                imageFrame.setLayoutParams(paramsExample4);
            }
        }
        //Checking the screen-orientation (if its in LANDSCAPE mode)
        if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Determine whether the ImageFragment has been added
            if (!imageFragment.isAdded()) {
                // Make the NameFragment occupy the entire layout
                LinearLayout.LayoutParams paramsExample1 =
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                nameFrame.setLayoutParams(paramsExample1);
                LinearLayout.LayoutParams paramsExample2 =
                        new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                imageFrame.setLayoutParams(paramsExample2);

            } else {
                // Make the NameLayout take 1/3 of the layout's width
                LinearLayout.LayoutParams paramsExample3 =
                        new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                nameFrame.setLayoutParams(paramsExample3);
                // Make the ImageLayout take 1/3 of the layout's width
                LinearLayout.LayoutParams paramsExample4 =
                        new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
                imageFrame.setLayoutParams(paramsExample4);
            }
        }
    }
    //Called when the user selects an item in the NameFragment
    //This function is being invoked from the respond() function in the NameFragment
    @Override
    public void respond(int i) {
        // If the QuoteFragment has not been added, add it now
        if (!imageFragment.isAdded()) {
            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Add the ImageFragment to the layout
            fragmentTransaction.add(R.id.restaurant_image_frame, imageFragment);
            // Add this FragmentTransaction to the back-stack
            fragmentTransaction.addToBackStack(null);
            // Commit the FragmentTransaction
            fragmentTransaction.commit();
            // Force Android to execute the committed FragmentTransaction
            fragmentManager.executePendingTransactions();
        }
        //Tell the ImageFragment to show the quote string at position index
        //ImageFragment's ChangeData() function is invoked form here
        imageFragment.ChangeData(i);
    }
    //Creating the Options Menu of the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflating the Menu
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    //Activities to do, once items on the Options Menu is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resource_id=item.getItemId();
        //If Hotels is clicked, create an explicit intent and start the MainActivityHotels activity
        if (resource_id==R.id.Hotels){
            Intent intent=new Intent(this,MainActivityHotels.class);
            startActivity(intent);
        }
        //If Hotels is clicked, create an explicit intent and start the MainActivityRestaurants activity
        if (resource_id==R.id.Restaurants){
            Intent intent=new Intent(this,MainActivityRestaurants.class);
            startActivity(intent);
        }
        return true;
    }
}
