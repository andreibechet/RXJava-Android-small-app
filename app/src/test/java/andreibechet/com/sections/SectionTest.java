package andreibechet.com.sections;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import andreibechet.com.numbers.ParseNumber;

import static org.junit.Assert.assertEquals;

public class SectionTest {

    private Section someSection;

    @Before
    public void setup() {
        someSection = new Section(ParseNumber.SectionNumber.Section1);
        someSection.add(new Item(ParseNumber.ItemNumber.Item2, false));
        someSection.add(new Item(ParseNumber.ItemNumber.Item1, true));
    }

    @Test
    public void shouldReturnTheExistingItemsOrderedByTheirNumericValue() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(ParseNumber.ItemNumber.Item1, true));
        expected.add(new Item(ParseNumber.ItemNumber.Item2, false));
        assertEquals("The list is not ordered", expected, someSection.sortedItems());
    }

    @Test
    public void shouldReturnEmptyListIfItContainsNoItems() {
        Section emptySection = new Section(ParseNumber.SectionNumber.Section2);
        List<Item> expected = new ArrayList<>();
        assertEquals("Both lists should be empty", expected, emptySection.sortedItems());
    }

}