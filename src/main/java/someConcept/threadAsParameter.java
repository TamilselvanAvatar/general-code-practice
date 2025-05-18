package someConcept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadAsParameter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        /*
        ContextThread.runAsync(()->{
			System.out.println("Thread 1");
			for (int i = 0; i < 10000; i++) {
				list.add(i);
			}
		});
		ContextThread.runAsync(()->{
			System.out.println("Thread 2");
			for (int i = 1000; i < 10000; i++) {
				list.add(i);
			}
		});
		*/
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            System.out.println("Thread 1");
            for (int i = 0; i < 1000000000; i++) {
                list.add(i);
            }
        });

        executorService.submit(() -> {
            System.out.println("Thread 2");
            for (int i = 1000; i < 10000000; i++) {
                list.add(i);
            }
        });

        executorService.shutdown();
        System.out.println("Done");
    }
}

abstract class ContextThread implements Runnable {
    public static void runAsync(Runnable runnable) {
        runnable.run();
    }
}