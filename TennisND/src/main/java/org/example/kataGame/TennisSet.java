package org.example.kataGame;

public class TennisSet {
    private final TennisGame game;
    private int player1Games = 0;
    private int player2Games = 0;

    public TennisSet(TennisGame game) {
        this.game = game;
    }

    public TennisSet(TennisGame game, int player1Games, int player2Games) {
        this.game = game;
        this.player1Games = player1Games;
        this.player2Games = player2Games;
    }

    public String getScore() {
        int diff = Math.abs(player1Games - player2Games);
        if ((player1Games >= 6 || player2Games >= 6) && diff >= 2) {
            if (player1Games < player2Games) {
                return "Set won by Player 2";
            } else {
                return "Set won by Player 1";
            }
        }
        return player1Games + "-" + player2Games;
    }

    public void gamePoint(int player1Points, int player2Points) {
        String result = game.transformScoreToText(player1Points, player2Points);
        if (result.equals("Win for Player 1")) {
            player1Games++;
        } else if (result.equals("Win for Player 2")) {
            player2Games++;
        }
    }

    public void reset() {
        player1Games = 0;
        player2Games = 0;
    }
}