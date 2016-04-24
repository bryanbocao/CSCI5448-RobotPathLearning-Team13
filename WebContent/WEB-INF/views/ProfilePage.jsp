<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${message}" var="messageTest" varStatus="status">
    <tr>
        <td>${messageTest}</td>
    </tr>
</c:forEach>



<c:forEach items="${message}" var="message" varStatus="status">
    <tr>
        <td>${message}</td>
    </tr>
</c:forEach>
