<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
	
		<form:errors path="email"/>
		<form:errors path="password"/>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Create an Account</div>
			</div>
			<form:form method="post" modelAttribute="user" class="login-form">

				<div class="input-group">
					<form:input path="email" type="text" placeholder="Email" class="form-control"/>
				</div>
				<div class="input-group">
					<form:input path="password" type="password" placeholder="Password" class="form-control"/>
				</div>
				<div class="input-group">
					<input name="repeatpassword" type="password" placeholder="Repeat Password" class="form-control"/>
				</div>
				<div class="input-group">
					<button type="submit" class="btn-primary pull-right" >Register</button>
				</div>
			</form:form>
		</div>
	</div>
</div>