package com.apex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.apex.bean.OrderBean;


public class OrderDAO {
	
	public static List<OrderBean> getOrderBeanList(List<OrderBean> orderbeans) {

		
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

			PreparedStatement statement = connection
					.prepareStatement("select * from orders");
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				OrderBean e = new OrderBean(resultSet.getInt(1), resultSet.getInt(2),
				  resultSet.getInt(3), resultSet.getDate(4), resultSet.getInt(5));
				orderbeans.add(e);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return orderbeans;
	}

	private static OrderBean Orderbean(int int1, int int2, int int3, Date date, int int4) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
