package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.example.kataGame.TennisTiebreak;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisSetIntegrationTest {

    @Test
    void testPlayer1WinsSetSixToZero() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.finishGame(4, 0);
        }

        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testPlayer2WinsSetZeroToSix() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game);

        for (int i = 0; i < 6; i++) {
            set.finishGame(0, 4);
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

        set.finishGame(4, 0);
        assertEquals("6-5", set.getScore());

        set.finishGame(4, 0);
        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testSetGoesToTiebreakAndPlayer1WinsIt() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(7, 5);
        set.setTiebreak(tiebreak);

        assertEquals("Set won by Player 1", set.getScore());
    }

    @Test
    void testSetGoesToTiebreakAndPlayer2WinsIt() {
        TennisGame game = new TennisGame();
        TennisSet set = new TennisSet(game, 6, 6);

        TennisTiebreak tiebreak = new TennisTiebreak(5, 7);
        set.setTiebreak(tiebreak);

        assertEquals("Set won by Player 2", set.getScore());
    }
}
