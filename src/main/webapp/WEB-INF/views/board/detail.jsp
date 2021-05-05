<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- header part -->

<div class="container">

	<span class="float-right">
		<button class="btn btn-warning">Edit</button>
		<button class="btn btn-danger">Delete</button>
	</span> <br> <br>
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


