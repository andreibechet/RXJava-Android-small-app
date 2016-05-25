package andreibechet.com.sections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import andreibechet.com.numbers.ParseNumber;

import static org.junit.Assert.assertEquals;

public class SectionsTest {
    private final Sections sections = new Sections();

    @Before
    public void setUp() throws Exception {
        sections.add(new Section(ParseNumber.SectionNumber.Section2));
        sections.add(new Section(ParseNumber.SectionNumber.Section1));
    }


    @Test
    public void shouldReturnOrderedListOfSectionsByTheirSectionNumber() {
        List<Section> expected = new ArrayList<>();
        expected.add(new Section(ParseNumber.SectionNumber.Section1));
        expected.add(new Section(ParseNumber.SectionNumber.Section2));
        assertEquals("The list is not ordered", expected, sections.sortedSections());
    }
}