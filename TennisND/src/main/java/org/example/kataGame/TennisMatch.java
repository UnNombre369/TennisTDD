package org.example.kataGame;

public class TennisMatch {
    private TennisSet currentSet;
    private int setsPlayer1 = 0;
    private int setsPlayer2 = 0;
    private boolean finished = false;

    public TennisMatch(TennisSet set) {
        this.currentSet = set;
    }

    public TennisMatch(TennisSet set, int setsPlayer1, int setsPlayer2) {
        this.currentSet = set;
        this.setsPlayer1 = setsPlayer1;
        this.setsPlayer2 = setsPlayer2;
        this.finished = (setsPlayer1 == 3 || setsPlayer2 == 3);
    }

    public void finishSet(String setWinner) {
        if (finished) return;

        if ("Set won by Player 1".equals(setWinner)) {
            setsPlayer1++;
        } else if ("Set won by Player 2".equals(setWinner)) {
            setsPlayer2++;
        }

        if (setsPlayer1 == 3 || setsPlayer2 == 3) {
            finished = true;
            currentSet = null;
        } else {
            this.currentSet = new TennisSet(new TennisGame());
        }
    }

    public String getMatchScore() {
        if (finished) {
            if (setsPlayer1>setsPlayer2){
                return "Player 1 wins";
            } else {
                return "Player 2 wins";
            }
        }
        String current = currentSet.getScore();
        return "Sets: " + setsPlayer1 + "-" + setsPlayer2 + ", Current set: " + current;
    }

    public boolean isMatchOver() {
        return finished;
    }

    public int getSetsPlayer1() {
        return setsPlayer1;
    }

    public int getSetsPlayer2() {
        return setsPlayer2;
    }
}
