package andreibechet.com.sections;

import android.support.annotation.NonNull;

public class Item implements Comparable<Item> {
    public final ItemNumber itemNumber;
    public final Boolean checked;

    public enum ItemNumber {
        Item1(0), Item2(1), Item3(2), Item4(3), Item5(4), Item6(5), InvalidItemNumber(-1);
        private final int value;

        ItemNumber(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public Item(final ItemNumber itemNumber, final Boolean checked) {
        this.itemNumber = itemNumber;
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return areItemNumbersEqual(item) && areBothItemsCheckedOrNot(item);

    }

    private boolean areBothItemsCheckedOrNot(final Item item) {
        return checked != null ? checked.equals(item.checked) : item.checked == null;
    }

    private boolean areItemNumbersEqual(final Item item) {
        return itemNumber.getValue() == item.itemNumber.getValue();
    }

    @Override
    public int hashCode() {
        int result = itemNumber != null ? itemNumber.hashCode() : 0;
        result = 31 * result + (checked != null ? checked.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNumber=" + itemNumber +
                ", checked=" + checked +
                '}';
    }

    @Override
    public int compareTo(@NonNull Item comparesToItem) {
        return this.itemNumber.getValue() - comparesToItem.itemNumber.getValue();
    }
}
