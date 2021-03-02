package KMP;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KMPAlgorithm {
    public int[] indexesOf(String text, String pattern){
        // массив префиксов
        int[] prefixes = calcPrefixesArray(pattern);
        // результат
        List<Integer> found = new LinkedList<>();
        int k = 0;
        // идем по строке
        for (int i = 0; i < text.length(); ++i)
        {
            // если символ паттерна не совпал с символом образца
            while (pattern.charAt(k) != text.charAt(i) && k > 0)
            {
                // откат на один префикс назад
                k = prefixes[k - 1];
            }
            if (pattern.charAt(k) == text.charAt(i))
            {
                // если очередной символ образца совпал с символом паттерна
                k = k + 1;
                // если дошли до конца паттерна
                if (k == pattern.length())
                {
                    // подстрока найдена
                    found.add(i + 1 - k);
                    // откат на пред. префикс
                    k = prefixes[k - 1];
                }
            }
            else
            {
                // начинаем с первого префикса (0)
                k = 0;
            }
        }

        return found.stream().mapToInt(x -> x).toArray();
    }

    // рассчет массива префиксов
    private int[] calcPrefixesArray(String s){
        // результат
        int[] prefixes = new int[s.length()];
        // первый префикс всегда 0
        prefixes[0] = 0;

        // проход по строке
        for (int i = 1; i < s.length(); i++){
            // запоминаем пред. префикс
            int prevPrefixIdx = prefixes[i - 1];
            // если уже имеется префикс, то откатываемся на пред. префикс, пока
            // не начнет совпадать с образцом
            while (s.charAt(prevPrefixIdx) != s.charAt(i) && prevPrefixIdx > 0)
            {
                prevPrefixIdx = prefixes[prevPrefixIdx - 1];
            }
            // увеличиваем префикс
            if (s.charAt(prevPrefixIdx) == s.charAt(i))
            {
                prefixes[i] = prevPrefixIdx + 1;
            }
            else
            {
                // нет префикса
                prefixes[i] = 0;
            }
        }

        return prefixes;
    }
}
