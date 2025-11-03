package org.example.kataGameTesting;

import org.example.kataGame.TennisGame;
import org.example.kataGame.TennisSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class TennisSetUnitTest {

    static Stream<TestCase> provideSetScores() {
        return Stream.of(
                new TestCase(0, 0, "0-0"),
                new TestCase(3, 2, "3-2"),
                new TestCase(5, 3, "5-3"),
                new TestCase(6, 4, "Set won by Player 1"),
                new TestCase(4, 6, "Set won by Player 2"),
                new TestCase(6, 6, "6-6"),
                new TestCase(7, 5, "Set won by Player 1"),
                new TestCase(5, 7, "Set won by Player 2")
        );
    }

    @ParameterizedTest(name="{0}")
    @MethodSource("provideSetScores")

    void givenSetScoreReturnResult (TestCase testCase){
        TennisGame tennisGame = mock(TennisGame.class);
        var set = new TennisSet(tennisGame, testCase.player1Games, testCase.player2Games);
        assertEquals(testCase.result, set.getScore());
    }


    static class TestCase {
        public int player1Games;
        public int player2Games;
        public String result;

        TestCase(int player1Games, int player2Games, String result) {
            this.player1Games = player1Games;
            this.player2Games = player2Games;
            this.result = result;
        }
    }
}
