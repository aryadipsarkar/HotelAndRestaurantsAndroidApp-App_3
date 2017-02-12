package com.example.arya.project3;

/**
 * Created by arya's on 10/24/2016.
 */
// Callback interface that allows NameFragmentHotels to notify the MainActivityHotels when user clicks on a List Item
// Main Activity implements this Interface
public interface HotelCommunicator {
    public void respond(int i);
}
