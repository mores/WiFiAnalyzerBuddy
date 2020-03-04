package com.example.wifianalyzerbuddy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {WiFi.class}, version = 1, exportSchema = false)
public abstract class WiFiDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
