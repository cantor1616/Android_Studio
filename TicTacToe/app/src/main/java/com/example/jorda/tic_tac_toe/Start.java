package com.example.jorda.tic_tac_toe;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Start extends AppCompatActivity {
    ////////////////////////////////////////////
    ////////////////variables///////////////////
    ////////////////////////////////////////////
    public static boolean twoPlayers;
    public static String player1;
    public static String player2 = "The computer";
    ////////////////////////////////////////////
    ///////////// end variables ////////////////
    ////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_tic_tac_toe);
    }

    public void onePlayer (View v){
        Button startButton = findViewById(R.id.startButton);
        TextView name = findViewById(R.id.player1name);
        TextView name2 = findViewById(R.id.player2name);
        TextView enterNames = findViewById(R.id.enterNames);

        startButton.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        name2.setVisibility(View.GONE);
        enterNames.setVisibility(View.VISIBLE);
        twoPlayers = false;
    }

    public void twoPlayer (View v){
        Button startButton = findViewById(R.id.startButton);
        TextView name = findViewById(R.id.player1name);
        TextView name2 = findViewById(R.id.player2name);
        TextView enterNames = findViewById(R.id.enterNames);

        startButton.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        name2.setVisibility(View.VISIBLE);
        enterNames.setVisibility(View.VISIBLE);
        twoPlayers = true;
    }

    public boolean isTwoPlayer(){
        return twoPlayers;
    }

    public String getPlayer1Name(){
        return player1;
    }

    public String getPlayer2Name(){
        return player2;
    }

    public void startButton(View v){
        EditText name1 = findViewById(R.id.player1name);
        player1 = name1.getText().toString();

        if (isTwoPlayer()){
            EditText name2 = findViewById(R.id.player2name);
            player2 = name2.getText().toString();
        } else {
            player2 = "The computer";
        }

        Intent intent= new Intent(this, TicTacToe.class);
        startActivity(intent);
    }
}
