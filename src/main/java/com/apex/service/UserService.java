package com.apex.service;

import com.apex.bean.UserBean;
import com.apex.constants.UserConstants;
import com.apex.dao.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public String authenticateAndPopulateUser(UserBean userBean) {
		String error = null;
		
		userBean = UserDAO.getUserBean(userBean);
		if(userBean.getFirstName() == null) {
			error = UserConstants.INVALID_USER_CREDENTIALS;
		}
		
		return error;
	}
	
	public String checkNewUser(UserBean userBean) {
		String error = null;
		
		userBean = UserDAO.getUserBean(userBean);	
		if(userBean.getFirstName() != null) {
			error = UserConstants.USER_ALREADY_REGISTERED;
		}
		
		return error;
	}
	
	public String addUser(UserBean userBean) {
		String error = null;
	
		Boolean result = UserDAO.addUserBean(userBean);	
		if(result == false) {
			error = UserConstants.USER_REGISTERATION_ERROR;
		}	
		return error;
	}
	
	
}