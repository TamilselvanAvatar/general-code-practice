package someConcept;

import outputProblem.Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReplaceListElement {


    @SuppressWarnings({ "deprecation", "static-access" })
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
        List<String> list = new ArrayList<>();
        list.add("12-12-2022");
        list.add("2-2-2022");
        list.add("1-11-2022");
        list.replaceAll(date-> date.replace("-", "/"));

        list.stream().forEach(System.out::println);

        try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
            writer.println("Hello World");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // Calling method in a different way
            @SuppressWarnings("unchecked")
            Class<Problem1> sampleClass =(Class<Problem1>) Class.forName("Sample");
            Class<?> intC = Class.forName("java.lang.Integer");
            Problem1 sample = (Problem1) sampleClass.newInstance();

            System.out.println(sample.call_a(15));

            Method method = sampleClass.getMethod("call_a",intC);

            System.out.println(method);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

