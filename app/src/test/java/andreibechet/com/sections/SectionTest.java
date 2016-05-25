package andreibechet.com.sections;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SectionTest {

    private final Section someSection = new Section(Section.SectionNumber.Section1);

    @Before
    public void setup() {
        someSection.add(new Item(Item.ItemNumber.Item2, false));
        someSection.add(new Item(Item.ItemNumber.Item1, true));
    }

    @Test
    public void shouldReturnTheExistingItemsOrderedByTheirNumericValue() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(Item.ItemNumber.Item1, true));
        expected.add(new Item(Item.ItemNumber.Item2, false));
        assertEquals("The list is not ordered", expected, someSection.sortedItems());
    }

    @Test
    public void shouldReturnEmptyListIfItContainsNoItems() {
        Section emptySection = new Section(Section.SectionNumber.Section2);
        List<Item> expected = new ArrayList<>();
        assertEquals("Both lists should be empty", expected, emptySection.sortedItems());
    }

    @Test
    public void shouldReplaceItemIfItAlreadyExists() {
        someSection.add(new Item(Item.ItemNumber.Item1, false));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(Item.ItemNumber.Item1, false));
        expected.add(new Item(Item.ItemNumber.Item2, false));
        assertEquals("The list is not ordered", expected, someSection.sortedItems());
    }

}