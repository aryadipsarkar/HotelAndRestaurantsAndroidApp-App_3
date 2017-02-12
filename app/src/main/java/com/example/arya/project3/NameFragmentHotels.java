package com.example.arya.project3;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by arya's on 10/24/2016.
 */
public class NameFragmentHotels extends Fragment implements AdapterView.OnItemClickListener {
    ListView list;
    String[] hotel_name_array;
    String[] hotel_address_array;
    HotelCommunicator hotelCommunicator;
    int bundle_position;

    // Called to create the content view for this Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout defined in name_fragment_layout_hotels.xml
        View view=inflater.inflate(R.layout.name_fragment_layout_hotels, container, false);
        return view;
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        //Getting the interface variable
        hotelCommunicator= (HotelCommunicator) getActivity();
        //Setting up the listView
        list= (ListView) getActivity().findViewById(R.id.listView);
        //Getting the hotel names and hotel addresses from the 'String' and storing it into two array
        Resources res= getResources();
        hotel_name_array=res.getStringArray(R.array.Hotel_Names);
        hotel_address_array=res.getStringArray(R.array.Hotel_Address);
        //Creating the custom adapter object with the required parameters
        VizAdapter adapter=new VizAdapter(getContext(),hotel_name_array, hotel_address_array);
        // Set the list choice mode to allow only one selection at a time
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //Invoking the created Adapter
        list.setAdapter(adapter);
        //Invoking the click() function for every item on the list
        list.setOnItemClickListener(this);
    }
    //Setting the custom adapter which extends ArrayAdapter
    class VizAdapter extends ArrayAdapter<String>{
        Context context;
        String[] name_array;
        String[] address_array;
        //Override the constructor
        VizAdapter(Context context,String[] name_array, String[] address_array){
            //Override the super class
            super(context, R.layout.single_row_hotels,R.id.textView_hotel_name,name_array);
            this.context=context;
            this.name_array=name_array;
            this.address_array=address_array;

        }
        //Override the getView class
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Inflating the custom List-view
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.single_row_hotels,parent,false);
            //Getting the reference of the placeholders
            TextView textView_name= (TextView) row.findViewById(R.id.textView_hotel_name);
            TextView textView_address= (TextView) row.findViewById(R.id.textView_hotel_address);
            //Setting the names and addresses in the respective positions
            textView_name.setText(name_array[position]);
            textView_address.setText(address_array[position]);
            return row;
        }
    }
    // Called when the user selects an item from the List
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        //Inform the MainActivityHotels that the item in position 'pos' has been selected
        //This invokes the respond() function in the main activity
        bundle_position=pos;
        hotelCommunicator.respond(pos);
    }

    //Used to retain the fragment state across Activity reconfigurations
    //Called just before the fragment changes its configurations
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this Fragment across Activity reconfigurations
        setRetainInstance(true);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("Bundle",bundle_position);
        super.onSaveInstanceState(outState);
    }


}
