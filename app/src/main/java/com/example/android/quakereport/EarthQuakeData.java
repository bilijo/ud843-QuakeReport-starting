package com.example.android.quakereport;

/**
 * Created by dam on 25.06.2017.
 */

public class EarthQuakeData {
    // Variables of the class
    private String mMagnitude;
    private String mKm;
    private String mLocation;
    private String mDate;
    private String mTime;

   /*
   * Constructs a new {@link EarthQuakeData} object.
   *
   * @param vmagnitude is the magnitude (size) of the earthquake
   * @param vlocation is the city location of the earthquake
   * @param vdate is the time in "LLL dd, yyyy"(from the Epoch) when the
   * @param vtime is the time in "h:mm a" (from the Epoch) when the
   *  earthquake happened
   */

    public EarthQuakeData(String vMagnitude, String vKm, String vLocation, String vDate, String vTime) {
        mMagnitude = vMagnitude;
        mKm = vKm;
        mLocation = vLocation;
        mDate = vDate;
        mTime = vTime;
    }

// getters
    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmKm() {
        return mKm;
    }
    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }
    public String getmTime() {
        return mTime;
    }


}
