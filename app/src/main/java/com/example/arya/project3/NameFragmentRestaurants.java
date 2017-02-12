package com.example.arya.project3;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by arya's on 10/25/2016.
 */
public class NameFragmentRestaurants extends Fragment implements AdapterView.OnItemClickListener {
    RestaurantCommunicator restaurantCommunicator;
    ListView listView;
    String[] restaurant_name_array;
    String[] restaurant_address_array;
    // Called to create the content view for this Fragment
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout defined in name_fragment_layout_restaurants.xml
        View view=inflater.inflate(R.layout.name_fragment_layout_restaurants, container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Getting the interface variable
        restaurantCommunicator= (RestaurantCommunicator) getActivity();
        //Setting up the listView
        listView=(ListView) getActivity().findViewById(R.id.listViewRes);
        //Getting the restaurants names and restaurants addresses from the 'String' and storing it into two array
        Resources res= getResources();
        restaurant_name_array=res.getStringArray(R.array.Restaurant_Names);
        restaurant_address_array=res.getStringArray(R.array.Restaurant_Address);
        //Creating the custom adapter object with the required parameters
        VizAdapter adapter=new VizAdapter(getContext(),restaurant_name_array, restaurant_address_array);
        // Set the list choice mode to allow only one selection at a time
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //Invoking the created Adapter
        listView.setAdapter(adapter);
        //Invoking the click() function for every item on the list
        listView.setOnItemClickListener(this);
    }

    //Setting the custom adapter which extends ArrayAdapter
    class VizAdapter extends ArrayAdapter<String>{
        Context context;
        String[] name_array;
        String[] address_array;
        //Override the constructor
        VizAdapter(Context context,String[] name_array, String[] address_array){
            //Override the super class
            super(context, R.layout.single_row_restaurants,R.id.textView_restaurant_name,name_array);
            this.context=context;
            this.name_array=name_array;
            this.address_array=address_array;

        }
        //Override the getView class
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Inflating the custom List-view
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.single_row_restaurants,parent,false);
            //Getting the reference of the placeholders
            TextView textView_name= (TextView) row.findViewById(R.id.textView_restaurant_name);
            TextView textView_address= (TextView) row.findViewById(R.id.textView_restaurant_address);
            //Setting the names and addresses in the respective positions
            textView_name.setText(name_array[position]);
            textView_address.setText(address_array[position]);
            return row;
        }
    }

    // Called when the user selects an item from the List
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Inform the MainActivityRestaurants that the item in position 'pos' has been selected
        //This invokes the respond() function in the main activity
        restaurantCommunicator.respond(i);
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
