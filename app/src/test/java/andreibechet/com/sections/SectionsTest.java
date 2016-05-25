package andreibechet.com.sections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SectionsTest {
    private final Sections sections = new Sections();

    @Before
    public void setUp() throws Exception {
        sections.add(new Section(Section.SectionNumber.Section2));
        sections.add(new Section(Section.SectionNumber.Section1));
    }


    @Test
    public void shouldReturnOrderedListOfSectionsByTheirSectionNumber() {
        List<Section> expected = new ArrayList<>();
        expected.add(new Section(Section.SectionNumber.Section1));
        expected.add(new Section(Section.SectionNumber.Section2));
        assertEquals("The list is not ordered", expected, sections.sortedSections());
    }

    @Test
    public void shouldNotAddTheSameSectionMultipleTimes() {
        Section section = new Section(Section.SectionNumber.Section1);
        section.add(new Item(Item.ItemNumber.Item1, true));
        sections.add(section);
        List<Section> expected = new ArrayList<>();
        expected.add(section);
        expected.add(new Section(Section.SectionNumber.Section2));
        assertEquals("The list is not ordered", expected, sections.sortedSections());
    }
}