package com.example.wifianalyzerbuddy;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class WiFiRepository {
    private String DB_NAME = "db_wifi";

    private WiFiDatabase wifiDatabase;

    public WiFiRepository(Context context) {
        wifiDatabase = Room.databaseBuilder(context, WiFiDatabase.class, DB_NAME).build();
    }

    public void insertWifi(final WiFi wifi) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                wifiDatabase.daoAccess().insertWiFi(wifi);
                return null;
            }
        }.execute();
    }

    public LiveData<List<WiFi>> getWifi() {
        return wifiDatabase.daoAccess().fetchAllWiFi();
    }

    public LiveData<List<WiFi>> getWifi( String ssid) {
        return wifiDatabase.daoAccess().getSsid( ssid );
    }
}
