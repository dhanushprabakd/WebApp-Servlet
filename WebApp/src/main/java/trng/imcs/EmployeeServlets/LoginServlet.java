package trng.imcs.EmployeeServlets;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trng.imcs.EmployeeWebServices.LoginValidation;
import trng.imcs.model.UserInfo;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, String> loginMap;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		loginMap = new HashMap<>();
		
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		loginMap.put("abc", "abc");
		loginMap.put("cba", "cba");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginValidation validation = new LoginValidation();
		String user = request.getParameter("userName");
		String password = request.getParameter("password");
		UserInfo userDetails = new UserInfo();
		userDetails.setUserId(user);
		userDetails.setLoginTime(new Date());
		boolean validationFlag = validation.ValidateCredentials(user, password, loginMap);
		if (validationFlag) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userDetails);
			RequestDispatcher homeDispatcher = request.getRequestDispatcher("/home.jsp");
			homeDispatcher.forward(request, response);
		} else {
			request.setAttribute("message", "Invalid User");
			RequestDispatcher errorDispatcher = request.getRequestDispatcher("/login.jsp");
			errorDispatcher.forward(request, response);
		}
	}
}
