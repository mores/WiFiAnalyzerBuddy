package com.example.wifianalyzerbuddy.ui.home;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wifianalyzerbuddy.MainActivity;
import com.example.wifianalyzerbuddy.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.record.setOnClickListener(new View.OnClickListener() {
            public void onClick( android.view.View rootView ) {
                Location location = ((MainActivity)getActivity()).getLocation();
                Log.i( "HF", "record: " +  location );
            }
        });

        return view;
    }
}
