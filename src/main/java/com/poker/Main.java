package com.poker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Player> players;

    public static void main(String[] args) {
        Deck deck = new Deck();
        players = new ArrayList<>();
        adminCreatePlayers();
        Board board = new Board(players);
        deck.dealCards(players, board);
        for(Player p : players) {
            p.setBoard(board);
        }
        Player player1 = players.get(0);
        System.out.println(player1);

        System.out.println(board);
    }

//    public static void createPlayers() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Your Name:");
//        System.out.print("=> ");
//        String userName = scanner.nextLine();
//        System.out.println("Buy Chips:");
//        System.out.print("(1000 Recommended)=> ");
//        int userMoney = scanner.nextInt();
//        players.add(new Player(userName, -2, userMoney));
//        System.out.println("Enter Number Of Opponents:");
//        System.out.print("(2 Minimum)=> ");
//        int numOpponents = scanner.nextInt();
//        if(numOpponents < 2) {
//            players.add(new Player("John", 50, userMoney));
//            players.add(new Player("Jane", 50, userMoney));
//        }
//        else {
//            for(int i = 0; i<numOpponents; i++) {
//                players.add(new Player(""));
//            }
//        }
//    }

    public static void adminCreatePlayers() {
        players.add(new Player("Bilaal"));
        players.add(new Player("Cooper"));
        players.add(new Player("Prokopiy"));
        players.add(new Player("James"));
    }
}