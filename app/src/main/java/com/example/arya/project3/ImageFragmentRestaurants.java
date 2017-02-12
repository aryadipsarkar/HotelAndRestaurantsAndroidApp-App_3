package com.example.arya.project3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by arya's on 10/25/2016.
 */
public class ImageFragmentRestaurants extends Fragment {
   ImageView image;

    // Called to create the content view for this Fragment
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout defined in image_fragment_layout_restaurants.xml
        View view=inflater.inflate(R.layout.image_fragment_layout_restaurants, container, false);
        return view;
    }

    //Called after the Activity has ben created
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        //Getting the image reference
        image= (ImageView) getActivity().findViewById(R.id.imageViewRes);
    }

    //This function is being invoked from ChangeData() in the MainActivityRestaurants
    public void ChangeData(int i){
        //Creating an array to hold the images
        int[] restaurant_image={R.drawable.lenabrava_restaurant,R.drawable.giant_restaurant,R.drawable.duckduckgoat_restaurant,
                                    R.drawable.roister_restaurant,R.drawable.smyth_restaurant,R.drawable.codedivolpe_restaurant};
        //Setting up the image with the position that it has got from the MainActivityRestaurants
        image.setImageResource(restaurant_image[i]);
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