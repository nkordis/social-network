<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pgn"%>

<c:url var="url" value="/viewstatus" />

<pgn:pagination page="${page }" url="${url }" size="3" />



<c:forEach var="statusUpdate" items="${page.content}">

<c:set var="editLink" value="/editstatus?id=${statusUpdate.id}"/>
<c:set var="deleteLink" value="/deletestatus?id=${statusUpdate.id}"/>

	<div class="panel panel-default">

		<div class="panel-heading">
			<div class="panel-title">
				Status update added on
				<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
					value="${statusUpdate.added}" />
			</div>

		</div>

		<div class="panel-body">
			<div>${statusUpdate.text}</div>
			<div class="edit-links pull-right">
				<a href="${editLink}">edit</a> | <a onclick="confirm('Really want to delete this status?')" href="${deleteLink}">delete</a>
			</div>

		</div>

	</div>

</c:forEach>

