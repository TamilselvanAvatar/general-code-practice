package generalPOJO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EmployeeMain {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// create List & ArrayList reference to store customers
		ArrayList<Employee> empList = new ArrayList<Employee>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter No of Employee : ");
		int noOfEmployee = Integer.parseInt(br.readLine());
		for (int i = 0; i < noOfEmployee; i++) {
			System.out.print("Enter Employee ID:");
			int employeeId = Integer.parseInt(br.readLine());
			System.out.print("Enter Employee Name:");
			String name = br.readLine();
			System.out.print("Enter Employee AppraisalRating:");
			float appraisalRating = Float.parseFloat(br.readLine());
			empList.add(new Employee(employeeId, name, appraisalRating));
		}
		EmployeeUtility empUtil = new EmployeeUtility();
		empUtil.addEmployee("empData.ser", empList);
		System.out.println("**** Serialization Completed..*******");

		System.out.println("**** De - Serialization Started..*******");
		System.out.print("Enter Employee ID:");
		Employee emp = empUtil.viewEmployeeById("empData.ser", Integer.parseInt(br.readLine()));
		System.out.println(emp);
	}

}
