<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="col-md-6 col-md-offset-2">


		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">Edit status update</div>
			</div>

			
				<form:form modelAttribute="statusUpdate">
				
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="added"/>
				
				
					<div class="errors">
						<form:errors path="text" />
						<form:errors path="id" />
						<form:errors path="added" />
					</div>

					<div class="form-group">
						<form:textarea path="text" name="text" rows="10" cols="10" />
					</div>
					<input type="submit" name="submit" value="edit Status" />
				</form:form>
			

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