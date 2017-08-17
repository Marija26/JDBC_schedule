<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.07.2017
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>id</th>
        <th>SuserId</th>
        <th>StartLess</th>
        <th>EndLess</th>
        <th>Subject</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${schedules}" var="schedule">
        <tr>
            <td><c:out value="${schedule.id}"/></td>
            <td><c:out value="${schedule.suserId}"/></td>
            <td><fmt:formatDate pattern="hh-mm" value="${schedule.startLess}"/></td>
            <td><fmt:formatDate pattern="hh-mm" value="${schedule.endLess}"/></td>
            <td><c:out value="${schedule.subject}"/></td>
            <td><a href="ScheduleController?action=editSchedule&id=<c:out value="${schedule.id}"/>">Update</a></td>
            <td><a href="ScheduleController?action=deleteSchedule&id=<c:out value="${schedule.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="ScheduleController?action=insert">Add schedule</a></p>
<p><a href="UserController?action=listUser">Go to UserList</a></p>

</body>
</html>
