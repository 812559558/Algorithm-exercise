package generate;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(1,1,2022);
        Employee employee = new Employee("c",1000,myDate);
        MyDate myDate2 = new MyDate(2,2,2022);
        Employee employee2 = new Employee("b",2000,myDate2);
        MyDate myDate3 = new MyDate(3,3,2022);
        Employee employee3 = new Employee("b",3000,myDate3);
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(!(o1 instanceof Employee && o2 instanceof Employee)){
                    System.out.println("类型不匹配");
                    return 0;
                }
                int i=o1.getName().compareTo(o2.getName());
                if(i!=0){
                    return i;
                }
                return o1.getMyDate().compareTo(o2.getMyDate());
            }
        });
        System.out.println(employees);
    }
}
