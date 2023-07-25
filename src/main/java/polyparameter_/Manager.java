package polyparameter_;

public class Manager extends Employee{
    int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int monthsalary,int bonus) {
        super(name, monthsalary);
        this.bonus=bonus;
    }

    @Override
    public int getAnnualSalary() {
        return super.getAnnualSalary()+bonus;
    }

    public void manage(){
        System.out.println("管理");
    }
}
