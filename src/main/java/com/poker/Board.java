package com.poker;

public class Board {
    private Card flop1;
    private Card flop2;
    private Card flop3;
    private Card turn;
    private Card river;

    public Board() {

    }

    public Card getFlop1() {
        return flop1;
    }

    public void setFlop1(Card flop1) {
        this.flop1 = flop1;
    }

    public Card getFlop2() {
        return flop2;
    }

    public void setFlop2(Card flop2) {
        this.flop2 = flop2;
    }

    public Card getFlop3() {
        return flop3;
    }

    public void setFlop3(Card flop3) {
        this.flop3 = flop3;
    }

    public Card getTurn() {
        return turn;
    }

    public void setTurn(Card turn) {
        this.turn = turn;
    }

    public Card getRiver() {
        return river;
    }

    public void setRiver(Card river) {
        this.river = river;
    }
}
