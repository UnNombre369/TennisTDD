package org.example.kataGameTesting;

import org.example.kataGame.TennisTiebreak;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class TennisTiebreakUnitTest {

    static Stream<TestCase> provideScores() {
        return Stream.of(
                new TestCase(0, 0, "0-0"),
                new TestCase(6, 6, "6-6"),
                new TestCase(7, 5, "Tiebreak won by Player 1"),
                new TestCase(5, 7, "Tiebreak won by Player 2"),
                new TestCase(7, 6, "7-6"),
                new TestCase(8, 6, "Tiebreak won by Player 1"),
                new TestCase(10, 12, "Tiebreak won by Player 2")
        );
    }

    @ParameterizedTest(name="{0}")
    @MethodSource("provideScores")
    void givenTiebreakScoresReturnResult(TestCase testCase) {
        TennisTiebreak tiebreak = new TennisTiebreak(testCase.player1Points, testCase.player2Points);
        assertEquals(testCase.result, tiebreak.getScore());
    }

    static class TestCase {
        int player1Points;
        int player2Points;
        String result;

        TestCase(int p1, int p2, String result) {
            this.player1Points = p1;
            this.player2Points = p2;
            this.result = result;
        }
    }
}
