package com.example.android.quakereport;

/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeData {
    // Variables of the class
    private String mMagnitude;
    private String mLocation;
    private String mDate;

    /*
   * Create a constructor of EarthQuakeData class.
   */
    public EarthQuakeData(String vMagnitude, String vLocation, String vDate) {
        mMagnitude = vMagnitude;
        mLocation = vLocation;
        mDate = vDate;
    }
// getters
    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }


}
