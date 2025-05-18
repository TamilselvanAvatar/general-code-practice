package someConcept;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Align the List - start with odd number and end with even number
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size() ; j++) {
                int a = numbers.get(i);
                int b = numbers.get(j);
                if (a % 2 == 0) {
                    numbers.set(i, b);
                    numbers.set(j, a);
                }
            }
        }

        // Split the Above List as Odd and Even number list
        // ** Number of even and odd number in the list should be same length **
        Spliterator<Integer> spliterator = numbers.spliterator();
        Spliterator<Integer> s = spliterator.trySplit();

        System.out.println("Numbers " + numbers);
        System.out.println("O Numbers ");
        spliterator.forEachRemaining(System.out::println);
        System.out.println("E Numbers ");
        s.forEachRemaining(System.out::println);

    }

}
