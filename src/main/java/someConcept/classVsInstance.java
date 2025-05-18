package someConcept;

import java.util.Scanner;

class Person {
    private int age;

    public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        if (initialAge >0){
            this.age = initialAge;
        }
        else{
            this.age = 0;
            System.out.println("Age is not valid, setting age to 0");
        }
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        String str = age < 13 ? "You are young." : ((age >=13 && age <18) ? "You are teenager." : "You are old.");
        /*String str =null;
        if(age <13){

        //System.out.println("You are young.");
        str = "You are young.";
        }
        else if(age>=13 && age <18){

        //System.out.println("You are teenager.");
        str ="You are teenager.";
        }
        else{
            str = "You are old.";
        //System.out.println("You are old.");
        }*/

        System.out.println(str);
    }

    public void yearPasses() {
        // Increment this person's age.
        age ++;
        System.out.println(age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();

            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}