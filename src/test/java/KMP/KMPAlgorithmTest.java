package KMP;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPAlgorithmTest {

    private static final String[] TEXT_ARRAY = {
            "TESTREJF DHUFGASYGFSYTESTD SDGASGDYAUYd fsua",
            "AABBAABRTAAGHYTRVBBERERT"
    };

    private static final String[][] PATTERN_ARRAY = {
            {
                    "TEST",
                    "GA"
            },
            {
                    "AA",
                    "BA"
            }
    };

    @Test
    public void indexesOf() {
        KMPAlgorithm alg = new KMPAlgorithm();
        for (int i = 0; i < TEXT_ARRAY.length; i++){
            System.out.println(String.format("Text: %s", TEXT_ARRAY[i]));
            for (int j = 0; j < PATTERN_ARRAY.length; j++){
                System.out.println(String.format("Pattern: %s", PATTERN_ARRAY[i][j]));
                int[] res = alg.indexesOf(TEXT_ARRAY[i], PATTERN_ARRAY[i][j]);
                for (int r : res){
                    System.out.println(String.format("Index: %d", r + 1));
                }
            }
        }
    }
}