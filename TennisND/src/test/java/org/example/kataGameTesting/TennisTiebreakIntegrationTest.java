package org.example.kataGameTesting;

import org.junit.jupiter.api.Test;
import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.example.kataGame.TennisTiebreak;

import static org.junit.jupiter.api.Assertions.*;

public class TennisTiebreakIntegrationTest {

    @Test
    void Player1WinsTiebreak() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(7, 5);

        set.setTiebreak(tiebreak);
        assertTrue(tiebreak.isFinished());
        assertEquals("Tiebreak won by Player 1", tiebreak.getScore());
        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void Player2WinsTiebreak() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(5, 7);

        set.setTiebreak(tiebreak);
        assertTrue(tiebreak.isFinished());
        assertEquals("Tiebreak won by Player 2", tiebreak.getScore());
        assertEquals("Set won by Player 2", set.getScore());
    }

    @Test
    void TiebreakNotFinishedDoesNotEndSet() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(6, 6); // not finished
        set.setTiebreak(tiebreak);

        assertFalse(tiebreak.isFinished());
        assertEquals("6-6", tiebreak.getScore());
        assertEquals("6-6", set.getScore());
    }

    @Test
    void TiebreakAlreadyFinished() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(8, 6);
        assertTrue(tiebreak.isFinished());
        set.setTiebreak(tiebreak);

        assertEquals("Tiebreak won by Player 1", tiebreak.getScore());
        assertEquals("Set won by Player 1", set.getScore());
    }
}