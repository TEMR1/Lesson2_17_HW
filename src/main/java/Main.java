import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        task1(948);
        task2(Arrays.asList(2, 4, 5, 6, 7, 4, 67, 23, 4, 1, 1, 8, 45, 67));
    }

    private static <T> void printAllItemsOfArray(ArrayList<T> array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
    }

    static void task1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        System.out.println(roman);
    }

    public static void task2(List<Integer> nums) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> counters = new ArrayList<>();

        int maxSize = 3;
        int num;
        int counter;

        for (int numberIndex = 0; numberIndex < nums.size(); numberIndex++) {
            num = nums.get(numberIndex);
            counter = 0;

            if (!numbers.contains(num)){
                for (int j = numberIndex + 1; j < nums.size(); j++) {
                    if (num == nums.get(j))
                        counter++;
                }
            }

            if (numbers.size() < maxSize) {
                numbers.add(num);
                counters.add(counter);
            } else {
                int minCounter = Collections.min(counters);
                int minCounterIndex = counters.indexOf(minCounter);

                if (counter > minCounter) {
                    numbers.set(minCounterIndex, num);
                    counters.set(minCounterIndex, counter);
                }
            }
        }

        System.out.print("Most popular numbers in list: ");
        printAllItemsOfArray(numbers);
    }

    public static void task3(int num) {

    }
}