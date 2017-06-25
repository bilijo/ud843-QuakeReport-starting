package com.example.android.quakereport;

/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeData {
  // Variables of the class
    private int mMagnitude;
    private String mLocation;
    private String mDate;

     /*
    * Create a constructor of EarthQuakeData class.
    */
    public EarthQuakeData(int vMagnitude, String vLocation, String vDate) {
          mMagnitude = vMagnitude ;
         mLocation = vLocation;
         mDate = vDate;
    }

    public int getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }
}
