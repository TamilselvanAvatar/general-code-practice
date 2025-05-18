package generalAmbiguous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorForSortObjects {
    public static void main(String []args){
        List<User> list = new ArrayList<>();
        list.add(new User("Sanji","Vimsmoke",22));
        list.add(new User("Luffy","Monkey",18));
        list.add(new User("Ben","Beckmann",23));
        list.add(new User("Cat","Burglar",20));
        list.add(new User("Zoro","Roronoro",20));

        //Collections.sort(list,new NameComparator());

        // Since Comparator is functional interface , so we can use lambda expression
        // We implement compare method creating a NameComparator class (see above statement)
        Collections.sort(list,(u1, u2)->{
            User s1=(User)u1;
            User s2=(User)u2;

            return s1.getName().compareTo(s2.getName());
        });

        //Collections.sort(list,new AgeComparator());

        System.out.println(list);
    }
}

class NameComparator implements Comparator<Object> {
    public int compare(Object o1,Object o2){
        User s1=(User)o1;
        User s2=(User)o2;

        return s1.getName().compareTo(s2.getName());
    }
}

class AgeComparator implements Comparator<Object>{
    public int compare(Object o1,Object o2){
        User s1=(User)o1;
        User s2=(User)o2;

        return s1.getAge() >= s2.getAge() ? 1 : -1 ;
    }
}

class User{
    private String name;
    private String last_name;
    private int age;
    User(String name,String last_name,int age){
        this.name=name;
        this.last_name = last_name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public String getLastName(){
        return this.last_name;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString(){
        return "[ name : " + this.getName() + ", last_name : " + this.getLastName() +", age : "+ this.getAge() + "]" ;
    }

}
