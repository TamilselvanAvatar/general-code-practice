package someConcept;

public class TryCatchFinally {

    public static void main(String[] args) {

        System.out.println(someMethod(12, 6));
        // Below one won't invoke (Because program is terminated)
        System.out.println(someMethod(12, 0));

    }

    @SuppressWarnings("finally")
    public static int someMethod(int a , int b) {
        int ans = 0;
        try {
            ans = a/b;
            System.out.println("O/P : "+ans);
            System.exit(0);
            return ans;
        }
        catch(Exception e) {
            System.out.println("O/P : "+-1);
            System.exit(0);
            return -1;
        }
        finally {
            return 100; // Random Number
        }
    }

}

