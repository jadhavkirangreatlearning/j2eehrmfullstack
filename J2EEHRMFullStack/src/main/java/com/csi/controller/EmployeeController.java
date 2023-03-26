package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOW_PAGE = "/show.jsp";
	String EDIT_PAGE = "/edit.jsp";

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	/**
	 * Default constructor.
	 */
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String redirect = "";

		String empId = request.getParameter("empid");

		String action = request.getParameter("action");

		if (empId != null && action.equals("signup")) {

			int employeeId = Integer.parseInt(empId);

			String empName = request.getParameter("empname");

			String empAddress = request.getParameter("empaddress");

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));

			int empAge = Integer.parseInt(request.getParameter("empage"));

			double empSalary = Double.valueOf(request.getParameter("empsalary"));

			String empGender = request.getParameter("empgender");

			Date empDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				empDOB = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(employeeId, empName, empAddress, empContactNumber, empAge, empSalary,
					empGender, empDOB, empEmailId, empPassword);

			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {
			
			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");
			
			if(employeeServiceImpl.signIn(empEmailId, empPassword)) {
				
				request.setAttribute("empList", employeeServiceImpl.getAllData());
				redirect= SHOW_PAGE;
			}else {
				
				request.setAttribute("message", "Oops Please try again!! Invalid credentials");
				
				redirect= SIGNIN_PAGE;
			}
			

		} else if (action.equals("edit_form")) {
			redirect = EDIT_PAGE;

		} else if (action.equals("edit")) {
			
			
			int employeeId = Integer.parseInt(request.getParameter("empid"));

			String empName = request.getParameter("empname");

			String empAddress = request.getParameter("empaddress");

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));

			int empAge = Integer.parseInt(request.getParameter("empage"));

			double empSalary = Double.valueOf(request.getParameter("empsalary"));

			String empGender = request.getParameter("empgender");

			Date empDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				empDOB = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(employeeId, empName, empAddress, empContactNumber, empAge, empSalary,
					empGender, empDOB, empEmailId, empPassword);
			
			
			employeeServiceImpl.updateData(employeeId, employee);
			
			request.setAttribute("empList", employeeServiceImpl.getAllData());
			
			redirect= SHOW_PAGE;
			

		} else if (action.equals("delete")) {
			
			int employeeId = Integer.parseInt(request.getParameter("empid"));
			
			employeeServiceImpl.deleteDataById(employeeId);
			
			request.setAttribute("empList", employeeServiceImpl.getAllData());
			
			redirect= SHOW_PAGE;

		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
