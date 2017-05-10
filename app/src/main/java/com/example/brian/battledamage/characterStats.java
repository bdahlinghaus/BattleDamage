package com.example.brian.battledamage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class characterStats extends AppCompatActivity {

    TextView strValue;
    Button strUp;
    Button strDown;
    Player newPlayer = Player.getPlayerInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);

        //Define all textviews and buttons in onCreate funciont

        strValue = (TextView) findViewById(R.id.strValue);
        strValue.setText(String.valueOf(newPlayer.getStrength()));
        strUp = (Button)findViewById(R.id.strUp);
        strDown = (Button)findViewById(R.id.strDown);

        //set OnClickListeners to do an action when button is pressed.
        strUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strValue.setText(String.format("%d", newPlayer.modStrength(1)));
            }
        });

        strDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strValue.setText(String.format("%d", newPlayer.modStrength(-1)));
            }
        });
    }
}

