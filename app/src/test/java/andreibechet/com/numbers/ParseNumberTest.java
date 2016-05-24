package andreibechet.com.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseNumberTest {

    @Test
    public void shouldComputeTheSection() {
        Integer someNumber = 140;
        ParseNumber parseNumber = new ParseNumber(someNumber);
        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session1,
                parseNumber.session);

        Integer someOtherNumber = 150;
        ParseNumber parseAnotherNumber = new ParseNumber(someOtherNumber);
        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session3,
                parseAnotherNumber.session);

        Integer zero = 0;
        ParseNumber parseZero = new ParseNumber(zero);
        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session1,
                parseZero.session);

        Integer negative = -2;
        ParseNumber parseNegative = new ParseNumber(negative);
        assertEquals("The session was not computed correctly",
                ParseNumber.Session.Session3,
                parseNegative.session);
    }
}
