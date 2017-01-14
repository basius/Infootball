package com.example.basius.infootball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainPortada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_portada);
        Button bInici = (Button)findViewById(R.id.button);


        int resID = getResources().getIdentifier("himnebarcelona" , "raw", getPackageName());
        final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), resID);
        mediaPlayer.start();

        bInici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent intent = new Intent(getApplicationContext(), MainActivityMenu.class);
                startActivity(intent);
            }
        });
    }




}
