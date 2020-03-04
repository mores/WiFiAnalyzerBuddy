package com.example.wifianalyzerbuddy;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Locale;

@Entity
public class WiFi implements Serializable {

    private static String TAG = "WAB::WiFi";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "latitude")
    private double latitude;

    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "ssid")
    private String ssid;

    @ColumnInfo(name = "strength")
    private int strength;

    public WiFi()
    {

    }

    public WiFi( String line ) {
        String[] parts = line.split( "\\|" );
        ssid = parts[1];

        String rawStrenth = parts[3];
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile( "-(\\d+)dBm" );
        java.util.regex.Matcher matcher = pattern.matcher( rawStrenth );
        if( matcher.matches() )
        {
            strength = Integer.parseInt( matcher.group( 1 ));
        }

        latitude = Double.parseDouble( parts[12] );
        longitude = Double.parseDouble( parts[13] );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude( double latitude ){
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude( double longitude ){
        this.longitude = longitude;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid( String ssid) {
        this.ssid = ssid;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString()
    {
        return String.format(Locale.ENGLISH,"%s[id=%d]%s %d %.7f %.7f", getClass().getSimpleName(), id, ssid, strength, latitude, longitude );
    }
}
