package com.example.brian.battledamage;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.example.brian.battledamage.R.id.experiencePoints;
import static com.example.brian.battledamage.R.id.fbutton;

public class    MainActivity extends AppCompatActivity {
    Enemy myEnemy = new Enemy();
    Player newPlayer = Player.getPlayerInstance();

//    Button fbutton = (Button) findViewById(R.id.fbutton);
    TextView bossMessage;
    TextView bossHp;
    TextView experiencePoints;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bossMessage = (TextView) findViewById(R.id.bossMessage);
        bossHp = (TextView) findViewById(R.id.bossHp);
        experiencePoints = (TextView) findViewById(R.id.experiencePoints);
        output = (TextView) findViewById(R.id.output);

        bossMessage.setText(myEnemy.getName() + " has appeared!");
        bossHp.setText(String.format("%d", myEnemy.getHealth()));
        experiencePoints.setText(String.format("%d", newPlayer.getExp()));

    }

    protected void battle(View v) {

            myEnemy.health -= newPlayer.attack();
            output.setText("You did " + newPlayer.attack() + " damage!");
            if(myEnemy.health <= 0) {
                bossHp.setText("0");
            }else {
                bossHp.setText(String.format("%d", myEnemy.getHealth()));
            }
            if (myEnemy.isDead()) {
                Enemy oldEnemy = myEnemy;
                myEnemy = new Enemy();
                bossMessage.setText(myEnemy.getName() + " has appeared!");
                newPlayer.gainExp();
                experiencePoints.setText(String.format("%d", newPlayer.getExp()));
                output.setText("You did " + newPlayer.attack() + " damage, and killed the " + oldEnemy.getName() + "!");
            }

    }



    protected void gotoStats(View v) {
        Intent intent = new Intent(this, characterStats.class);
        startActivity(intent);
        }

}