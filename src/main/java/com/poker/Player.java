package com.poker;

public class Player {
    private Card pocket1;
    private Card pocket2;
    private String name;
    private double riskPercent;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, double riskPercent) {
        this.name = name;
        this.riskPercent = riskPercent;
    }

    public void setPocket1(Card pocket1) {
        this.pocket1 = pocket1;
    }

    public void setPocket2(Card pocket2) {
        this.pocket2 = pocket2;
    }

    public void printPlayerCards() {
        System.out.println(name + " has the " + pocket1 + " and the " + pocket2);
    }
}
