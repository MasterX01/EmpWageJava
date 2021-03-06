import java.util.ArrayList;
import java.util.HashMap;

public class EmpWageBuilder implements IComputeEmpWage {
	//This is UC-8

	//constants
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	static int numOfCompany=0;
	public ArrayList<EmpWageBuilderArray> companyEmpWageArrayList = new ArrayList<EmpWageBuilderArray>();
	public HashMap<String, EmpWageBuilderArray> companyToTotalWage;

	public EmpWageBuilder() {
		companyToTotalWage = new HashMap<>();
	}

	public void addCompanyEmpWage(String company,int empRatePerHour,int noOfWorkingDays,int maxHrsPerMonth) {
		EmpWageBuilderArray companyObj = new EmpWageBuilderArray(company,empRatePerHour,noOfWorkingDays,maxHrsPerMonth);
		companyEmpWageArrayList.add(companyObj);
		companyToTotalWage.put(company, companyObj);
		numOfCompany++;
	}

	public void computeWage() {
		for (int i = 0; i < companyEmpWageArrayList.size(); i ++) {
			companyEmpWageArrayList.get(i).setTotalEmpWage(this.computeWage(companyEmpWageArrayList.get(i)));
			System.out.println(companyEmpWageArrayList.get(i));
		}
	}

	public int empHrCheck() {
		int empHr=0;
		int empcheck=(int)Math.floor(Math.random()*10)%3;
		switch(empcheck) {
			case IS_PART_TIME:
				empHr = 4;
				break;
			case IS_FULL_TIME:
				empHr = 8;
				break;
			default:
				empHr = 0;
				break;
		}
		return empHr;
	}
	public int computeWage(EmpWageBuilderArray obj) {
		int totalEmpHrs=0, totalWorkingDays=0;
		while(totalEmpHrs<=obj.maxHrsPerMonth && totalWorkingDays<obj.noOfWorkingDays) {
			totalWorkingDays++;
			int empHrs = empHrCheck();
			totalEmpHrs+=empHrs;
			System.out.println("Day: "+totalWorkingDays+" Hours Worked:"+ empHrs);
			obj.setDailyWage(empHrs*obj.empRatePerHour);
		}
		return totalEmpHrs * obj.empRatePerHour;
	}

	@Override
	public int getTotalWage(String company) {
		return companyToTotalWage.get(company).totalEmpwage;
	}

	public static void main(String[] args) {
		EmpWageBuilder obj = new EmpWageBuilder();
		obj.addCompanyEmpWage("DMart",20,2,10);
		obj.addCompanyEmpWage("NE", 10, 5, 20);
		obj.addCompanyEmpWage("Reliance",20,2,10);
		obj.computeWage();
		System.out.println("Total Wage for Dmart is " + obj.getTotalWage("DMart"));

	}
}

