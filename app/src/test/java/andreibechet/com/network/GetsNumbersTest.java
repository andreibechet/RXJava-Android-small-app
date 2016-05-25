package andreibechet.com.network;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetsNumbersTest {
    public static final String BRAGI_TEST_ADDRESS = "http://foo.bragi.net/numbers.json";
    private final GetsNumbers getsNumbers = new GetsNumbers(BRAGI_TEST_ADDRESS);

    @Test
    public void shouldReturnListOfIntegersAfterHttpRequest() {
        List<Integer> expected = Arrays.asList(4, 150, 12, 21, 136, 16, 3);
        assertEquals("Returned numbers are not equal", expected, getsNumbers.numbers);
    }

}