package trng.imcs.EmployeeServlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.imcs.EmployeeBeans.Employee;
import trng.imcs.EmployeeWebServices.EmployeeOperations;

/**
 * Servlet implementation class EmployeeAddUpdateServlet
 */
public class EmployeeAddUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeOperations operations = new EmployeeOperations();
		String empNo = request.getParameter("empNo");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary = Double.parseDouble(request.getParameter("Salary"));
		String gender = request.getParameter("gender");
		String deptName = request.getParameter("deptName");
		String birthDate = request.getParameter("birthDate");
		String hireDate = request.getParameter("hireDate");
		Employee employee = new Employee();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date tempDate = null;
		try {
			tempDate = sdf1.parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date tempHireDate = null;
		try {
			tempHireDate = sdf1.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlbirthDate = new java.sql.Date(tempDate.getTime());
		java.sql.Date sqlhireDate = new java.sql.Date(tempHireDate.getTime());
		
		
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setGender(gender);
		employee.setNumber(Integer.parseInt(empNo));
		employee.setBirthDate(sqlbirthDate);
		employee.setHireDate(sqlhireDate);
		boolean successFlag = operations.addOrUpdateEmployee(employee,salary,deptName);
		if(successFlag){
			request.setAttribute("addUpdatemsg", "Employee Added/Updated Successfully");
		}else{
			request.setAttribute("addUpdatemsg", "Error : Employee Added/Updated Successfully");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		
	}

}
