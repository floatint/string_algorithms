package borders;

public class SimpleStringBorderFinder {
    String findBorder(String s) {
        // индекс конца границы
        int border_index = 0;

        // идем по строке с конца
        for (int i = s.length() - 1; border_index == 0 && i > 0; --i){
            // пытаемся найти наибольшую границу сдвигая указатель в начале
            int j = 0;
            while (j < i && s.charAt(j) == s.charAt(s.length() - i + j)){
                j++;
            }

            // если с начала и с конца пройдено одинаковое расстояние, то граница найдена
            if (j == i){
                border_index = i;
            }
        }
        // возврат подстроки, содержащей границу
        return s.substring(0, border_index);
    }
}
