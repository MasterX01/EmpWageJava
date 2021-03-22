import java.util.ArrayList;

public class EmpWageBuilderArray {
    public String company;
    public int empRatePerHour = 0;
    public int noOfWorkingDays = 0;
    public int maxHrsPerMonth = 0;
    public int totalEmpwage;
    public ArrayList<Integer> dailyWage = new ArrayList<Integer>();

    public EmpWageBuilderArray(String company, int empRatePerHour,int noOfWorkingDays,int maxHrsPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.noOfWorkingDays = noOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }
    public void setDailyWage(int dailyWage) {
        this.dailyWage.add(dailyWage);
    }

    public void setTotalEmpWage(int totalempwage) {
        this.totalEmpwage=totalempwage;
    }
    public String toString() {
        return "Total emp wage for company: " + company +" is: "+ totalEmpwage;
    }
}
