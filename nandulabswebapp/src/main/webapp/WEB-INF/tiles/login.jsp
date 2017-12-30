<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="loginUrl" value="/login" />

<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-default">
			<c:if test="${param.error != null }">
				<div class="login-error">Incorrect Username and Password</div>
			</c:if>
			<div class="panel-heading">
				<div class="panel-title">User Login Page</div>
			</div>
			<div class="panel-body">
				<form:form action="${loginUrl}" method="post" class="login-form">
					<div class="input-group">
						<input type="text" name="username" placeholder="Username"
							class="form-control" />
					</div>
					<div class="input-group">
						<input type="password" name="password" placeholder="Password"
							class="form-control" />
					</div>
					<div class="input-group">
						<button type="submit" class="btn primary pull right">Sign
							In</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>