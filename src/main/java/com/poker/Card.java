package com.poker;

public class Card {
    private int priority;
    private String suit;
    private String suitIcon;
    private String face;
    private String id;

    public Card(int priority, String suit) {
        this.priority = priority;
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
        if(priority >= 2 && priority <= 10) {
            face = "" + priority;
        }
        else if(priority == 11) {
            face = "Jack";
        }
        else if(priority == 12) {
            face = "Queen";
        }
        else if(priority == 13) {
            face = "King";
        }
        else if(priority == 14) {
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

    public int getPriority() {
        return priority;
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

    public String getFace(int priority) {
        if(priority <=10) {
            return "" + priority;
        }
        else if(priority == 11) {
            return "Jack";
        }
        else if(priority == 12) {
            return "Queen";
        }
        else if(priority == 13) {
            return "King";
        }
        else if(priority == 14) {
            return "Ace";
        }
        else {
            return "ERROR In getFace Method";
        }
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return this.suitIcon + " " + this.face + " of " + this.suit + " " + this.suitIcon;
    }
}
