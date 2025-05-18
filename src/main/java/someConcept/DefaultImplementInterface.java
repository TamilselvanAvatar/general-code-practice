package someConcept;

public class DefaultImplementInterface {
    public static void main(String[] args) {
        InvokeMethodClass.display(3,4, (a, b) -> a + b);
    }
}

class InvokeMethodClass {
    public static void display(int a, int b, DemoDefaultAdd di) {
        int mul = di.mul(a, b);
        int add = di.add(a, b);
        System.out.println("Mul : " + mul);
        System.out.println("Add : " + add);
    }
}

class ImpOneClass implements DemoDefaultAdd {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

// There is no Diamond problem arise because default 'mul' method
// When ImpBothClass is implement both default interface
// we sholud override `mul` method
class ImpBothClass implements DemoDefaultAdd, DemoDefaultSub {
    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int mul(int a, int b) {
        // return a % b;
        return DemoDefaultAdd.super.mul(a, b); /* Note */
    }
}

@FunctionalInterface
interface DemoDefaultAdd {
    default int mul(int a, int b) {
        return a * b;
    }

    int add(int a, int b);
}

@FunctionalInterface
interface DemoDefaultSub {
    default int mul(int a, int b) {
        return a / b;
    }

    int sub(int a, int b);
}
