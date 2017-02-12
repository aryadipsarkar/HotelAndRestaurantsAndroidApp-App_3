package com.example.arya.project3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by arya's on 10/24/2016.
 */
public class ImageFragmentHotels extends Fragment {
    ImageView image;

    // Called to create the content view for this Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout defined in image_fragment_layout_hotels.xml
        View view=inflater.inflate(R.layout.image_fragment_layout_hotels, container, false);
        return view;
    }
    //Called after the Activity has ben created
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        //Getting the image reference
        image= (ImageView) getActivity().findViewById(R.id.imageView);
    }
    //This function is being invoked from ChangeData() in the MainActivityHotels
    public void ChangeData(int i){
        //Creating an array to hold the images
        int[] hotel_image={R.drawable.elysian_hotel,R.drawable.fourseasons_hotel,R.drawable.langham_hotel,
                R.drawable.peninsula_hotel,R.drawable.ritzcarlton_hotel,R.drawable.waldorfastoria_hotel};
        //Setting up the image with the position that it has got from the MainActivityHotels
        image.setImageResource(hotel_image[i]);
    }
    //Used to retain the fragment state across Activity reconfigurations
    //Called just before the fragment changes its configurations
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this Fragment across Activity reconfigurations
        setRetainInstance(true);
    }
}
