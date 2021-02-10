package borders;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStringBorderFinderTest {
    private final static SimpleStringBorderFinder borderFinder = new SimpleStringBorderFinder();

    private final static String[] STRINGS = {
            "ABAABABAABAAB",
            "ABCDnnnnnABCDtyABCD"
    };

    @Test
    public void findBorder() {
        for (String s : STRINGS){
            System.out.println("========= " + s + " =========");
            String result = borderFinder.findBorder(s);
            System.out.println(String.format("Border size: %d", result.length()));
            System.out.println(result);
            System.out.println("=========");
        }
    }
}