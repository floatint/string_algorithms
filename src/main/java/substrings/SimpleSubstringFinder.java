package substrings;

import java.util.List;
import java.util.ArrayList;

public class SimpleSubstringFinder {
    public List<Integer> substringFind(String s1, String s2) {
        // список вхождений
        List<Integer> result = new ArrayList<>();
        boolean found = true;
        // внешний цикл по основной строке
        for (int i = 0; i < s1.length() - s2.length() + 1; i++){
            // внутренний по образцу
            for (int j = 0; j < s2.length(); j++){
                if (s2.charAt(j) != s1.charAt(i + j)){
                    found = false;
                    break;
                }
            }
            // если нашли
            if (found){
                result.add(i);
            }
            found = true;
        }
        // возврат
        return result;
    }
}
