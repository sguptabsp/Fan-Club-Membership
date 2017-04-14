<%@ page language="java" import="beans.MemberBean,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body bgcolor="cyan">
<%
ArrayList<MemberBean> member = (ArrayList<MemberBean>) request.getAttribute("member"); 
%>
<%
String msg=(String)request.getAttribute("msg");
%>

<script type="text/javascript">
function validate()
{
 var id=document.f.mID;
 if(id.selectedIndex ==0)
    {
    alert("Select Member Id from the List!");
    document.f.mID.focus();
    return false;
    }
   return true; 
}
function view()
{
    var id=document.f.mID;
	<%for( int i=0;i< member.size();i++)
	   {%>
	if(id.value=="<%= member.get(i).getMemberId() %>")
	{
	  document.f.fname.value="<%= member.get(i).getFirstName() %>";
	}
	<%}%>
 }
 
</script>
<FORM action="MainServlet" name="f" ><br><br>
<center>
 <% if(msg!=null){%>
<h2><%= request.getAttribute("msg")%></h2>
<%} %>
<br><br>
Member Id:<select name="mID" onchange="view();" >
<option selected>---select---</option>
<% for(int i=0; i<member.size();i++) 
{%>
<option value="<%= member.get(i).getMemberId() %>"><%= member.get(i).getMemberId() %></option>
<%}%>
</select>
<input type="text" name="fname" >
<input type="submit" name="submit" value="Delete" onclick="return validate();" ><br><br>
<input type="submit" name="submit" value="HOME"></center>
</FORM>
</body>
</html>