<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<form action="MainServlet"><center>
<br><br>
Search by firstName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mr.<input type="radio" name="initials" value="Mr.">
Ms.<input type="radio" name="initials" value="Ms."><input type="text" name="fName"><br><br>
Search by Last Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lName"><br><br>
Search by Member Id &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="mID"><br><br>
<input type="submit" name="submit" value="search"></center>
</form>

</body>
</html>