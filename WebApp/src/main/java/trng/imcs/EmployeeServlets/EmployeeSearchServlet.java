package trng.imcs.EmployeeServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.imcs.EmployeeWebServices.EmployeeOperations;
import trng.imcs.model.EmployeeInfo;

/**
 * Servlet implementation class EmployeeSearchServlet
 */
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		EmployeeOperations operations = new EmployeeOperations();
		EmployeeInfo empInfo = operations.getEmployee(empNo);
		if(empInfo!=null){
		request.setAttribute("empInfo", empInfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employeeDisplay.jsp");
		dispatcher.forward(request, response);
		}else{
			request.setAttribute("nouser", "No employees Found");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
