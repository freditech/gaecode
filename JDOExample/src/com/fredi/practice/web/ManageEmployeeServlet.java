package com.fredi.practice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fredi.practice.model.Employee;

public class ManageEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		System.out.println("\n\t POST: Employee Management Servlet...");
		System.out.println("\n\t Request.getParameter(create): "+req.getParameter("create"));
		if(req.getParameter("create")!=null && !"".equals(req.getParameter("create"))){
			System.out.println("\n\tCreating a new employee..");
			Employee emp = Employee.createNew();
			emp.setName(req.getParameter("empName"));
			emp.add();
			System.out.println("\n\t DONE: Creating a new employee..");
			req.getRequestDispatcher("/empList.jsp").forward(req, resp);
		}else{
			System.out.println("\n\t Create button not clicked.. " );
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\n\t GET: Employee Management Servlet...");
		System.out.println("\n\t Request.getParameter(action): "+req.getParameter("action"));
		if("delete".equals(req.getParameter("action"))){
			Long id = Long.parseLong(req.getParameter("id"));
			Employee.delete(id);
			System.out.println("Employee with id: "+id+" is deleted now.");
			req.getRequestDispatcher("/empList.jsp").forward(req, resp);
		}
	}

}
