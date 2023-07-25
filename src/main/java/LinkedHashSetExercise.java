import chapter17.Car;

import java.util.LinkedHashSet;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        Car car=new Car("231",123);
        LinkedHashSet ls=new LinkedHashSet();
        ls.add(car);
        ls.add(new Car("ss",12));
        ls.add(new Car("ss",12));
        System.out.println(ls);
    }

}
