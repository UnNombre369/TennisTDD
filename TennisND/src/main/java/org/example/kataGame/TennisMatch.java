package org.example.kataGame;

public class TennisMatch {
    private TennisSet currentSet;
    private int setsPlayer1 = 0;
    private int setsPlayer2 = 0;

    public TennisMatch(TennisSet set) {
        this.currentSet = set;
    }

    public TennisMatch(TennisSet set, int setsPlayer1, int setsPlayer2) {
        this.currentSet = set;
        this.setsPlayer1 = setsPlayer1;
        this.setsPlayer2 = setsPlayer2;
    }

    public String getMatchScore() {
        if (isMatchOver()) {
            return setsPlayer1 > setsPlayer2 ? "Player 1 wins" : "Player 2 wins";
        }
        String current = (currentSet != null) ? currentSet.getScore() : "0-0";
        return "Sets: " + setsPlayer1 + "-" + setsPlayer2 + ", Current set: " + current;
    }

    public boolean isMatchOver() {
        return setsPlayer1 == 3 || setsPlayer2 == 3;
    }

    public void finishSet(String setWinner) {
        if (setWinner.equals("Set won by Player 1")) {
            setsPlayer1++;
        } else if (setWinner.equals("Set won by Player 2")) {
            setsPlayer2++;
        }

        if (!isMatchOver()) {
            currentSet = new TennisSet(new TennisGame());
        }
    }
}