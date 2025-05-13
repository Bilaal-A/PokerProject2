package com.poker;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private Card pocket1;
    private Card pocket2;
    private String name;
    private double riskPercent;

    private int money;
    private Board board;
    private String bestHand;
    private double bestHandPriority;

    public Player(String name) {
        this.name = name;
        this.money = 1000;
    }

    public Player(String name, double riskPercent, int money) {
        this.name = name;
        this.riskPercent = riskPercent;
        this.money = money;
    }

    public Player(String name, double riskPercent) {
        this.name = name;
        this.riskPercent = riskPercent;
        this.money = 1000;
    }

    @Override
    public String toString() {
        return name.toUpperCase() + "'S STATS\n" + pocket1 + "\n" + pocket2 + "\n";
    }

    public void setPocket1(Card pocket1) {
        this.pocket1 = pocket1;
    }

    public void setPocket2(Card pocket2) {
        this.pocket2 = pocket2;
    }

    public void printPlayerCards() {
        System.out.println(name.toUpperCase() + "'S CARDS:");
        System.out.println(pocket1);
        System.out.println(pocket2);
    }

    public int getMoney() {
        return money;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void withdrawal(int withdrawal) {
        this.money -= withdrawal;
    }

    public String bestHand() {
        bestHand = "High Card";
        ArrayList<Card> boardNMe= new ArrayList<>();
        boardNMe.add(pocket1);
        boardNMe.add(pocket2);
        if(board.getStage() >= 1) {
            boardNMe.add(board.getFlop1());
            boardNMe.add(board.getFlop2());
            boardNMe.add(board.getFlop3());
            if(board.getStage() >= 2) {
                boardNMe.add(board.getTurn());
                if(board.getStage() >= 3) {
                    boardNMe.add(board.getRiver());
                }
            }
        }
        HashMap<Integer, Integer> dupeCounter = new HashMap<>();


        int highestCardValue = Integer.MIN_VALUE;
        int clubCounter = 0;
        int diamondCounter = 0;
        int spadeCounter = 0;
        int heartCounter = 0;
        for(Card c : boardNMe) {
            if(c.getValue() > highestCardValue) {
                highestCardValue = c.getValue();
            }
            else {}
            if(c.getSuit().equals("Clubs")) {
                clubCounter++;
            }
            else if(c.getSuit().equals("Spades")) {
                spadeCounter++;
            }
            else if(c.getSuit().equals("Diamonds")) {
                diamondCounter++;
            }
            else if(c.getSuit().equals("Hearts")) {
                heartCounter++;
            }
            else {
                System.out.println("ERROR: Problem In bestHand Method");
            }
            if(dupeCounter.containsKey(c.getValue())) {
                dupeCounter.get(c.getValue())
            }

        }


    }


}
