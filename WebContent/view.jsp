<%@ page language="java" import="beans.MemberBean,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<form action="MainServlet"><center>
<%
ArrayList<MemberBean> member = (ArrayList<MemberBean>) request.getAttribute("member"); 
%>
<table>
<%for(int i=0;i<member.size();i++){ %>
<tr>
<td>MemberId</td>
<td><%= member.get(i).getMemberId() %></td>
</tr>
<tr>
<td>First Name</td>
<td><%= member.get(i).getFirstName() %></td>
</tr>
<tr>
<td>LastName</td>
<td><%= member.get(i).getLastName() %></td>
</tr>
<tr>
<td>Contact No</td>
<td><%= member.get(i).getContNum() %></td>
</tr>
<%} %>
</table>
<br><br>
<input type="submit" name="submit" value="HOME"></center>
</form>
</body>
</html>