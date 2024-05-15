package com.apex.service;

import java.util.List;

import com.apex.bean.OrderBean;
import com.apex.bean.UserBean;
import com.apex.constants.OrderConstants;
import com.apex.dao.OrderDAO;


public class OrderService {
	
	private OrderDAO orderDAO = new OrderDAO();

	public String populateOrderBeans(List <OrderBean> orderList) {
		String error = null;	
		orderList = OrderDAO.getOrderBeanList(orderList);
		if(orderList.size() == 0) {
			error = OrderConstants.NO_ORDER_FOUND;
		}
		
		return error;
	}

}
