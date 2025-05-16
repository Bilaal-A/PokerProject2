package com.poker;

import java.util.ArrayList;

public class Board {
    private Card flop1;
    private Card flop2;
    private Card flop3;
    private Card turn;
    private Card river;
    private int stage = 0;
    private int pot = 0;
    private int smallBlind;
    private int bigBlind;
    private ArrayList<Player> players;

    public Board(ArrayList<Player> players) {
        this.players = players;
        this.smallBlind = 10;
        this.bigBlind = 20;
        collectBlinds();
    }
    public Board(ArrayList<Player> players, int smallBlind) {
        this.players = players;
        this.smallBlind = smallBlind;
        this.bigBlind = 2*smallBlind;
        collectBlinds();
    }

    public Board(ArrayList<Player> players, int smallBlind, int bigBlind) {
        this.players = players;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        collectBlinds();
    }

    public int getStage() {
        return stage;
    }

    @Override
    public String toString() {
        if(stage == 0) {
            return "| HIDDEN | HIDDEN | HIDDEN | HIDDEN | HIDDEN |";
        }
        else if(stage == 1) {
            return " | " + flop1 + " | " + flop2 + " | " + flop3 + " | HIDDEN | HIDDEN";
        }
        else if(stage == 2) {
            return " | " + flop1 + " | " + flop2 + " | " + flop3 + " | " + turn + " | HIDDEN";
        }
        else if(stage == 3) {
            return " | " + flop1 + " | " + flop2 + " | " + flop3 + " | " + turn + " | " + river;
        }
        else {
            return "ERROR: Problem In Printing Board";
        }
    }

    public Card getFlop1() {
        return flop1;
    }

    public void setStage(int stage) {
        this.stage = stage;
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

    public void updateStage() {
        stage++;
    }

    public void nextDealer() {
        players.add(players.remove(0));
    }

    private void collectBlinds() {
        players.get(1).withdrawal(this.smallBlind);
        players.get(2).withdrawal(this.bigBlind);
        this.pot += smallBlind + bigBlind;
    }

    public int getPot() {
        return pot;
    }

    private void setPot(int pot) {
        this.pot = pot;
    }

    public void increasePot(int deposit) {
        this.pot += deposit;
    }

    public void newGame() {
        resetBoard();
        nextDealer();
    }

    private void resetBoard() {
        pot = 0;
        flop1 = null;
        flop2 = null;
        flop3 = null;
        turn = null;
        river = null;
        stage = 0;
    }

    public void declareWinner(){
        double winningHand = Integer.MIN_VALUE;
        ArrayList<Player> winningPlayers = new ArrayList<>();
        for(Player p: players) {
            if(p.getBestHandPriority() > winningHand) {
                winningHand = p.getBestHandPriority();
                winningPlayers.add(p);
            }
        }
        for(int i = 0; i<winningPlayers.size(); i++) {
            if(winningPlayers.get(i).getBestHandPriority() < winningHand) {
                winningPlayers.remove(winningPlayers.get(i));
                i--;
            }
        }
        if(winningPlayers.size() == 1) {
            Player winner = winningPlayers.get(0);
            System.out.println(winner.getName() + " Wins!");
            winner.addMoney(pot);
            setPot(0);
        }

    }
}
