package andreibechet.com.network;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import andreibechet.com.configuration.Configurations;

import static org.junit.Assert.assertEquals;

public class GetsNumbersTest {

    @Test
    public void shouldReturnListOfIntegersAfterHttpRequest() {
        GetsNumbers getsNumbers = new GetsNumbers(Configurations.BRAGI_TEST_ADDRESS);
        List<Integer> expected = Arrays.asList(4, 150, 12, 21, 136, 16, 3);
        assertEquals("Returned numbers are not equal", expected, getsNumbers.numbers);
    }

}