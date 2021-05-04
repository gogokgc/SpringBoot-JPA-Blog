<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<!-- header part -->

<div class="container"></div>

<c:forEach var="board" items="${boards}">
	<div class="card m-2">
		<div class="card-body">
			<h4 class="card-title">${board.title}</h4>
			<a href="#" class="btn btn-primary">Detail</a>
		</div>
	</div>
</c:forEach>


<!-- footer part -->

<%@ include file="layout/footer.jsp"%>


