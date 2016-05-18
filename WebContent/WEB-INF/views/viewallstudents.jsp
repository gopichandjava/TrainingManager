<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Student Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h3>Students List</h3>
<c:if test="${!empty listStudents}">
    <table class="tg">
    <tr>
        <th width="80">Student ID</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Course</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listStudents}" var="student">
        <tr>
            <td>${student.userId}</td>
            <td>${student.firstname}</td>
            <td>${student.lastname}</td>
            <td>${student.course}</td>
            <td><a href="<c:url value='/edit/${student.userId}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${student.userId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

</body>
</html>