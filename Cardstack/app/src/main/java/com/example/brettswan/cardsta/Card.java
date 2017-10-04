package com.example.brettswan.cardsta;

public class Card {

    private int value;
    private Suit suit;


    public Card(int num, Suit suit){
        this.value = num;
        this.suit = suit;
    }

    public int returnValue(){
        return value;
    }

    public Suit returnSuit(){
        return suit;
    }

}

