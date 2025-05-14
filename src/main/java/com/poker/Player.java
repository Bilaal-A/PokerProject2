package com.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private Card pocket1;
    private Card pocket2;
    private String name;
    private double riskPercent;

    private int money;
    private Board board;
    private String bestHand;
    private double bestHandPriority;
    private Deck deck;

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

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    private int findHighestCard(ArrayList<Card> cards) {
        int highestCard = Integer.MIN_VALUE;
        for (Card card : cards) {
            if (card.getPriority() > highestCard) {
                highestCard = card.getPriority();
            }
        }
        return highestCard;
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

    @Override
    public String toString() {
        return name.toUpperCase() + "'S STATS\n" + pocket1 + "\n" + pocket2 + "\n" + "Best Hand: " + bestHand();
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
        HashMap<Integer, Integer> faceAnalyzer = new HashMap<>();
        for (int i = 0; i < boardNMe.size(); i++) {
            Integer num = boardNMe.get(i).getPriority();
            faceAnalyzer.put(num, faceAnalyzer.getOrDefault(num, 0) + 1);
        }
        int maxKey = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int tripsMax = Integer.MIN_VALUE;
        int quadType = Integer.MIN_VALUE;
        boolean onePair = false;
        boolean trips = false;
        int heightOfStraight = 0;
        int straightCounter = 0;
        boolean lockFirst = false;
        int clubCounter = 0;
        int diamondCounter = 0;
        int spadeCounter = 0;
        int heartCounter = 0;
        String dominantSuit = "None";
        int maxFlushCard = Integer.MIN_VALUE;
        int straightFlushCount = 0;
        int heightOfSF = -2;
        int royalFlushCount = 0;

        for (int i = 0; i < boardNMe.size(); i++) {
            if (boardNMe.get(i).getSuit().contains("Clubs")) {
                clubCounter++;
            }
            if (boardNMe.get(i).getSuit().contains("Spades")) {
                spadeCounter++;
            }
            if (boardNMe.get(i).getSuit().contains("Diamonds")) {
                diamondCounter++;
            }
            if (boardNMe.get(i).getSuit().contains("Hearts")) {
                heartCounter++;
            }
        }

        if (clubCounter > 4) {
            dominantSuit = "Clubs";
        }
        if (spadeCounter > 4) {
            dominantSuit = "Spades";
        }
        if (diamondCounter > 4) {
            dominantSuit = "Diamonds";
        }
        if (heartCounter > 4) {
            dominantSuit = "Hearts";
        }

        for (int i = 0; i < boardNMe.size(); i++) {
            if (boardNMe.get(i).getSuit().contains(dominantSuit) && boardNMe.get(i).getPriority() > 9) {
                royalFlushCount++;
            }
            if (boardNMe.get(i).getSuit().contains(dominantSuit) && !lockFirst) {
                heightOfSF = boardNMe.get(i).getPriority();
                lockFirst = true;
            }
            if (boardNMe.get(i).getSuit().contains(dominantSuit) && boardNMe.get(i).getPriority() == heightOfSF) {
                heightOfSF++;
                straightFlushCount++;
            }
            if (boardNMe.get(i).getSuit().contains(dominantSuit) && boardNMe.get(i).getPriority() > maxFlushCard) {
                maxFlushCard = boardNMe.get(i).getPriority();
            }
        }

        lockFirst = false;

        List<Integer> sortedList = faceAnalyzer.keySet().stream().sorted((a, b) -> {
            if (a.intValue() == b.intValue()) return 0;
            else if (a > b) return -1;
            else return 1;
        }).collect(Collectors.toList());

        int maxValue = findHighestCard(boardNMe);
        int hheight = 0;
        int previous = 0;

        for (Iterator<Integer> iterator = sortedList.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (maxValue == 0) {
                maxValue = next;
                hheight = 1;
                previous = next;
            } else {
                if (previous - next <= 1) {
                    hheight = hheight + 1;
                    previous = next;
                } else {
                    maxValue = next;
                    previous = next;
                    hheight = 1;
                }
            }
            if (hheight == 5) {
                break;
            }
        }

        for (int key : faceAnalyzer.keySet()) {
            if (!lockFirst) {
                heightOfStraight = key;
                lockFirst = true;
            } else {
                if (key == heightOfStraight) {
                    straightCounter++;
                    heightOfStraight++;
                }


            }
            if (key > maxKey) {
                maxKey = key;
            }
            if (faceAnalyzer.get(key) == 2) {
                if (key > max1) {
                    max2 = max1;
                    max1 = key;
                } else if (key > max2) {
                    max2 = key;
                }
            }
            if (faceAnalyzer.get(key) == 3) {
                if (key > tripsMax) {
                    tripsMax = key;
                }
            }
            if (faceAnalyzer.get(key) == 4) {
                quadType = key;
            }
        }



        String bestHandStr = "HIGH CARD (" +  getFace(maxKey) + ")";
        this.bestHandPriority = maxKey;

        if (max1 != Integer.MIN_VALUE) {
            bestHandStr = "ONE-PAIR (" + getFace(max1) + "s)";
            onePair = true;
            this.bestHandPriority = 15 + ((double) max1 / 100);
        }
        if (max2 != Integer.MIN_VALUE && max1 != Integer.MIN_VALUE) {
            bestHandStr = "TWO-PAIR (" + getFace(max2) + "s & " + getFace(max1) + "s)";
            this.bestHandPriority = 16 + ((double) max1 / 100);
        }
        if (tripsMax != Integer.MIN_VALUE) {
            bestHandStr = "THREE OF A KIND (" + getFace(tripsMax) + "s)";
            trips = true;
            this.bestHandPriority = 17 + ((double) tripsMax / 100);
        }
        if (hheight >= 5) {
            bestHandStr = "STRAIGHT (" + getFace(maxValue) + "-High)";
//            WARNING: Low Ace Straight Has Not Been Implemented
            this.bestHandPriority = 18 + ((double) maxValue / 100);
        }
        if (maxFlushCard != Integer.MIN_VALUE) {
            bestHandStr = "FLUSH (" + dominantSuit + ", " + getFace(maxFlushCard) + "-High)";
            this.bestHandPriority = 19 + ((double) maxFlushCard / 100);
        }
        if (onePair && trips) {
            bestHandStr = "FULL HOUSE (three " + getFace(tripsMax) + "s and two " + getFace(max1) + "s)";
            this.bestHandPriority = 20 + ((double) tripsMax / 100) + ((double) max1 / 10000);
        }
        if (quadType != Integer.MIN_VALUE) {
            bestHandStr = "FOUR OF A KIND (" + getFace(quadType) + "s)";
            this.bestHandPriority = 21 + ((double) quadType / 100);
        }
        if (straightFlushCount == 5) {
            bestHandStr = "STRAIGHT FLUSH (" + getFace(heightOfSF) + "-High)";
            this.bestHandPriority = 22 + ((double) heightOfSF / 100);
        }
        if (royalFlushCount == 5) {
            bestHandStr = "ROYAL FLUSH (" + dominantSuit + ")";
            this.bestHandPriority = 23;
        }
        return bestHandStr;

    }

    public double getBestHandPriority() {
        return bestHandPriority;
    }
}
