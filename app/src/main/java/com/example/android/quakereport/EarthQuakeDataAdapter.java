package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeDataAdapter extends ArrayAdapter<EarthQuakeData> {
   // private static final String LOG_TAG = EarthQuakeDataAdapter.class.getSimpleName();

    // Constructor
      /* @param context The current context. Used to inflate the layout file.
      * @param earthQuakeDatas A List of EarthQuakeData objects to display in a list
     */
    public EarthQuakeDataAdapter(@NonNull Context context, @NonNull ArrayList<EarthQuakeData> earthQuakeDatas) {
        super(context, 0, earthQuakeDatas);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            // use the layout of the data items to be displayed
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_earthquake_data, parent, false);
        }


        // Get the {@link EarthQuakeData} object located at this position in the list
            EarthQuakeData currentEarthQuakeData = getItem(position);

        // getmMagnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.textView_magnitude);
        magnitudeTextView.setText(currentEarthQuakeData.getmMagnitude());

        //getmKm
        TextView kmLocationTextView = (TextView) listItemView.findViewById(R.id.textView_km_location);
        kmLocationTextView.setText(currentEarthQuakeData.getmKm());
        //getmLocation
        TextView placelocationTextView = (TextView) listItemView.findViewById(R.id.textView_location);
        placelocationTextView.setText(currentEarthQuakeData.getmLocation());

        //getmDate
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textView_date);
        dateTextView.setText(currentEarthQuakeData.getmDate());
        //getmTime
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.textView_time);
        timeTextView.setText(currentEarthQuakeData.getmTime());

        return listItemView;

        }

    }
