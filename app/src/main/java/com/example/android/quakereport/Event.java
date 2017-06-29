/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import java.sql.Time;
import java.util.Date;

/**
 * {@Event} represents an earthquake event.
 */
public class Event {

    /** Magnitude of the earthquake event */
    public final int magnitude;

    /** Name of the location where the earthquake occures */
    public final String location;

    /** How far from nearby city */
    public final String kmLocation;

    /** Date */
    public final String date;

    /** Date */
    public final String time;

    /**
     * Constructs a new {@link Event}.
     *
     * @param eMagnitude is the title of the earthquake event
     * @param eLocation is the number of people who felt the earthquake and reported how
     *                         strong it was
     * @param eKmLocation is the perceived strength of the earthquake from the responses
     *
     * @param eDate is the date of the earthquake
     *
     * @param eTime is the time of the earthquake
     */
    public Event(int eMagnitude, String eLocation, String eKmLocation, String eDate, String eTime ) {
        magnitude = eMagnitude;
        location = eLocation;
        kmLocation = eKmLocation;
        date = eDate;
        time = eTime;


    }
}