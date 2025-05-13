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

    public void dealCards(ArrayList<Player> players, Board board) {
        for(Player p : players) {
            p.setPocket1(deck.remove(randomDeckIndex()));
            p.setPocket2(deck.remove(randomDeckIndex()));
        }
        board.setFlop1(deck.remove(randomDeckIndex()));
        board.setFlop2(deck.remove(randomDeckIndex()));
        board.setFlop3(deck.remove(randomDeckIndex()));
        board.setTurn(deck.remove(randomDeckIndex()));
        board.setRiver(deck.remove(randomDeckIndex()));
    }

    private int randomDeckIndex() {
        return (int) (Math.random() * deck.size());
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
