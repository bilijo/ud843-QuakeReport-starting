package com.example.android.quakereport;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.R.attr.color;
import static android.R.attr.shape;
import static com.example.android.quakereport.R.drawable.magnitude_circle;
import static com.example.android.quakereport.R.id.textView_magnitude;


/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeDataAdapter extends ArrayAdapter<EarthQuakeData> {
    private static final String LOG_TAG = EarthQuakeDataAdapter.class.getSimpleName();

    Drawable myShape;
    private Context context;

    // Constructor
      /* @param context The current context. Used to inflate the layout file.
      * @param earthQuakeDatas A List of EarthQuakeData objects to display in a list
     */
    public EarthQuakeDataAdapter(@NonNull Context context, @NonNull ArrayList<EarthQuakeData> earthQuakeDatas) {
        super(context, 0, earthQuakeDatas);

        this.context = context;

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
        //TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.textView_magnitude);
        //magnitudeTextView.setText(currentEarthQuakeData.getmMagnitude());

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(textView_magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthQuakeData.getmMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);

       // TextView magnitudeView = (TextView) findViewById(textView_magnitude);
      /*  Drawable background = magnitudeView.getBackground();
        background.setColorFilter(ContextCompat.getColor(magnitudeView.getContext(),R.color.magnitude4), PorterDuff.Mode.SRC_ATOP);
       */

        //View mainContainer = findViewById(R.id.textView_magnitude);
        GradientDrawable bgDrawable = (GradientDrawable) magnitudeView.getBackground();
        //bgDrawable.setColor(ContextCompat.getColor(context, R.color.magnitude4));

        // ------------------------------------------------------------


       // int  intMagnitude = Integer.parseInt(formattedMagnitude);
        float  intMagnitude = (float) currentEarthQuakeData.getmMagnitude();

        Log.d(LOG_TAG ,"intMagnitude  "+ intMagnitude);

        if (intMagnitude < 6.2 && intMagnitude > 5){
            Log.d(LOG_TAG ,"currentEarthQuakeData.getmMagnitude()  "+ currentEarthQuakeData.getmMagnitude());
            bgDrawable.setColor(ContextCompat.getColor(context, R.color.magnitude9));

        }else if ( intMagnitude < 6.5 && intMagnitude >= 6.2){

            bgDrawable.setColor(ContextCompat.getColor(context, R.color.magnitude2));

        }else if (intMagnitude < 7 && intMagnitude >= 6.5){

            bgDrawable.setColor(ContextCompat.getColor(context, R.color.magnitude4));
        }

// ------------------------------------------------------------

        //getmKm
        TextView kmLocationTextView = (TextView) listItemView.findViewById(R.id.textView_km_location);
        kmLocationTextView.setText(currentEarthQuakeData.getmKm());

        //getmLocation
        TextView placelocationTextView = (TextView) listItemView.findViewById(R.id.textView_location);
        placelocationTextView.setText(currentEarthQuakeData.getmLocation());

        //getmDate
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textView_date);
        dateTextView.setText(currentEarthQuakeData.getUrl());

        //getmTime
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.textView_time);
        timeTextView.setText(String.valueOf(currentEarthQuakeData.getmTime()));

        return listItemView;

        }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    }
