import java.util.HashSet;

public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee aa = new Employee("aa", 11);
        Employee bb = new Employee("bb", 22);
        Employee bb1 = new Employee("bb", 22);
        System.out.println(bb.equals(bb1));
        hashSet.add(aa);
        hashSet.add(bb);
        hashSet.add(bb1);

        for(Object o:hashSet){
            System.out.println(o);
        }

    }
}
