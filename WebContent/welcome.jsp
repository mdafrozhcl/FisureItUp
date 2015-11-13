<%@ page import="org.hibernate.*, java.util.*, com.wglen.fisure.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Fissure accounts, <span><%=session.getAttribute("username") %></span></h1>
<form action="/FisureItUp/expenses.jsp">

Enter description <input type="text" size=10 name="exname"/><br>
Total amount <input type="text" size=10 name="total"/><br>
Paid by: <select name="puser">
<%
Session s = (Session)session.getAttribute("hib_session");
s.beginTransaction();
Query q = s.createQuery("from FIU_User");
List<FIU_User> l = q.list();
for(FIU_User u: l){
	out.print("<option value="+u.getUid()+">"+u.getUname()+"</option>");
	}
%><br>
</select>
Split with: <select name="muser" multiple>
<%
for(FIU_User u: l){
	out.print("<option value="+u.getUid()+">"+u.getUname()+"</option>");
	}
%>
<br>
<input type="submit" value="split"/>
</form>
</body>
</html>