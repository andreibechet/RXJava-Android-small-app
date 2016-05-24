package andreibechet.com.numbers;

public class ParseNumber {
    public static final int LEAST_SIGNIFICANT_2_BITS = 0x00000003;
    public final Session session;

    public ParseNumber(Integer number) {
        session = Session.values()[number & LEAST_SIGNIFICANT_2_BITS];
    }

    public enum Session {
        Session1(0), Session2(1), Session3(2), Session4(3);
        private final int value;

        Session(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }
}
