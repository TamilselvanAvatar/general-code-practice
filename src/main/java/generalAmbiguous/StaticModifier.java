package generalAmbiguous;

/*
 Illustration of static modifier:
    1. Can't override static method (because static belong to class rather than object)
    2. Can overload static method (even main method)
 */

public class StaticModifier extends Child {

    // Can't override static method
	// @Override
    /*
    void display() {
        System.out.println("I am in display ");
    }
    */

    public static void main(String... varArgs) {
        System.out.println("From Main method with single argument (Always start here even if there is than one main)");
        // main(varArgs); // what will happen 🙄?
        main(varArgs, 1);
    }

    /**
     * @description main method overloaded
     * @param args
     * @param i
     */
    public static void main(String[] args, int i) {
        System.out.println("From Main method with multiple/no argument \n i = " + i );
    }


    // Shouldn't have two main method - DuplicateMethod main
    // Replace the mainDuplicate to main (default behaviour of javac)
    public static void mainDuplicate(String[] args) {}

}

class Parent {
    static void display() {
        System.out.println("Display in Parent");
    }
}

class Child extends Parent {
    // @Override
    static void display() {
        System.out.println("Display in Child");
    }
}
