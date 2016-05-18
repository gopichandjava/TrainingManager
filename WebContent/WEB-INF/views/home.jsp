<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hai gopi</h1>
<form:form method="GET" action="/TrainingManager/addstudent">
<table>
    <tr>
    <td>
    <input type="submit" value="Add student"/>
    </td>
    </tr>
</table>  
</form:form>

<form:form method="GET" action="/TrainingManager/viewallstudents">
<table>
    <tr>
    <td>
    <input type="submit" value="View all students"/>
    </td>
    </tr>
</table>  
</form:form>
</body>
</html>