package org.example.kataGame;

public class TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;

    public String transformScoreToText(int playerOneScore, int playerTwoScore) {
        StringBuilder res = new StringBuilder ();
        if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return endGame(playerOneScore, playerTwoScore);
        }
        if (playerOneScore == 3 && playerTwoScore == 3) return "Deuce";
        res.append(translateScore(playerOneScore));
        res.append("-");
        res.append(translateScore(playerTwoScore));
        return res.toString();
    }
    private String translateScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("Invalid score: " + score);
        };
    }
    private String endGame(int score1, int score2){
        if (score1 == score2) return "Deuce";
        int diff = Math.abs(score1 - score2);
        StringBuilder res = new StringBuilder();
        if (diff >= 2) {
            res.append("Win for ");
        } else {
            res.append("Advantage ");
        }
        if (score1<score2){
            res.append("Player 2");
        } else {
            res.append("Player 1");
        }
        return res.toString();
    }
}
