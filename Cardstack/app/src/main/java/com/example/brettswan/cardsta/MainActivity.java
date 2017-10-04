package com.example.brettswan.cardsta;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Stack<Card> cardStack = new Stack<>();

    private ImageView topLeftSuit;
    private ImageView botRightSuite;
    private ImageView centerSuite;

    private TextView topLeftText;
    private TextView botRightText;

    int numTaps = 0;

    public void fillStack(){

        for (int i = 1; i <= 13; ++i){
            cardStack.push(new Card(i, Suit.HEART));
            cardStack.push(new Card(i, Suit.CLUBS));
            cardStack.push(new Card(i, Suit.DIAMOND));
            cardStack.push(new Card(i, Suit.SPADE));
        }
    }

    public void tapCard(View view) {
        numTaps++;

        if (!cardStack.isEmpty()) {

            int cardVal = cardStack.peek().returnValue();
            Suit cardSuit = cardStack.peek().returnSuit();
            if (cardVal == 1) {
                topLeftText.setText("A");
                botRightText.setText("A");
            }

            else if (cardVal == 11) {
                topLeftText.setText("J");
                botRightText.setText("J");
            }

            else if (cardVal == 12) {
                topLeftText.setText("Q");
                botRightText.setText("Q");
            }

            else if (cardVal == 13) {
                topLeftText.setText("K");
                botRightText.setText("K");
            }

            else {
                topLeftText.setText(String.valueOf(cardVal));
                botRightText.setText(String.valueOf(cardVal));
            }

            if (cardSuit == Suit.HEART) {
                topLeftSuit.setImageResource(R.mipmap.heartIcon);
                centerSuite.setImageResource(R.mipmap.heartIcon);
                botRightSuite.setImageResource(R.mipmap.heartIcon);

                topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
                botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
            }

            else if (cardSuit == Suit.DIAMOND) {
                topLeftSuit.setImageResource(R.mipmap.diamondIcon);
                centerSuite.setImageResource(R.mipmap.diamondIcon);
                botRightSuite.setImageResource(R.mipmap.diamondIcon);

                topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
                botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
            }

            else if (cardSuit == Suit.SPADE) {
                topLeftSuit.setImageResource(R.mipmap.spadeIcon);
                centerSuite.setImageResource(R.mipmap.spadeIcon);
                botRightSuite.setImageResource(R.mipmap.spadeIcon);

                topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
                botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
            }

            else if (cardSuit == Suit.CLUBS) {
                topLeftSuit.setImageResource(R.mipmap.clubIcon);
                centerSuite.setImageResource(R.mipmap.clubIcon);
                botRightSuite.setImageResource(R.mipmap.clubIcon);

                topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
                botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
            }
            cardStack.pop();
        }
        else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeftSuit = (ImageView) findViewById(R.id.iv_top_left_suit);
        botRightSuite = (ImageView) findViewById(R.id.iv_bot_right_suit);
        centerSuite = (ImageView) findViewById(R.id.iv_center_suit);

        topLeftText = (TextView) findViewById(R.id.tv_top_left_num);
        botRightText = (TextView) findViewById(R.id.tv_bot_right_num);


        fillStack();
        Collections.shuffle(cardStack);

        int cardVal = cardStack.peek().returnValue();
        Suit cardSuit = cardStack.peek().returnSuit();

        //Check for royal cards (above 10 or 1 for Ace)
        if (cardVal == 1){
            topLeftText.setText("A");
            botRightText.setText("A");
        }

        else if (cardVal == 11){
            topLeftText.setText("J");
            botRightText.setText("J");
        }

        else if (cardVal == 12){
            topLeftText.setText("Q");
            botRightText.setText("Q");
        }

        else if (cardVal == 13){
            topLeftText.setText("K");
            botRightText.setText("K");
        }

        else{
            topLeftText.setText(String.valueOf(cardVal));
            botRightText.setText(String.valueOf(cardVal));
        }

        if (cardSuit == Suit.HEART){
            topLeftSuit.setImageResource(R.mipmap.heartIcon);
            centerSuite.setImageResource(R.mipmap.heartIcon);
            botRightSuite.setImageResource(R.mipmap.heartIcon);
            topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
        }

        else if (cardSuit == Suit.DIAMOND){
            topLeftSuit.setImageResource(R.mipmap.diamondIcon);
            centerSuite.setImageResource(R.mipmap.diamondIcon);
            botRightSuite.setImageResource(R.mipmap.diamondIcon);
            topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
        }

        else if (cardSuit == Suit.SPADE){
            topLeftSuit.setImageResource(R.mipmap.spadeIcon);
            centerSuite.setImageResource(R.mipmap.spadeIcon);
            botRightSuite.setImageResource(R.mipmap.spadeIcon);
            topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
        }

        else if (cardSuit == Suit.CLUBS){
            topLeftSuit.setImageResource(R.mipmap.clubIcon);
            centerSuite.setImageResource(R.mipmap.clubIcon);
            botRightSuite.setImageResource(R.mipmap.clubIcon);
            topLeftText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            botRightText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
        }


    }

}
