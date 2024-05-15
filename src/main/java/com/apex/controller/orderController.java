package com.apex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.apex.bean.OrderBean;
import com.apex.bean.UserBean;
import com.apex.service.OrderService;
import com.apex.service.UserService;
import com.apex.util.OrderUtil;
import com.apex.util.UserUtil;
import com.apex.constants.*;

/**
 * Servlet implementation class login
 */
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderService();


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<OrderBean> orders = new ArrayList<>();
		String error = "";
		if (session.getAttribute("firstName") == null) {
			error = UserConstants.USER_NOT_LOGGEDIN;
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.jsp");
			requestDispatcher.forward(request, response);
		}
		
	    /* get order details */
	    error = orderService.populateOrderBeans(orders);
		if (error == null) {
			request.setAttribute("orderList", orders); 
			//System.out.println(orders);
			request.getRequestDispatcher("orderPage.jsp").forward(request,response);
		}

	}

}