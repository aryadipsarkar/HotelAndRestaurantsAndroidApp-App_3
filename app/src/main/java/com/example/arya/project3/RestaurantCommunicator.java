package com.example.arya.project3;

/**
 * Created by arya's on 10/25/2016.
 */
// Callback interface that allows NameFragmentRestaurant to notify the MainActivityRestaurants when user clicks on a List Item
// Main Activity implements this Interface
public interface RestaurantCommunicator {
    public void respond(int i);
}
