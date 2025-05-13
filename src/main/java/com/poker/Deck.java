package com.poker;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private final ArrayList<Card> fullDeck;

    public Deck() {
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 2; i<14; i++) {
            deck.add(new Card(i, "Clubs"));
            deck.add(new Card(i, "Spades"));
            deck.add(new Card(i, "Diamonds"));
            deck.add(new Card(i, "Hearts"));
        }
        this.deck = deck;
        this.fullDeck = new ArrayList<Card>(deck);
    }

    @Override
    public String toString() {
        String output = "";
        for(Card card : deck) {
            output += card + "\n";
        }
        return output;
    }
}
