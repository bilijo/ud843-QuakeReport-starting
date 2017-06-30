package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.quakereport.R.id.list;

/**
 * Created by dam on 29.06.2017.
 */

public class EarthQuakeDataActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<EarthQuakeData> {


    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;


    public static final String LOG_TAG = EarthQuakeDataActivity.class.getName();
    /**
     * Sample JSON response for a USGS query
     */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    public static Uri earthquakeUri;


    /** Adapter for the list of earthquakes */
    private EarthQuakeDataAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(list);

        // Create a new adapter that takes an empty list of earthquakes as input
        mAdapter = new EarthQuakeDataAdapter(this, new ArrayList<EarthQuakeData>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);




        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthQuakeData currentEarthQuakeData = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthQuakeData.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);



    }

    @Override
    public Loader<List<EarthQuakeData>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new EarthQuakeData(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<EarthQuakeData>> loader, List<EarthQuakeData> earthQuakeDatas) {
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthQuakeDatas != null && !earthQuakeDatas.isEmpty()) {
            mAdapter.addAll(earthQuakeDatas);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<EarthQuakeData>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }









}
