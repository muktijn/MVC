package com.apex.util;

import com.apex.constants.UserConstants;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateLoginRequest(HttpServletRequest request) {
		String error = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if (userName.isEmpty() ||  password.isEmpty()) {
			error = UserConstants.EMPTY_USERNAME_PASSWORD;
		}
		return error;
	}
	
	public static String validateRegisterRequest(HttpServletRequest request) {
		String error = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		if (userName.isEmpty() ||  password.isEmpty() ||
				firstName.isEmpty() ||  lastName.isEmpty()) {
			error = UserConstants.EMPTY_USER_DETAILS;
		}
		return error;
	}

}