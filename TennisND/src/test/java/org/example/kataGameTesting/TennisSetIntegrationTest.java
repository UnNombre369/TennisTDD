package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisSetIntegrationTest {

    @Test
    void testPlayer1WinsSetSixToZero() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.gamePoint(4, 0);
        }

        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testPlayer2WinsSetZeroToSix() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.gamePoint(0, 4);
        }

        assertEquals("Set won by Player 2", set.getScore());
    }

    @Test
    void testSetContinuesAt5to5() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 5, 5);
        assertEquals("5-5", set.getScore());
    }

    @Test
    void testPlayer1WinsSetSevenToFive() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 5, 5);

        set.gamePoint(4, 0);
        assertEquals("6-5", set.getScore());

        set.gamePoint(4, 0);
        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testSetGoesToSixSixAndPlayer1ThenWinsByTwo() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.gamePoint(4, 0);
            set.gamePoint(0, 4);
        }

        assertEquals("6-6", set.getScore());

        set.gamePoint(4, 0);
        assertEquals("7-6", set.getScore());
        set.gamePoint(4, 0);
        assertEquals("Set won by Player 1", set.getScore());
    }
}