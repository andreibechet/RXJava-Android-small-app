package andreibechet.com.numbers;

public class ParseNumber {
    public static final int LEAST_SIGNIFICANT_2_BITS_MAP = 0x00000003;
    public static final int LEAST_SIGNIFICANT_2nd_to_6th_BITS_MAP = 0x0000007c;
    public static final int LEAST_SIGNIFICANT_7th_BITS_MAP = 0x00000080;

    public final SectionNumber sectionNumber;
    public final ItemNumber itemNumber;
    public final Boolean checked;

    public ParseNumber(Integer number) {
        sectionNumber = session(number);
        itemNumber = itemNumber(number);
        checked = checked(number);
    }

    private boolean checked(Integer number) {
        int numberFormedOf7thBit = (number & LEAST_SIGNIFICANT_7th_BITS_MAP) >> 7;
        return numberFormedOf7thBit == 1;
    }

    private ItemNumber itemNumber(Integer number) {
        ItemNumber itemNumber;
        try {
            int numberFormedOfBits2Till6 = (number & LEAST_SIGNIFICANT_2nd_to_6th_BITS_MAP) >> 2;
            itemNumber = ItemNumber.values()[numberFormedOfBits2Till6];
        } catch (ArrayIndexOutOfBoundsException e) {
            itemNumber = ItemNumber.InvalidItemNumber;
        }
        return itemNumber;
    }

    private SectionNumber session(Integer number) {
        SectionNumber sectionNumber;
        try {
            int numberFormedOfLastSignificant2Bits = number & LEAST_SIGNIFICANT_2_BITS_MAP;
            sectionNumber = SectionNumber.values()[numberFormedOfLastSignificant2Bits];
        } catch (ArrayIndexOutOfBoundsException e) {
            sectionNumber = SectionNumber.InvalidSection;
        }
        return sectionNumber;
    }

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
}
