package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.quakereport.EarthquakeActivity.holder;

/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeDataAdapter extends ArrayAdapter<>{
    private final Context context;
    public static ViewHolder holder;
// Constructor
      /* @param context The current context. Used to inflate the layout file.
      * @param earthQuakeDatas A List of EarthQuakeData objects to display in a list
     */
    public EarthQuakeDataAdapter(@NonNull Context context,  @NonNull ArrayList<EarthQuakeData> earthQuakeDatas) {
        super(context, 0, earthQuakeDatas);
        this.context = context;

    }

    public static class ViewHolder {
        private TextView nameTextView;
        private TextView locationTextView;
        private TextView dateTextView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.inflate(R.layout.earthquake_activity, null);

            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView_magnitude);
            holder.locationTextView = (TextView) convertView.findViewById(R.id.textView_location);
            holder.dateTextView = (TextView) convertView.findViewById(R.id.textView_date);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        EarthQuakeData earthQuake ;
        earthQuake = getItem(position);

        holder.nameTextView.setText(earthQuake.getmMagnitude());
        holder.locationTextView.setText(earthQuake.getmLocation());
        holder.dateTextView.setText(earthQuake.getmDate());

        return convertView;
    }
}
