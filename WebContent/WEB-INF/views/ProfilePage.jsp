<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<c:if test="${userType == 'admin'}">
User is an admin.
</c:if>
<c:if test="${userType == 'user'}">
User is a regular user.
</c:if>
</div>