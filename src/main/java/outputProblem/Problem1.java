package outputProblem;

public class Problem1 {

    public static int a= 1;

    public static void main(String[] args) {
        // Even the cast give the maths accurate value.
        System.out.println("Final:"+ (float) a/2);
        // Output : call the inner method with argument assigned value
        // Is this Possible? will affect the actual value?
        System.out.println("Output:"+ call_a(a=15));
        System.out.println("Output of a = " + a);
        checkDouble();
    }

    public static int call_a(int x) {
        return call_b(x*=15);
    }

    static int call_b(int x) {
        return call_c(x/=15);
    }

    static int call_c(int x) {
        return call_d(x-=15);
    }

    static int call_d(int x) {
        return x+=15;
    }

    static float checkDouble() {
        int[] i = new int[0];
        // Have this doubt - how can primitive array have length attribute?
        System.out.println(i.getClass());
        // Float range have 1 also
        return 1;
		// return -1.0f;
    }

}
