package com.poker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Adam"));
        players.add(new Player("Bill"));
        players.add(new Player("Cameron"));
        Board board = new Board(players);
        Deck deck = new Deck();

//       runAGame(deck, board, );
    }

    public static void runAGame(Deck deck, Board board, ArrayList<Player> players) {
        deck.resetDeck();
        board.newGame();
        deck.dealCards(players, board);
        for(Player p:players) {
            System.out.println(p);
            System.out.println();
        }
        while(board.getStage() <= 3) {
            System.out.println(board);
            board.updateStage();
            System.out.println();
        }
        for(Player p:players) {
            System.out.println(p);
            System.out.println();
        }
    }

}