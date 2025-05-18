package someConcept;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StringStream {

    public static void main(String[] args) {
        Stream<String> stringStream = Arrays.asList("A", "B","C","D").stream();
        Stream<Integer> intStream = Arrays.asList(1,2,3,5).stream();
        //String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,
        //        StringBuilder::append)
        //.toString();

        //StringBuilder sb = new StringBuilder();
        //stringStream.forEach(sb::append);

        Optional<String> string = stringStream.reduce((a,b)->a+b);
        Optional<Integer> max = intStream.max((a,b) -> {
            return a >= b ? 1 : -1;
        });


        System.out.println(max.get());
        System.out.println(string.get());

    }

}

