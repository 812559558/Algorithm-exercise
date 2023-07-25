package maplearn;

import java.util.HashMap;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee a = new Employee(1, 111, "a");
        Employee b = new Employee(2, 222, "b");
        Employee c = new Employee(3, 333, "c");
        Employee d = new Employee(4, 888888, "d");
        map.put(1,a);
        map.put(2,b);
        map.put(3,c);
        map.put(4,d);
        Set integers = map.keySet();
        for(Object key:integers){
            Employee e=map.get(key);
            if(e.getSalary()>18000){
                System.out.println(e);
            }

        }
    }
}
