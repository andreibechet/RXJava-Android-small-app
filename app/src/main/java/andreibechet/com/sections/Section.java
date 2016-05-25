package andreibechet.com.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import andreibechet.com.numbers.ParseNumber;

public class Section {
    public final ParseNumber.SectionNumber sectionNumber;
    private List<Item> items;

    public Section(ParseNumber.SectionNumber sectionNumber) {
        this.sectionNumber = sectionNumber;
        items = new ArrayList<>();
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
}
