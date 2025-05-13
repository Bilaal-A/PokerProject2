package com.poker;

public class Card {
    private int value;
    private String suit;
    private String suitIcon;
    private String face;
    private String id;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        if(suit.equals("Clubs")) {
            suitIcon = "☘️️";

        }
        else if(suit.equals("Spades")) {
            suitIcon = "♠️";
        }
        else if(suit.equals("Diamonds")) {
            suitIcon = "🔷️";
        }
        else if(suit.equals("Hearts")) {
            suitIcon = "♥️️";
        }
        else {
            suitIcon = "⚠️";
        }
        if(value >= 2 && value <= 10) {
            face = "" + value;
        }
        else if(value == 11) {
            face = "Jack";
        }
        else if(value == 12) {
            face = "Queen";
        }
        else if(value == 13) {
            face = "King";
        }
        else if(value == 14) {
            face = "Ace";
        }
        else {
            face = "⚠️";
        }
        this.id = this.face.substring(0,1) + this.suit.substring(0,1);
    }

    @Override
    public String toString() {
        return this.face + " of " + this.suit + this.suitIcon;
    }
}
