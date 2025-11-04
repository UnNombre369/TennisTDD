package org.example.kataGame;

public class TennisTiebreak {
    private int player1Points;
    private int player2Points;

    public TennisTiebreak(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
    }

    public boolean isFinished() {
        int diff = Math.abs(player1Points - player2Points);
        return (player1Points >= 7 || player2Points >= 7) && diff >= 2;
    }

    public String getWinner() {
        if (!isFinished()) return null;
        if (player1Points > player2Points) {
            return "Player 1";
        } else {
            return "Player 2";
        }
    }

    public String getScore() {
        if (isFinished()) {
            return "Tiebreak won by " + getWinner();
        }
        return player1Points + "-" + player2Points;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }
}