package com.example.basius.infootball;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.databinding.DataBindingUtil;

import com.example.basius.infootball.databinding.FragmentMainActivityMenuBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityMenuFragment extends Fragment {

    public MainActivityMenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_main_activity_menu, container, false);
        // Button bResultats = (Button) view.findViewById(R.id.buttonResultats);
        FragmentMainActivityMenuBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main_activity_menu, container, false);
        View view = binding.getRoot();
        binding.buttonResultats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ResultatsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
