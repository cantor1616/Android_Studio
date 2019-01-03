package com.example.jorda.tic_tac_toe;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.Toast;
import java.util.Random;
import com.example.jorda.tic_tac_toe.Start;

public class TicTacToe extends AppCompatActivity {
    ////////////////////////////////////////////
    ////////////////variables///////////////////
    ////////////////////////////////////////////
    public boolean player1turn;
    public boolean gameOver = false;
    //public String player1 = "Player 1";
    //public String player2 = "Player 2";
    public String player1;
    public String player2;
    public int firstMove;

    Random rand = new Random();
    public int winner = rand.nextInt(2) + 1;

    private final Start start = new Start();
    final Handler handler = new Handler();
    ////////////////////////////////////////////
    ///////////// end variables ////////////////
    ////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        player1 = start.getPlayer1Name();
        player2 = start.getPlayer2Name();

        Toast rand = Toast.makeText(this, "Randomizing who goes first..", Toast.LENGTH_SHORT);
        rand.show();

        if (winner == 1){
            Toast toast = Toast.makeText(this, player1 + " goes first!", Toast.LENGTH_SHORT);
            toast.show();

            player1turn = true;
            firstMove = 1;
        }
        else
        {
            if (start.isTwoPlayer()) {
                Toast toast = Toast.makeText(this, player2 + " goes first!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                //ai thinks and then goes
                Toast toast = Toast.makeText(this, player2 + " went first!", Toast.LENGTH_SHORT);
                toast.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        computerAI();
                        player1turn = true;
                    }
                }, 2000);
            }

            player1turn = false;
            firstMove = 2;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tic_tac_toe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_menu) {
            Intent intent= new Intent(this, Start.class);
            startActivity(intent);
        }
        else if (id == R.id.new_game){
            reset();
        }

        return super.onOptionsItemSelected(item);
    }

    public void topLeftButton(View v){
        if (!gameOver) {
            ImageView TLX = findViewById(R.id.topLeftX);
            ImageView TLO = findViewById(R.id.topLeftO);

            if (TLX.getVisibility() == View.VISIBLE || TLO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()){
                    if (player1turn) {
                        player1turn = false;
                        TLX.setVisibility(View.VISIBLE);
                    } else{
                        player1turn = true;
                        TLO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        TLX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void topMiddleButton(View v){
        if(!gameOver) {
            ImageView TMX = findViewById(R.id.topMiddleX);
            ImageView TMO = findViewById(R.id.topMiddleO);

            if (TMX.getVisibility() == View.VISIBLE || TMO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()){
                    if (player1turn) {
                        player1turn = false;
                        TMX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        TMO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        TMX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void topRightButton(View v){
        if(!gameOver) {
            ImageView TRX = findViewById(R.id.topRightX);
            ImageView TRO = findViewById(R.id.topRightO);

            if (TRX.getVisibility() == View.VISIBLE || TRO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        TRX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        TRO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        TRX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void middleLeftButton(View v){
        if(!gameOver) {
            ImageView MLX = findViewById(R.id.middleLeftX);
            ImageView MLO = findViewById(R.id.middleLeftO);

            if (MLX.getVisibility() == View.VISIBLE || MLO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        MLX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        MLO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        MLX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void middleButton(View v){
        if(!gameOver) {
            ImageView MX = findViewById(R.id.middleX);
            ImageView MO = findViewById(R.id.middleO);

            if (MX.getVisibility() == View.VISIBLE || MO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        MX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        MO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        MX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void middleRightButton(View v){
        if(!gameOver) {
            ImageView MRX = findViewById(R.id.middleRightX);
            ImageView MRO = findViewById(R.id.middleRightO);

            if (MRX.getVisibility() == View.VISIBLE || MRO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        MRX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        MRO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        MRX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void bottomLeftButton(View v){
        if(!gameOver) {
            ImageView BLX = findViewById(R.id.bottomLeftX);
            ImageView BLO = findViewById(R.id.bottomLeftO);

            if (BLX.getVisibility() == View.VISIBLE || BLO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        BLX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        BLO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        BLX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void bottomMiddleButton(View v){
        if(!gameOver) {
            ImageView BMX = findViewById(R.id.bottomMiddleX);
            ImageView BMO = findViewById(R.id.bottomMiddleO);

            if (BMX.getVisibility() == View.VISIBLE || BMO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        BMX.setVisibility(View.VISIBLE);
                    } else {
                        if (start.isTwoPlayer()) {
                            player1turn = true;
                            BMO.setVisibility(View.VISIBLE);
                        }
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        BMX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void bottomRightButton(View v){
        if(!gameOver) {
            ImageView BRX = findViewById(R.id.bottomRightX);
            ImageView BRO = findViewById(R.id.bottomRightO);

            if (BRX.getVisibility() == View.VISIBLE || BRO.getVisibility() == View.VISIBLE) {
                Toast toast = Toast.makeText(this, "That spot is taken! Try again!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (start.isTwoPlayer()) {
                    if (player1turn) {
                        player1turn = false;
                        BRX.setVisibility(View.VISIBLE);
                    } else {
                        player1turn = true;
                        BRO.setVisibility(View.VISIBLE);
                    }
                    checkWin();
                }
                else {
                    if (player1turn) {
                        player1turn = false;
                        BRX.setVisibility(View.VISIBLE);
                        checkWin();

                        if (!gameOver) {
                            //ai thinks and then goes
                            Toast toast = Toast.makeText(this, player2 + " is thinking!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    computerAI();
                                    player1turn = true;
                                }
                            }, 2000);
                        }
                    }
                }
            }
        }
    }

    public void computerAI()
    {
        if (!gameOver) {
            //ImageViewX
            ImageView TLX = findViewById(R.id.topLeftX);
            ImageView TMX = findViewById(R.id.topMiddleX);
            ImageView TRX = findViewById(R.id.topRightX);
            ImageView MLX = findViewById(R.id.middleLeftX);
            ImageView MX = findViewById(R.id.middleX);
            ImageView MRX = findViewById(R.id.middleRightX);
            ImageView BLX = findViewById(R.id.bottomLeftX);
            ImageView BMX = findViewById(R.id.bottomMiddleX);
            ImageView BRX = findViewById(R.id.bottomRightX);

            //ImageViewO
            ImageView TLO = findViewById(R.id.topLeftO);
            ImageView TMO = findViewById(R.id.topMiddleO);
            ImageView TRO = findViewById(R.id.topRightO);
            ImageView MLO = findViewById(R.id.middleLeftO);
            ImageView MO =  findViewById(R.id.middleO);
            ImageView MRO = findViewById(R.id.middleRightO);
            ImageView BLO = findViewById(R.id.bottomLeftO);
            ImageView BMO = findViewById(R.id.bottomMiddleO);
            ImageView BRO = findViewById(R.id.bottomRightO);

            //go for win
            if (TLX.getVisibility() == View.INVISIBLE && TLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TMO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MLO.getVisibility() == View.VISIBLE && BLO.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //diagonal
                if (MO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (TMX.getVisibility() == View.INVISIBLE && TMO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TLO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE) {
                    TMO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MO.getVisibility() == View.VISIBLE && BMO.getVisibility() == View.VISIBLE) {
                    TMO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (TRX.getVisibility() == View.INVISIBLE && TRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TLO.getVisibility() == View.VISIBLE && TMO.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MRO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //diagonal
                if (MO.getVisibility() == View.VISIBLE && BLO.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (MLX.getVisibility() == View.INVISIBLE && MLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MO.getVisibility() == View.VISIBLE && MRO.getVisibility() == View.VISIBLE) {
                    MLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (TLO.getVisibility() == View.VISIBLE && BLO.getVisibility() == View.VISIBLE) {
                    MLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (MX.getVisibility() == View.INVISIBLE && MO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MLO.getVisibility() == View.VISIBLE && MRO.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (TMO.getVisibility() == View.VISIBLE && BMO.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //diagonal
                if (TLO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                if (BLO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (MRX.getVisibility() == View.INVISIBLE && MRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MLO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE) {
                    MRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (TRO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    MRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (BLX.getVisibility() == View.INVISIBLE && BLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BMO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MLO.getVisibility() == View.VISIBLE && TLO.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //diagonal
                if (MO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (BMX.getVisibility() == View.INVISIBLE && BMO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BLO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE) {
                    BMO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MO.getVisibility() == View.VISIBLE && TMO.getVisibility() == View.VISIBLE) {
                    BMO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }
            if (BRX.getVisibility() == View.INVISIBLE && BRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BLO.getVisibility() == View.VISIBLE && BMO.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //vertical
                if (MRO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
                //diagonal
                if (TLO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    checkWin();
                    return;
                }
            }

            //go for block
            if (TLX.getVisibility() == View.INVISIBLE && TLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TMX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MLX.getVisibility() == View.VISIBLE && BLX.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    return;
                }
                //diagonal
                if (MX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    TLO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (TMX.getVisibility() == View.INVISIBLE && TMO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TLX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE) {
                    TMO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MX.getVisibility() == View.VISIBLE && BMX.getVisibility() == View.VISIBLE) {
                    TMO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (TRX.getVisibility() == View.INVISIBLE && TRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (TLX.getVisibility() == View.VISIBLE && TMX.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MRX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    return;
                }
                //diagonal
                if (MX.getVisibility() == View.VISIBLE && BLX.getVisibility() == View.VISIBLE) {
                    TRO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (MLX.getVisibility() == View.INVISIBLE && MLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MX.getVisibility() == View.VISIBLE && MRX.getVisibility() == View.VISIBLE) {
                    MLO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (TLX.getVisibility() == View.VISIBLE && BLX.getVisibility() == View.VISIBLE) {
                    MLO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (MX.getVisibility() == View.INVISIBLE && MO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MLX.getVisibility() == View.VISIBLE && MRX.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (TMX.getVisibility() == View.VISIBLE && BMX.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    return;
                }
                //diagonal
                if (TLX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    return;
                }
                if (BLX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE) {
                    MO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (MRX.getVisibility() == View.INVISIBLE && MRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (MLX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE) {
                    MRO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (TRX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    MRO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (BLX.getVisibility() == View.INVISIBLE && BLO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BMX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MLX.getVisibility() == View.VISIBLE && TLX.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    return;
                }
                //diagonal
                if (MX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE) {
                    BLO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (BMX.getVisibility() == View.INVISIBLE && BMO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BLX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE) {
                    BMO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MX.getVisibility() == View.VISIBLE && TMX.getVisibility() == View.VISIBLE) {
                    BMO.setVisibility(View.VISIBLE);
                    return;
                }
            }
            if (BRX.getVisibility() == View.INVISIBLE && BRO.getVisibility() == View.INVISIBLE) {
                //horizontal
                if (BLX.getVisibility() == View.VISIBLE && BMX.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    return;
                }
                //vertical
                if (MRX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    return;
                }
                //diagonal
                if (TLX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE) {
                    BRO.setVisibility(View.VISIBLE);
                    return;
                }
            }

            //random selection
            boolean validAiSelection = false;
            do{
                int AiSelection = rand.nextInt(9) + 1;
                switch (AiSelection){
                    case 1:
                        if (TLX.getVisibility() == View.INVISIBLE && TLO.getVisibility() == View.INVISIBLE) {
                            TLO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 2:
                        if (TMX.getVisibility() == View.INVISIBLE && TMO.getVisibility() == View.INVISIBLE) {
                            TMO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 3:
                        if (TRX.getVisibility() == View.INVISIBLE && TRO.getVisibility() == View.INVISIBLE) {
                            TRO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 4:
                        if (MLX.getVisibility() == View.INVISIBLE && MLO.getVisibility() == View.INVISIBLE) {
                            MLO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 5:
                        if (MX.getVisibility() == View.INVISIBLE && MO.getVisibility() == View.INVISIBLE) {
                            MO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 6:
                        if (MRX.getVisibility() == View.INVISIBLE && MRO.getVisibility() == View.INVISIBLE) {
                            MRO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 7:
                        if (BLX.getVisibility() == View.INVISIBLE && BLO.getVisibility() == View.INVISIBLE) {
                            BLO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 8:
                        if (BMX.getVisibility() == View.INVISIBLE && BMO.getVisibility() == View.INVISIBLE) {
                            BMO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                    case 9:
                        if (BRX.getVisibility() == View.INVISIBLE && BRO.getVisibility() == View.INVISIBLE) {
                            BRO.setVisibility(View.VISIBLE);
                            validAiSelection = true;
                        }
                        break;
                }
            } while(!validAiSelection);

            checkWin();
        }
    }


    public void checkWin(){
        //ImageViewX
        ImageView TLX = findViewById(R.id.topLeftX);
        ImageView TMX = findViewById(R.id.topMiddleX);
        ImageView TRX = findViewById(R.id.topRightX);
        ImageView MLX = findViewById(R.id.middleLeftX);
        ImageView MX  = findViewById(R.id.middleX);
        ImageView MRX = findViewById(R.id.middleRightX);
        ImageView BLX = findViewById(R.id.bottomLeftX);
        ImageView BMX = findViewById(R.id.bottomMiddleX);
        ImageView BRX = findViewById(R.id.bottomRightX);

        //ImageViewO
        ImageView TLO = findViewById(R.id.topLeftO);
        ImageView TMO = findViewById(R.id.topMiddleO);
        ImageView TRO = findViewById(R.id.topRightO);
        ImageView MLO = findViewById(R.id.middleLeftO);
        ImageView MO  = findViewById(R.id.middleO);
        ImageView MRO = findViewById(R.id.middleRightO);
        ImageView BLO = findViewById(R.id.bottomLeftO);
        ImageView BMO = findViewById(R.id.bottomMiddleO);
        ImageView BRO = findViewById(R.id.bottomRightO);

        //ImageViewWin
        ImageView VL = findViewById(R.id.verticalLeft);
        ImageView VM = findViewById(R.id.verticalMiddle);
        ImageView VR = findViewById(R.id.verticalRight);
        ImageView HT = findViewById(R.id.horizontalTop);
        ImageView HM = findViewById(R.id.horizontalMiddle);
        ImageView HB = findViewById(R.id.horizontalBottom);
        ImageView DD = findViewById(R.id.diagonalDown);
        ImageView DU = findViewById(R.id.diagonalUp);

        //check x win
        //horizontal
        if (TLX.getVisibility() == View.VISIBLE && TMX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE){
            HT.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        else if (MLX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE && MRX.getVisibility() == View.VISIBLE){
            HM.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        else if (BLX.getVisibility() == View.VISIBLE && BMX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE){
            HB.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        //vertical
        else if (TLX.getVisibility() == View.VISIBLE && MLX.getVisibility() == View.VISIBLE && BLX.getVisibility() == View.VISIBLE){
            VL.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        else if (TMX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE && BMX.getVisibility() == View.VISIBLE){
            VM.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        else if (TRX.getVisibility() == View.VISIBLE && MRX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE){
            VR.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        //diagonal
        else if (TLX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE && BRX.getVisibility() == View.VISIBLE){
            DD.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }
        else if (BLX.getVisibility() == View.VISIBLE && MX.getVisibility() == View.VISIBLE && TRX.getVisibility() == View.VISIBLE){
            DU.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player1 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 1;
        }

        //check o win
        //horizontal
        else if (TLO.getVisibility() == View.VISIBLE && TMO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE){
            HT.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        else if (MLO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE && MRO.getVisibility() == View.VISIBLE){
            HM.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        else if (BLO.getVisibility() == View.VISIBLE && BMO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE){
            HB.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        //vertical
        else if (TLO.getVisibility() == View.VISIBLE && MLO.getVisibility() == View.VISIBLE && BLO.getVisibility() == View.VISIBLE){
            VL.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        else if (TMO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE && BMO.getVisibility() == View.VISIBLE){
            VM.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        else if (TRO.getVisibility() == View.VISIBLE && MRO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE){
            VR.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        //diagonal
        else if (TLO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE && BRO.getVisibility() == View.VISIBLE){
            DD.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        else if (BLO.getVisibility() == View.VISIBLE && MO.getVisibility() == View.VISIBLE && TRO.getVisibility() == View.VISIBLE){
            DU.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, player2 + " is the winner!", Toast.LENGTH_SHORT);
            toast.show();
            gameOver = true;
            winner = 2;
        }
        //check for tie
        else if ((TLX.getVisibility() == View.VISIBLE || TLO.getVisibility() == View.VISIBLE) &&
                (TMX.getVisibility() == View.VISIBLE || TMO.getVisibility() == View.VISIBLE) &&
                (TRX.getVisibility() == View.VISIBLE || TRO.getVisibility() == View.VISIBLE) &&
                (MLX.getVisibility() == View.VISIBLE || MLO.getVisibility() == View.VISIBLE) &&
                (MX.getVisibility() == View.VISIBLE || MO.getVisibility() == View.VISIBLE) &&
                (MRX.getVisibility() == View.VISIBLE || MRO.getVisibility() == View.VISIBLE) &&
                (BLX.getVisibility() == View.VISIBLE || BLO.getVisibility() == View.VISIBLE) &&
                (BMX.getVisibility() == View.VISIBLE || BMO.getVisibility() == View.VISIBLE) &&
                (BRX.getVisibility() == View.VISIBLE || BRO.getVisibility() == View.VISIBLE))
        {
            Toast toast = Toast.makeText(this, "It's a tie!", Toast.LENGTH_SHORT);
            toast.show();

            gameOver = true;
            winner = 3;
        }

        if (gameOver){
            Button playAgainButton = findViewById(R.id.playAgain);
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }

    public void reset(){
        //ImageViewX
        ImageView TLX = findViewById(R.id.topLeftX);
        ImageView TMX = findViewById(R.id.topMiddleX);
        ImageView TRX = findViewById(R.id.topRightX);
        ImageView MLX = findViewById(R.id.middleLeftX);
        ImageView MX = findViewById(R.id.middleX);
        ImageView MRX = findViewById(R.id.middleRightX);
        ImageView BLX = findViewById(R.id.bottomLeftX);
        ImageView BMX = findViewById(R.id.bottomMiddleX);
        ImageView BRX = findViewById(R.id.bottomRightX);

        //ImageViewO
        ImageView TLO = findViewById(R.id.topLeftO);
        ImageView TMO = findViewById(R.id.topMiddleO);
        ImageView TRO = findViewById(R.id.topRightO);
        ImageView MLO = findViewById(R.id.middleLeftO);
        ImageView MO = findViewById(R.id.middleO);
        ImageView MRO = findViewById(R.id.middleRightO);
        ImageView BLO = findViewById(R.id.bottomLeftO);
        ImageView BMO = findViewById(R.id.bottomMiddleO);
        ImageView BRO = findViewById(R.id.bottomRightO);

        //ImageViewWin
        ImageView VL = findViewById(R.id.verticalLeft);
        ImageView VM = findViewById(R.id.verticalMiddle);
        ImageView VR = findViewById(R.id.verticalRight);
        ImageView HT = findViewById(R.id.horizontalTop);
        ImageView HM = findViewById(R.id.horizontalMiddle);
        ImageView HB = findViewById(R.id.horizontalBottom);
        ImageView DD = findViewById(R.id.diagonalDown);
        ImageView DU = findViewById(R.id.diagonalUp);

        TLX.setVisibility(View.INVISIBLE);
        TMX.setVisibility(View.INVISIBLE);
        TRX.setVisibility(View.INVISIBLE);
        MLX.setVisibility(View.INVISIBLE);
        MX.setVisibility(View.INVISIBLE);
        MRX.setVisibility(View.INVISIBLE);
        BLX.setVisibility(View.INVISIBLE);
        BMX.setVisibility(View.INVISIBLE);
        BRX.setVisibility(View.INVISIBLE);

        TLO.setVisibility(View.INVISIBLE);
        TMO.setVisibility(View.INVISIBLE);
        TRO.setVisibility(View.INVISIBLE);
        MLO.setVisibility(View.INVISIBLE);
        MO.setVisibility(View.INVISIBLE);
        MRO.setVisibility(View.INVISIBLE);
        BLO.setVisibility(View.INVISIBLE);
        BMO.setVisibility(View.INVISIBLE);
        BRO.setVisibility(View.INVISIBLE);

        VL.setVisibility(View.INVISIBLE);
        VM.setVisibility(View.INVISIBLE);
        VR.setVisibility(View.INVISIBLE);

        HT.setVisibility(View.INVISIBLE);
        HM.setVisibility(View.INVISIBLE);
        HB.setVisibility(View.INVISIBLE);

        DD.setVisibility(View.INVISIBLE);
        DU.setVisibility(View.INVISIBLE);

        Button playAgainButton = findViewById(R.id.playAgain);
        playAgainButton.setVisibility(View.GONE);

        if (!gameOver || winner == 3){
            if (firstMove == 1){
                player1turn = false;
                firstMove = 2;
                if (start.isTwoPlayer()) {
                    Toast toast = Toast.makeText(this, "A tie game swaps who goes first! " + player2 + ", your turn!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    gameOver = false;
                    Toast toast = Toast.makeText(this, "A tie game swaps who goes first! " + player2 + " is thinking!", Toast.LENGTH_SHORT);
                    toast.show();

                    //ai thinks and then goes
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            computerAI();
                            player1turn = true;
                        }
                    }, 2000);
                }
            }
            else {
                player1turn = true;
                firstMove = 1;
                Toast toast = Toast.makeText(this, "A tie game swaps who goes first! " + player1 + ", your turn!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else if (winner == 1){
            player1turn = true;
            firstMove = 1;
            Toast toast = Toast.makeText(this, "Winner goes first! " + player1 + ", your turn!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (winner == 2){
            player1turn = false;
            firstMove = 2;
            if (start.isTwoPlayer()) {
                Toast toast = Toast.makeText(this, "Winner goes first! " + player2 + " your turn!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                gameOver = false;
                Toast toast = Toast.makeText(this, "Winner goes first! " + player2 + " is thinking!", Toast.LENGTH_SHORT);
                toast.show();

                //ai thinks and then goes
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        computerAI();
                        player1turn = true;
                    }
                }, 2000);
            }
        }

        gameOver = false;
    }

    public void playAgainButton( View v){
        reset();
    }
}
