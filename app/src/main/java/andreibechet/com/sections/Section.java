package andreibechet.com.sections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import andreibechet.com.numbers.ParseNumber;

public class Section implements Comparable<Section>  {
    public final ParseNumber.SectionNumber sectionNumber;
    private final List<Item> items = new ArrayList<>();

    public Section(ParseNumber.SectionNumber sectionNumber) {
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
