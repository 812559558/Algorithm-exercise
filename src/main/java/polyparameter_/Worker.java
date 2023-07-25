package polyparameter_;

public class Worker extends Employee{

    public Worker(String name, int monthsalary) {
        super(name, monthsalary);
    }
    public void work(){
        System.out.println("Worker干活");
    }

    @Override
    public int getAnnualSalary() {
        return 66666;
    }
}
