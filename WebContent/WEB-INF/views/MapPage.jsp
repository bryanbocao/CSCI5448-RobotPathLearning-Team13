<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<canvas id="cnv" width="600" height="600">
</canvas>

<img id="robot" src="<c:url value="/resources/images/robot.jpg" />"
	style="visibility: hidden" />

<a href="#toggle-mode" class="btn btn-default" id="toggle-mode">Inserting Obstacles</a>
<a href="#save" class="btn btn-default" id="save">Save Path</a>


<content tag="siteMeshJavaScript">
	<script src="<c:url value="/resources/js/grid.js" />" type="text/javascript"></script>	
</content>

