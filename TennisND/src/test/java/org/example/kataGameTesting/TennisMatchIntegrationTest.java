package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.example.kataGame.TennisMatch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisMatchIntegrationTest {

    @Test
    void testPlayer1WinsMatch() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        for (int i = 0; i < 3; i++) {
            match.finishSet("Set won by Player 1");
        }

        assertTrue(match.isMatchOver());
        assertEquals("Player 1 wins", match.getMatchScore());
    }

    @Test
    void testMatchInProgress() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 5, 3);
        TennisMatch match = new TennisMatch(set, 1, 0);

        assertEquals("Sets: 1-0, Current set: 5-3", match.getMatchScore());
        assertFalse(match.isMatchOver());
    }

    @Test
    void testPlayer2WinsMatch() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        for (int i = 0; i < 3; i++) {
            match.finishSet("Set won by Player 2");
        }

        assertEquals("Player 2 wins", match.getMatchScore());
    }
}