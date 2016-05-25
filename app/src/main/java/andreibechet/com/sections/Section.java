package andreibechet.com.sections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Section implements Comparable<Section>  {
    public final SectionNumber sectionNumber;
    private final List<Item> items = new ArrayList<>();

    public enum SectionNumber {
        Section1(0), Section2(1), Section3(2), Section4(3), InvalidSection(-1);
        private final int value;

        SectionNumber(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }


    public Section(final SectionNumber sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void add(Item item) {
        items.add(item);
        sortItemsAscending();
    }

    private void sortItemsAscending() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item lhs, Item rhs) {
                return lhs.compareTo(rhs);
            }
        });
    }

    public List<Item> sortedItems() {
        return items;
    }

    @Override
    public int compareTo(@NonNull Section comparesToItem) {
        return this.sectionNumber.getValue() - comparesToItem.sectionNumber.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return sectionNumber == section.sectionNumber;

    }

    @Override
    public int hashCode() {
        return sectionNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionNumber=" + sectionNumber +
                ", items=" + items +
                '}';
    }
}
