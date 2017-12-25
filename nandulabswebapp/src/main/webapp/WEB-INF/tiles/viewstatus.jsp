<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jwp"%>
<c:url var="url" value="/viewstatus" />


<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<jwp:pagination page="${page}" url="${url}" size="10" />
		<c:forEach var="statusUpdate" items="${page.content }">
			<c:url var="editLink"  value="/editstatus?id=${statusUpdate.id}"/>
			<c:url var="deleteLink"  value="/deletestatus?id=${statusUpdate.id}"/>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<fmt:formatDate value="${statusUpdate.added}" type="both" />
					</div>
				</div>
				<div class="panel-body">
					<div>${statusUpdate.text}</div>
					<div class="edit-links pull-right">
						<a href="${editLink}">Edit</a>|<a onclick="return confirm('Do you want to delete this status ?')" href="${deleteLink}">Delete</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>