<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<c:if test="${user.getUserType() == 'admin'}">
username: "${user.getUsername()}" is an admin.
<div>
<br/>
<div>All users:</div><br/>
<c:forEach var="user" items="${allUsers}">
<c:out value="${user.getUsername()}"/><br/>
</c:forEach>
</div>

</c:if>

<c:if test="${user.getUserType() == 'user'}">
<div>
username: "${user.getUsername()}" is a regular user.
</div>
</c:if>
</div>