

package com.apex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apex.bean.UserBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

public class UserDAO {

	public static UserBean getUserBean(UserBean userBean) {

		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

			PreparedStatement statement = connection
					.prepareStatement("select * from user where username=? and password=?");
			statement.setString(1, userBean.getUserName());
			statement.setString(2, userBean.getPassword());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userBean.setFirstName(resultSet.getString(1));
				userBean.setLastName(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return userBean;
	}

	public static Boolean addUserBean(UserBean userBean) {
		
		Connection connection;
		int executeUpdate = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
		
		    PreparedStatement statement1 = connection.prepareStatement(
				"insert into user values(?,?,?,?)");
		    statement1.setString(1, userBean.getFirstName());
		    statement1.setString(2, userBean.getLastName());
		    statement1.setString(3, userBean.getUserName());
		    statement1.setString(4, userBean.getPassword());
		    executeUpdate = statement1.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return executeUpdate>0?true:false;
	}

}
