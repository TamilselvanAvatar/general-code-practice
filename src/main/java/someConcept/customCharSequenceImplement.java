package someConcept;

import java.util.HashMap;
import java.util.Map;

public abstract class customCharSequenceImplement {
    public final int value;
    public customCharSequenceImplement() {
        value = 10;
    }
    public static void main(String... args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", " : A");
        System.out.println("Default value of map " + map.getOrDefault("A", "VALUE A") );
        int a;
        display display = new display();
        display.sum(12, 10l);
        CharSquenceImplementor c = new CharSquenceImplementor("Tom is good");
        System.out.println(c.length());
        System.out.println(c.charAt(1));
        System.out.println(c.subSequence(4,8));
        System.out.println();// cant print 'a' without initialize
        class display{
            public void name() {
                System.out.println("Inner method class");
            }
        }

        for (int i = 0; i < 5;) {
            System.out.println(i);
            i++;
        }
    }

    public int add(int a, int b) {
        return a+b;
    }


    public double add(int a) {
        return a+ 1.0;
    }

    abstract void display();
    public static void main(Integer a, String... args) {
        System.out.println("Other main");
    }
}



class display{
    static void sum(int a,long b){System.out.println("a method invoked");}
    static void sum(long a,int b){System.out.println("b method invoked");}
    public void name() {
        System.out.println("Inner method class");
    }
}

class CharSquenceImplementor implements CharSequence {

    char[] charSequence;

    public CharSquenceImplementor(String str) {
        this.charSequence = str.toCharArray();
    }

    public CharSquenceImplementor(char[] str) {
        this.charSequence = str;
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return this.charSequence.length;
    }

    @Override
    public char charAt(int index) {
        try {
            return this.charSequence[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return ' ';
        }
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        char a[] = new char[end - start - 1];
        for (int i = (end - start - 2), j = 0; i >= 0; i--, j++) {
            a[j] = charAt(i);
        }
        return new CharSquenceImplementor(a);
//		return "";
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < charSequence.length; i++) {
            string += this.charSequence[i];
        }
        return string;
    }

}

