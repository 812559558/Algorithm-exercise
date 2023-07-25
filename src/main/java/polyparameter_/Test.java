package polyparameter_;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Employee employee = new Worker("aaa",3);
        Employee employee2 = new Manager("aaa",3,4);

        test.showEmpAnnual(employee);
        test.showEmpAnnual(employee2);
        test.testWork(employee);
        test.testWork(employee2);
    }
    public void showEmpAnnual(Employee employee){
        if(employee instanceof Worker){
            Worker worker=(Worker) employee;

            System.out.println(worker.getAnnualSalary());
        } else if (employee instanceof Manager) {
            Manager manager=( Manager)employee;

            System.out.println(manager.getAnnualSalary());
        }
    }
    public void testWork(Employee employee){
        if(employee instanceof Worker){
            Worker worker=(Worker) employee;
            worker.work();
        } else if (employee instanceof Manager) {
            Manager manager=( Manager)employee;
            manager.manage();
        }
    }
}
