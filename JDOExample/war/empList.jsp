<%@page import="java.util.List"%>
<%@page import="com.fredi.practice.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<script type="text/javascript">
</script>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td colspan="2" align="center" style="font-weight: bolder;">freditech Employee List </td>
		</tr>
		<tr>
			<th width="30%">Employee Id</th>
			<th>Employee Name</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
<%
	List<Employee> empList = Employee.getAllEmployees();
	for(Employee e : empList){		
 %>
 		<tr>
			<td align="center"><%=e.getId()%></td>
			<td align="left"><%=e.getName()%></td>
			<td align="center"><a href="http://localhost:8888/updateEmp.jsp?id=<%=e.getId()%>"><button>Update</button></a></td>
			<td align="center"><a href="http://localhost:8888/manageEmployee?id=<%=e.getId()%>&action=delete"><button>Delete</button></a></td>
		</tr>
 <%
 	}
  %>
  		<tr>
  			<td colspan="2"> <a href="http://localhost:8888/"> <button>Create New</button> </a></td>
  		</tr>
 	</table>
</body>
</html>