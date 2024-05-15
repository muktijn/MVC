package com.apex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.apex.bean.UserBean;
import com.apex.service.UserService;
import com.apex.util.UserUtil;

/**
 * Servlet implementation class login
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = UserUtil.validateRegisterRequest(request);
		HttpSession session = request.getSession();
		if (error == null) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			UserBean userBean = new UserBean(userName, password);
			
			error = userService.checkNewUser(userBean);
			if (error == null) {
				userBean.setFirstName(firstName);
				userBean.setLastName(lastName);
				error = userService.addUser(userBean);
				if (error == null) {
				    RequestDispatcher requestDispatcher = request.getRequestDispatcher("successPage.jsp");
				    requestDispatcher.forward(request, response);
				}
			}
		}
		session.setAttribute("error", error);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterPage.jsp");
		requestDispatcher.forward(request, response);

	}

}