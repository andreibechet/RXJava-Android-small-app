package andreibechet.com.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sections {
    private final List<Section> sections = new ArrayList<>();

    public void add(final Section section) {
        sections.add(section);
        sortSectionsAscending();
    }

    private void sortSectionsAscending() {
        Collections.sort(sections, new Comparator<Section>() {
            @Override
            public int compare(Section lhs, Section rhs) {
                return lhs.compareTo(rhs);
            }
        });
    }

    public List<Section> sortedSections() {
        return sections;
    }
}
