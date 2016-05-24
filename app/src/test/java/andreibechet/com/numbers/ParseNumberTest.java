package andreibechet.com.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseNumberTest {

    public static final Integer SOME_NUMBER = 140;
    public static final Integer SOME_OTHER_NUMBER = 150;
    public static final Integer ZERO = 0;
    public static final Integer NEGATIVE = -2;

    @Test
    public void shouldComputeTheSection() {
        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session1,
                new ParseNumber(SOME_NUMBER).session);

        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session3,
                new ParseNumber(SOME_OTHER_NUMBER).session);

        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session1,
                new ParseNumber(ZERO).session);

        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session3,
                new ParseNumber(NEGATIVE).session);
    }

    @Test
    public void shouldComputeTheItemNumber() {
        assertEquals("The session was not computed correctly",
                ParseNumber.ItemNumber.Item4,
                new ParseNumber(SOME_NUMBER).itemNumber);
    }
}
