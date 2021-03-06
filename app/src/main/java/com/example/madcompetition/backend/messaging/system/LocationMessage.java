package com.example.madcompetition.backend.messaging.system;

import android.location.Location;

import androidx.annotation.NonNull;

import com.example.madcompetition.backend.LocationData;
import com.example.madcompetition.backend.account.AccountInformation;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocationMessage extends Message {



    private double longitude;
    private double latitude;



    public LocationMessage(Location location, AccountInformation sender, AccountInformation[] recepients)
    {

        super(sender,recepients, MediaType.Location, "Long : " + location.getLongitude() + "Lat : " + location.getLatitude());
        this.setLongitude(location.getLongitude());
        this.setLatitude(location.getLatitude());
        setTimeSent(LocalTime.now());
        setDateSent(LocalDate.now());
    }


    public LocationMessage(LocationData location, AccountInformation sender, AccountInformation[] receients)
    {

        super(sender,receients, MediaType.Location, "Long : " + location.getLongitude() + "Lat : " + location.getLatitude());
        this.setLongitude(location.getLongitude());
        this.setLatitude(location.getLatitude());
    }




    @NonNull
    @Override
    public String toString() {
        String str = super.getMessage();
        return str;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
