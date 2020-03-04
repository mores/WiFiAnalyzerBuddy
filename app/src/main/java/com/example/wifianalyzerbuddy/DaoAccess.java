package com.example.wifianalyzerbuddy;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoAccess {
    @Insert
    Long insertWiFi(WiFi wifi);

    @Query("SELECT * FROM WiFi")
    LiveData<List<WiFi>> fetchAllWiFi();

    @Query("SELECT * FROM WiFi WHERE ssid =:ssid")
    LiveData<List<WiFi>> getSsid(String ssid);
}
