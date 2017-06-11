package trng.imcs.EmployeeWebServices;

import trng.imcs.EmployeeBeans.Department;
import trng.imcs.EmployeeBeans.Employee;
import trng.imcs.EmployeeDBImpl.EmployeeDBImpl;
import trng.imcs.EmployeeDBImpl.EmployeeDBInterface;
import trng.imcs.model.EmployeeInfo;

public class EmployeeOperations {

	EmployeeDBInterface dbImpl = new EmployeeDBImpl();

	public EmployeeInfo getEmployee(int empNo) {
		Employee emp = dbImpl.getEmployeeInfo(empNo);
		if (emp != null) {
			Department dept = dbImpl.getDepartmentName(empNo);
			double salary = dbImpl.getSalary(empNo);
			EmployeeInfo empInfo = new EmployeeInfo();
			empInfo.setNumber(emp.getNumber());
			empInfo.setDeptName(dept.getDeptName());
			empInfo.setFirstName(emp.getFirstName());
			empInfo.setLastName(emp.getLastName());
			empInfo.setSalary(salary);
			empInfo.setGender(emp.getGender());
			return empInfo;
		}else
			return null;

	}

	public boolean addOrUpdateEmployee(Employee emp, double salary, String deptName) {

		Employee existEmployee = dbImpl.getEmployeeInfo(emp.getNumber());
		// System.out.println(existEmployee);
		if (existEmployee == null) {
			return dbImpl.addnewEmployee(emp, salary, deptName);

		} else {
			return dbImpl.updateEmployee(emp, salary, deptName);
		}
	}
}
