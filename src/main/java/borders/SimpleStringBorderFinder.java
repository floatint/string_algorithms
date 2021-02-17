package borders;

public class SimpleStringBorderFinder {
    String findBorder(String s) {
        // индекс конца границы (с начала строки)
        int border_index = 0;

        // идем по строке с конца
        for (int i = s.length() - 1; border_index == 0 && i > 0; --i){
            // пытаемся найти наибольшую границу сдвигая указатель в начале
            int j = 0;
            for (j = 0; j < i; j++){
                if (s.charAt(j) != s.charAt(s.length() - i + j)){
                    break;
                }
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
