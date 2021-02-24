package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0 yellow, 1 red, 2 empty, tapped counter is index,
    int activePlayer= 0;
    boolean winstatus = true;



    int []gameState= {2,2,2,2,2,2,2,2,2};
    int [][]winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
     public void dropin(View view) {
            int flag=0;
         ImageView counter = (ImageView) view;
         counter.setTranslationY(-1000);
         int tappedCounter = Integer.parseInt(counter.getTag().toString());
         if (gameState[tappedCounter] == 2 && winstatus) {
             gameState[tappedCounter] = activePlayer;

             if (activePlayer == 0) {


                 activePlayer = 1;

                 counter.setImageResource(R.drawable.yellow);
             } else {
                 activePlayer = 0;

                 counter.setImageResource(R.drawable.red1);
             }
             counter.animate().translationYBy(1000).setDuration(300);
             for (int[] winningPositions : winningPositions) {
                 if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                     //someone has won
                     // activePlayer is opposite now
                     winstatus = false;
                     String mes = "";
                     if (activePlayer == 1)
                         mes = "YELLOW HAS WON!!!";
                     else
                         mes = "RED HAS WON!!!";
                     Button button = (Button) findViewById(R.id.button);
                     TextView textView = (TextView) findViewById(R.id.textView);

                     textView.setText(mes);
                     button.setVisibility(View.VISIBLE);
                     textView.setVisibility(View.VISIBLE);
                     flag = 1;

                     break;
                 }
             }
             if (flag == 0) {
                 Log.i(" hello", " working");

                 boolean gameIsOver = true;
                 for (int counterState : gameState) {
                     if (counterState == 2) {
                         gameIsOver = false;
                     }
                 }
                 if (gameIsOver) {
                     TextView textView = (TextView) findViewById(R.id.textView);
                     Toast.makeText(this, "It's a draw!!!",Toast.LENGTH_SHORT).show();
                     textView.setText("Its a DRAW!!!");
                     Button button = (Button) findViewById(R.id.button);
                     button.setVisibility(View.VISIBLE);
                 }
             }


         }
     }





    public void playAgain(View view){


        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);

        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);

       // GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter= (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }


             activePlayer= 0;
             winstatus = true;
           for(int i=0;i<gameState.length;i++)
           {
               gameState[i] =2;
           }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}