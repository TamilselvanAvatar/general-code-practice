package someConcept;

public class ControlFlow {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        // Thread is still work (** No Error **) even there is no ovrride 'run' method
        threadDemo.start();

        int k = 5;
        // We can Assign value even in conditional argument
        if((k=2) == 3) {
            k+=5;
        }
        else {
            //System.out.println(k);
            k+=7;
        }
        System.out.println(k);
    }
}

class ThreadDemo extends Thread{}


