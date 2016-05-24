package andreibechet.com.numbers;

public class ParseNumber {
    public static final int LEAST_SIGNIFICANT_2_BITS = 0x00000003;
    public static final int LEAST_SIGNIFICANT_2_to_6_BITS = 0x0000007c;
    public static final int LEAST_SIGNIFICANT_7th_BITS = 0x00000080;

    public final Session session;
    public final ItemNumber itemNumber;
    public final Boolean checked;

    public ParseNumber(Integer number) {
        Session session;
        try {
            session = Session.values()[number & LEAST_SIGNIFICANT_2_BITS];
        } catch (ArrayIndexOutOfBoundsException e) {
            session = Session.InvalidSession;
        }
        this.session = session;

        ItemNumber itemNumber;
        try {
            itemNumber = ItemNumber.values()[(number & LEAST_SIGNIFICANT_2_to_6_BITS) >> 2];
        } catch (ArrayIndexOutOfBoundsException e) {
            itemNumber = ItemNumber.InvalidItemNumber;
        }
        this.itemNumber = itemNumber;

        checked = (number & LEAST_SIGNIFICANT_7th_BITS) >> 7 == 1;
    }

    public enum Session {
        Session1(0), Session2(1), Session3(2), Session4(3), InvalidSession(-1);
        private final int value;

        Session(int i) {
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
