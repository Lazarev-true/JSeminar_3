import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Task {

    // Пусть дан произвольный список целых чисел
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(49, 73, 16, 6, 7, 2, 20, 9, 33, 34));
        Task findResult = new Task();
        findResult.removeEvenValue(list);
        System.out.println("Минимальное значение: " + getMin(list));
        System.out.println("Максимальное значение: " + getMax(list));
        System.out.println("Среднее значение из списка: " + (int)getAverage(list));
        System.out.println(list);
    }

    // Нужно удалить из него четные числа
    public void removeEvenValue(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    // Найти минимальное значение
    public static Integer getMin(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MAX_VALUE;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(0);
    }

    // Найти максимальное значение
    public static Integer getMax(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MIN_VALUE;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(sortedlist.size() - 1);
    }

    // Найти среднее значение
    public static double getAverage(List<Integer> list) {
        double avg = 0;
        if (list.size() > 0) {
            double sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum = sum + list.get(j);
            }
            avg = sum / list.size();
            System.out.println("Среднее арифметическое - " + avg);
        }
        int upSearch = (int) avg;
        int downSearch = (int) avg;
        while (true) {
            for (int num : list) {
                if (num == upSearch || num == downSearch) {
                    return num;
                }
            }
            upSearch++;
            downSearch--;
        }    
    }
}