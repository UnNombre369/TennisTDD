package org.example.kataGameTesting;

import org.example.kataGame.TennisMatch;
import org.example.kataGame.TennisSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class TennisMatchUnitTest {

    static Stream<TestCase> provideMatchScores(){
        return Stream.of(
                new TestCase(1, 0, "Sets: 1-0, Current set: 0-0"),
                new TestCase(2, 0, "Sets: 2-0, Current set: 0-0"),
                new TestCase(3, 0, "Player 1 wins"),
                new TestCase(0, 2, "Sets: 0-2, Current set: 0-0"),
                new TestCase(0, 3, "Player 2 wins")
        );
    }

    @ParameterizedTest(name="{0}")
    @MethodSource("provideMatchScores")
    public void testMatchScore(TestCase testCase){
        TennisSet set = mock(TennisSet.class);
        when(set.getScore()).thenReturn("0-0");
        TennisMatch match = new TennisMatch(set, testCase.player1Sets, testCase.player2Sets);
        assertEquals(testCase.result, match.getMatchScore());
    }

    public static class TestCase {
        public int player1Sets;
        public int player2Sets;
        public String result;

        TestCase(int player1Sets, int player2Sets, String result) {
            this.player1Sets = player1Sets;
            this.player2Sets = player2Sets;
            this.result = result;
        }
    }
}
