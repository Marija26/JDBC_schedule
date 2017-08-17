<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.08.2017
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="ScheduleController" name="frmAddSchedule">
    ID: <input type="text" readonly="readonly" name="id"
               value="<c:out value="${schedule.id}"/>"> <br/>
    SuserId  <input type="text" readonly="readonly" name="suserId"
               value="<c:out value="${schedule.suserId}"/>"><br/>
    StartLess: <input type="text" name="startLess"
                      value="<fmt:formatDate pattern="hh.mm" value="${schedule.startLess}"/>"/> <br/>
    EndLess: <input type="text" name="endLess"
                    value="<fmt:formatDate pattern="hh.mm" value="${schedule.endLess}"/>"/> <br/>
    Subject: <input type="text" name="subject"
                    value="<c:out value="${schedule.subject}"/>"> <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>




