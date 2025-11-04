package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.example.kataGame.TennisMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisMatchIntegrationTest {

    @Test
    void Player1WinsMatch() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        for (int i = 0; i < 3; i++) {
            match.finishSet("Set won by Player 1");
        }

        assertTrue(match.isMatchOver());
        assertEquals("Player 1 wins", match.getMatchScore());
        assertEquals(3, match.getSetsPlayer1());
        assertEquals(0, match.getSetsPlayer2());
    }

    @Test
    void Player2WinsMatch() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        for (int i = 0; i < 3; i++) {
            match.finishSet("Set won by Player 2");
        }

        assertTrue(match.isMatchOver());
        assertEquals("Player 2 wins", match.getMatchScore());
        assertEquals(0, match.getSetsPlayer1());
        assertEquals(3, match.getSetsPlayer2());
    }

    @Test
    void MatchInProgressAfterTwoSets() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        match.finishSet("Set won by Player 1");
        match.finishSet("Set won by Player 2");

        assertFalse(match.isMatchOver());
        assertEquals(1, match.getSetsPlayer1());
        assertEquals(1, match.getSetsPlayer2());
    }

    @Test
    void MatchScoreReturnsCurrentSetScore() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 5, 3);
        TennisMatch match = new TennisMatch(set, 1, 0);

        assertEquals("Sets: 1-0, Current set: 5-3", match.getMatchScore());
    }

    @Test
    void MatchContinuesAfterSetFinishes() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);
        TennisMatch match = new TennisMatch(set);

        match.finishSet("Set won by Player 1");

        assertEquals(1, match.getSetsPlayer1());
    }
}
