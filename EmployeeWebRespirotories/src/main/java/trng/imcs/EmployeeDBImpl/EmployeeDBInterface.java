package trng.imcs.EmployeeDBImpl;

import trng.imcs.EmployeeBeans.Department;
import trng.imcs.EmployeeBeans.Employee;

public interface EmployeeDBInterface {

	Employee getEmployeeInfo(int empNo);
	
	Department getDepartmentName(int empNo);
	
	double getSalary(int empNo);

	void setCommit(boolean flag);
	void setAutoCommit(boolean flag);
	boolean addnewEmployee(Employee emp,Double salary,String deptName);

	boolean updateEmployee(Employee emp, double salary, String deptName);

}
