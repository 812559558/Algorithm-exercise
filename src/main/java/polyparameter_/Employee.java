package polyparameter_;

public class Employee {
    public String name;
    public int monthsalary;

    public Employee(String name, int monthsalary) {
        this.name = name;
        this.monthsalary = monthsalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthsalary() {
        return monthsalary;
    }

    public void setMonthsalary(int monthsalary) {
        this.monthsalary = monthsalary;
    }

    public int getAnnualSalary(){
        return 12*monthsalary;
    }
}
