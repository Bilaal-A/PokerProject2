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

    public String getId() {
        return id;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getFace() {
        return face;
    }

    public String getSuitIcon() {
        return suitIcon;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setSuitIcon(String suitIcon) {
        this.suitIcon = suitIcon;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.suitIcon + " " + this.face + " of " + this.suit + " " + this.suitIcon;
    }
}
