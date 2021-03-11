public class EmpWageBuilder {
	//This is UC-6

	//constants
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static void main(String[] args) {
		//variables
		int totalEmpWage = 0;
		int totalEmpHrs = 0, totalWorkingDays = 0;

		//Computation
		while (totalWorkingDays < NUM_OF_WORKING_DAYS &&
			totalEmpHrs <= MAX_HRS_IN_MONTH) {
			int empCheck = (int)(Math.floor(Math.random() * 10) % 3);
			int empHrs = 0;
			switch (empCheck) {
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
					break;
			}
			int empWage = empHrs * EMP_RATE_PER_HOUR;
			totalEmpWage += empWage;
			System.out.println("EmployeeWage - " + empWage);
			totalWorkingDays++;
			totalEmpHrs += empHrs;
		}
		System.out.println("Total Employee Wage - " + totalEmpWage);
	}
}

