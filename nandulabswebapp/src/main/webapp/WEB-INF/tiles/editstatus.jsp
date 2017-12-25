<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Edit Status Update</div>
			</div>
			<form:form modelAttribute="statusUpdate">
				<form:input type="hidden" path="id" />
				<form:input type="hiddemn" path="added" />

				<div class="errors">
					<form:errors path="text" />
					<form:errors path="id" />
					<form:errors path="added" />
				</div>
				<div class="form-group">
					<form:textarea path="text" name="text" rows="10" cols="50"></form:textarea>
				</div>
				<input type="submit" name="submit" value="Update Status">
			</form:form>
		</div>
	</div>
</div>

<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>tinymce.init({
		selector : 'textarea',
		plugin : 'link'
	});
</script>