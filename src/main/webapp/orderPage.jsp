<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List,java.util.ArrayList, com.apex.bean.OrderBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome User <%= session.getAttribute("firstName") %>!</h1>
<%

	
	
	String error = (String) session.getAttribute("error");
	if(error != null){
		out.print(error);
		session.setAttribute("error",null);
	
	} else if (request.getAttribute("orderList") != null) {
		List<OrderBean> orders = (ArrayList<OrderBean>)request.getAttribute("orderList");
		out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=500>");
	    out.println("<tr><th>Order id</th><th>customerID</th><th>price</th><th>date</th><th>ShipperId</th></tr>");
	    for(int i=0;i<orders.size();i++) {
		     // Retrieve by column name
		    OrderBean obj = orders.get(i);
			out.println("<tr><td><center>"+obj.getOrderID()+"</center></td>"+
		               "<td><center>"+obj.getCustomerID()+
		               "<td><center>"+obj.getEmployeeID()+
		               "<td><center>"+obj.getOrderDate()+
		               "<td><center>"+obj.getShipperID()+
					   "</center></td></tr>");
		 }
		out.println("</table>");
    }
	
%>

</body>
</html>