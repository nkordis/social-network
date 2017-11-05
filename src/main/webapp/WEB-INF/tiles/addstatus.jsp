<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="col-md-6 col-md-offset-2">


		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">Add a status update</div>
			</div>

			
				<form:form modelAttribute="statusUpdate">
					<div class="errors">
						<form:errors path="text" />
					</div>

					<div class="form-group">
						<form:textarea path="text" name="text" rows="10" cols="10" />
					</div>
					<input type="submit" name="submit" value="addStatus" />
				</form:form>
			

		</div>

		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">
					Status update added on
					<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
						value="${latestStatusUpdate.added}" />
				</div>

			</div>

			<div class="panel-body">
				<c:out value="${latestStatusUpdate.text}" />
			</div>

		</div>
	</div>

</div>

<script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
<script>
	tinymce.init({
		selector : 'textarea',
		plugins : 'link'
	});
</script>