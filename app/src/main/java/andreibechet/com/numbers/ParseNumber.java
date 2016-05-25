package andreibechet.com.numbers;

import andreibechet.com.sections.Item;
import andreibechet.com.sections.Section;

public class ParseNumber {
    public static final int LEAST_SIGNIFICANT_2_BITS_MAP = 0x00000003;
    public static final int LEAST_SIGNIFICANT_2nd_to_6th_BITS_MAP = 0x0000007c;
    public static final int LEAST_SIGNIFICANT_7th_BITS_MAP = 0x00000080;

    public final Section.SectionNumber sectionNumber;
    public final Item.ItemNumber itemNumber;
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

    private Item.ItemNumber itemNumber(Integer number) {
        Item.ItemNumber itemNumber;
        try {
            int numberFormedOfBits2Till6 = (number & LEAST_SIGNIFICANT_2nd_to_6th_BITS_MAP) >> 2;
            itemNumber = Item.ItemNumber.values()[numberFormedOfBits2Till6];
        } catch (ArrayIndexOutOfBoundsException e) {
            itemNumber = Item.ItemNumber.InvalidItemNumber;
        }
        return itemNumber;
    }

    private Section.SectionNumber session(Integer number) {
        Section.SectionNumber sectionNumber;
        try {
            int numberFormedOfLastSignificant2Bits = number & LEAST_SIGNIFICANT_2_BITS_MAP;
            sectionNumber = Section.SectionNumber.values()[numberFormedOfLastSignificant2Bits];
        } catch (ArrayIndexOutOfBoundsException e) {
            sectionNumber = Section.SectionNumber.InvalidSection;
        }
        return sectionNumber;
    }

}
