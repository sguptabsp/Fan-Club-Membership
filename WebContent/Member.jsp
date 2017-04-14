<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MainServlet" method="post">
Initials: Mr.<input type="radio" name="initials" value="Mr.">
Ms.<input type="radio" name="initials" value="Ms."><br>
First Name:<input type= "text" name="first" ><br>
Last Name:<input type= "text" name="last" ><br>
Contact Number:<input type= "text" name="cont" ><br>
Occupation:<select name="occup">
<option>Service</option>
<option>Busniess</option>
</select><br>
Home Address:<textarea rows="5" cols="15" name="home_add"></textarea><br>
Office Address:<textarea rows="5" cols="15" name="offc_add"></textarea><br>
Office Contact Number:<input type= "text" name="offc_cont" ><br>
Email Id:<input type= "text" name="email" ><br>
Annual Income:<select name="annualIncome">
<option>Above 300000</option>
<option>Above 500000</option>
<option>Above 1000000</option>
</select>
Membership Type:<select name="memberType">
<option>Silver</option>
<option>Gold</option>
<option>Platinum</option>
</select>
Credit Card No:<input type="text" name="cardno"><br> 
Agreement for deducting membership fees every year:<br>
I Agree:<input type="checkbox" name="agree" value="yes">
I do not Agree:<input type="checkbox" name="agree" value="no"><br><br>
<input type="submit" name="submit" value="submit">
<pre>


MEMBERSHIP FEES:

Silver: INR 10000 PA
Gold: INR 15000 PA
Platinum INR 20000 PA

</pre>
</form>
</body>
</html>