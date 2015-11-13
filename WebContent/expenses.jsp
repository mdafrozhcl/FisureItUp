<%@page import="org.hibernate.Session"%>
<%@page import="com.wglen.fisure.FIU_Split"%>
<%@page import="com.wglen.fisure.FIU_Expenses"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Session s= (Session) session.getAttribute("hib_session");
s.beginTransaction();
String exname = request.getParameter("exname");
double total = Double.parseDouble(request.getParameter("total"));
int uid = Integer.parseInt(request.getParameter("puser"));
String[] suid = request.getParameterValues("muser");
FIU_Expenses expenses = new FIU_Expenses();
expenses.setUid(uid);
expenses.setExname(exname);
expenses.setTotal((float)total);
s.save(expenses);
int size = suid.length;
float splitted_total = (float)total/(float)size;

for(String u: suid){
FIU_Split splitIt = new FIU_Split();
splitIt.setSplittedTotal(splitted_total);
splitIt.setUid(Integer.parseInt(u));
splitIt.setExid(expenses.getExid());

}
s.getTransaction().commit();
s.close();
%>
</body>
</html>