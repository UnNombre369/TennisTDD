package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {
    static Stream<TestCase> scores() {
        return Stream.of(
                new TestCase(0, 0, "Love-Love"),
                new TestCase(1, 0, "Fifteen-Love"),
                new TestCase(0, 1, "Love-Fifteen"),
                new TestCase(1, 1, "Fifteen-Fifteen"),
                new TestCase(1, 2, "Fifteen-Thirty"),
                new TestCase(2, 1, "Thirty-Fifteen"),
                new TestCase(2, 2, "Thirty-Thirty"),
                new TestCase(2, 3, "Thirty-Forty"),
                new TestCase(3, 2, "Forty-Thirty"),
                new TestCase(3, 3, "Deuce"),
                new TestCase(4, 3, "Advantage Player 1"),
                new TestCase(3, 4, "Advantage Player 2"),
                new TestCase(4, 2, "Win for Player 1"),
                new TestCase(2, 4, "Win for Player 2"),
                new TestCase(5, 3, "Win for Player 1"),
                new TestCase(3, 5, "Win for Player 2")
        );
    }

    @ParameterizedTest(name="{0}")
    @MethodSource("scores")

    void givenScoreReturnResult (TestCase testCase) {
        var game = new TennisGame();
        String res = game.transformScoreToText(testCase.score1, testCase.score2);
        assertEquals(testCase.result, res);
    }

    private static class TestCase {
        public int score1;
        public int score2;
        public String result;
        public TestCase(int score1, int score2, String result){
            this.score1 = score1;
            this.score2 = score2;
            this.result = result;
        }
    }
}