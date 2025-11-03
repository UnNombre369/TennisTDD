package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisSetIntegrationTest {

    @Test
    void testPlayer1WinsSet() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.gamePoint(4, 0);
        }

        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testSetContinuesAt5to5() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 5, 5);
        assertEquals("5-5", set.getScore());
    }

    @Test
    void testPlayer2WinsSet() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.gamePoint(0, 4);
        }

        assertEquals("Set won by Player 2", set.getScore());
    }
}