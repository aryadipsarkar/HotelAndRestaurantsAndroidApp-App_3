package com.example.arya.project3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DeterBroadcastReceiver extends BroadcastReceiver {
    //the BroadCast receiver which receives the intent that has been sent from A1 app
    public DeterBroadcastReceiver() {
    }
    //invoking the onReceive() method
    @Override
    public void onReceive(Context context, Intent intent) {
        //Getting the extra data (which is the indication about which one of the two buttons has been pressed)
        //Storing the data in String variable
        String message=intent.getStringExtra("message");
        //If the extra data received matches with Hotels, then the MainActivityHotels is invoked with Explicit intents
        if (message.contentEquals("Hotel")) {
            Intent intent1 = new Intent(context.getApplicationContext(), MainActivityHotels.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
        //If the extra data received matches with Restaurants, then the MainActivityRestaurants is invoked with Explicit intents
        if (message.contentEquals("Restaurant")) {
            Intent intent1 = new Intent(context.getApplicationContext(), MainActivityRestaurants.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}
