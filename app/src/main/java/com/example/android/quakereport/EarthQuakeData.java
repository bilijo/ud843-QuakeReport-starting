package com.example.android.quakereport;

/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeData {
    // Variables of the class
    //private String mMagnitude;
    private double mMagnitude;
    private String mKm;
    private String mLocation;
    private String mUrl;
    private long mTime;


   /*
   * Constructs a new {@link EarthQuakeData} object.
   *
   * @param vmagnitude is the magnitude (size) of the earthquake
   * @param vlocation is the city location of the earthquake
   * @param vdate is the time in "LLL dd, yyyy"(from the Epoch) when the
   * @param vtime is the time in "h:mm a" (from the Epoch) when the
   *  earthquake happened
   */

    public EarthQuakeData(double vMagnitude,  String vLocation,  long vTime, String url) {
        mMagnitude = vMagnitude;
       // mKm = vKm;
        mLocation = vLocation;
        mUrl = url;
        mTime = vTime;
    }

// getters
    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmKm() {
        return mKm;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getMurl() {
        return mUrl;
    }

    public long getmTime() {
        return mTime;
    }


}
