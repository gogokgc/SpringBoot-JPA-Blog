<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- header part -->

<div class="container">

	<span class="float-right">
	<c:if test="${board.user.id == principal.user.id}">
		<a class="btn btn-warning text-white" href="/board/${board.id}/updateForm">Edit</a>
		<button id="btn-delete" class="btn btn-danger">Delete</button>
	</c:if>
	</span> <br> <br>
	<div>
		Posting Number : <span id="id"><i>${board.id}</i></span>
	  	&nbsp;&nbsp;&nbsp;Writer : <span><i>${board.user.username} </i></span>
	</div>
	<br>
	<div class="form-group">
		<h4>${board.title}</h4>
	</div>

	<hr />

	<div class="form-group">
		<div>${board.content}</div>
	</div>
	<hr />

	<button class="btn btn-secondary" onclick="history.back()">back</button>
</div>

<script src="/js/board.js"></script>

<!-- footer part -->

<%@ include file="../layout/footer.jsp"%>


