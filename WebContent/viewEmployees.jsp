<!-- @author ooha -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<%-- ${requestScope.userlist} --%>

<c:forEach var="asd" items="${requestScope.userlist}">
    <%-- This calls the getId() method on your asd object --%>
    OID : <c:out value="${asd.oID}"/><br>
    <%-- This calls the getName() method on your asd object --%>
    NAME : <c:out value="${asd.name}"/><br>
    <%-- This calls the getAge() method on your asd object --%>
    FINE : <c:out value="${asd.fine}"/><br>
     <%-- This calls the getAge() method on your asd object --%>
    TIMES LATE :<c:out value="${asd.timeslate}"/><br>
    
    <br><br><br>
</c:forEach>
<button type="button" value="ViewEmployee"
						onclick="location.href='admin.jsp'">GoBack</button>
<div id="divbody"></div>
</body>
</html>