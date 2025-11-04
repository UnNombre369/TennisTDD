package org.example.kataGame;

public class TennisSet {
    private final TennisGame game;
    private int player1Games = 0;
    private int player2Games = 0;
    private boolean finished = false;
    private int winner = 0;

    public TennisSet(TennisGame game) {
        this.game = game;
        checkFinishByGames();
    }

    public TennisSet(TennisGame game, int player1Games, int player2Games) {
        this.game = game;
        this.player1Games = player1Games;
        this.player2Games = player2Games;
        checkFinishByGames();
    }

    public String getScore() {
        if (finished) {
            return winner == 1 ? "Set won by Player 1" : "Set won by Player 2";
        }
        return player1Games + "-" + player2Games;
    }

    public void finishGame(int player1Points, int player2Points) {
        String result = game.transformScoreToText(player1Points, player2Points);
        if (result.equals("Win for Player 1")) {
            player1Games++;
            checkFinishByGames();
        } else if (result.equals("Win for Player 2")) {
            player2Games++;
            checkFinishByGames();
        }
    }

    private void checkFinishByGames() {
        int diff = Math.abs(player1Games - player2Games);
        if ((player1Games >= 6 || player2Games >= 6) && diff >= 2) {
            finished = true;
            winner = player1Games > player2Games ? 1 : 2;
        }
    }

    public void setTiebreak(TennisTiebreak tiebreak) {
        if (player1Games != 6 || player2Games != 6) return;
        if (tiebreak != null && tiebreak.isFinished()) {
            if (tiebreak.getPlayer1Points() > tiebreak.getPlayer2Points()) {
                player1Games++; // from 6 to 7
                winner = 1;
            } else {
                player2Games++;
                winner = 2;
            }
            finished = true;
        }
    }
    public boolean needsTiebreak() {
        return player1Games == 6 && player2Games == 6;
    }

    public void reset() {
        player1Games = 0;
        player2Games = 0;
        finished = false;
        winner = 0;
    }
}