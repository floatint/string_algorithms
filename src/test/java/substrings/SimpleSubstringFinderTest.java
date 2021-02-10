package substrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SimpleSubstringFinderTest {
    private final static SimpleSubstringFinder substringFinder = new SimpleSubstringFinder();

    private final static String STRINGS[] = {
            "ABBABFGUUYDSIUDGJLABBAAB",
            "GERTYUIOGERTyrnYUI",
            "TesttesonTes"
    };

    private final static String SLICES[] = {
            "AB",
            "GER",
            "Tes"
    };

    @Test
    public void substringFind() {
        for (int i = 0; i < STRINGS.length; i++){
            System.out.println("========= " + STRINGS[i] + " =========");
            List<Integer> result = substringFinder.substringFind(STRINGS[i], SLICES[i]);
            Assert.assertNotEquals(0, result.size());
            for (Integer r : result){
                System.out.println(String.format("Substring \"%s\" index: " + (r + 1), SLICES[i]));
            }
            System.out.println("==================");
        }
    }
}