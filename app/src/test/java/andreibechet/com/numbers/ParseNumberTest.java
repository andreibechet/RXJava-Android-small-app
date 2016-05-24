package andreibechet.com.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseNumberTest {

    @Test
    public void shouldComputeTheSection() {
        Integer someNumber = 140;
        ParseNumber parseNumber = new ParseNumber(someNumber);
        ParseNumber.Session expected = ParseNumber.Session.Session1;
        assertEquals("The session was not computed correctly", expected, parseNumber.session);
    }
}
