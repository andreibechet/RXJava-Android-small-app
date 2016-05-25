package andreibechet.com.numbers;

import org.junit.Test;

import andreibechet.com.sections.Item;
import andreibechet.com.sections.Section;

import static org.junit.Assert.assertEquals;

public class ParseNumberTest {

    public static final Integer SOME_NUMBER = 140;
    public static final Integer SOME_OTHER_NUMBER = 150;
    public static final Integer ZERO = 0;
    public static final Integer NEGATIVE_NUMBER = -2;

    @Test
    public void shouldComputeTheSection() {
        assertEquals("The section number was not computed correctly",
                Section.SectionNumber.Section1,
                new ParseNumber(SOME_NUMBER).sectionNumber);

        assertEquals("The section number was not computed correctly",
                Section.SectionNumber.Section3,
                new ParseNumber(SOME_OTHER_NUMBER).sectionNumber);

        assertEquals("The section number was not computed correctly",
                Section.SectionNumber.Section1,
                new ParseNumber(ZERO).sectionNumber);

        assertEquals("The section number was not computed correctly",
                Section.SectionNumber.Section3,
                new ParseNumber(NEGATIVE_NUMBER).sectionNumber);
    }

    @Test
    public void shouldComputeTheItemNumber() {
        assertEquals("The item number was not computed correctly",
                Item.ItemNumber.Item4,
                new ParseNumber(SOME_NUMBER).itemNumber);

        assertEquals("The item number was not computed correctly",
                Item.ItemNumber.Item6,
                new ParseNumber(SOME_OTHER_NUMBER).itemNumber);

        assertEquals("The item number was not computed correctly",
                Item.ItemNumber.Item1,
                new ParseNumber(ZERO).itemNumber);

        assertEquals("The item number was not computed correctly",
                Item.ItemNumber.InvalidItemNumber,
                new ParseNumber(NEGATIVE_NUMBER).itemNumber);
    }

    @Test
    public void shouldComputeIfCheckmarkIsSetOrNot() {
        assertEquals("The item number was not computed correctly",
                Boolean.TRUE,
                new ParseNumber(SOME_NUMBER).checked);

        assertEquals("The item number was not computed correctly",
                Boolean.TRUE,
                new ParseNumber(SOME_OTHER_NUMBER).checked);

        assertEquals("The item number was not computed correctly",
                Boolean.FALSE,
                new ParseNumber(ZERO).checked);
    }
}
