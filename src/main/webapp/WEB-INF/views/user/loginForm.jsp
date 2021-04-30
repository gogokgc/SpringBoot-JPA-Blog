<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- header part -->

<div class="container">

	<form action="#" method="post">
	
		<div class="form-group">
			<label for="username">username:</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input name="remember" class="form-check-input" type="checkbox"> Remember me</label>
		</div>
		
		<button id="btn-login" class="btn btn-primary">Login</button>
		
	</form>

		
</div>

<!-- <script src="/js/user.js"></script> -->

<!-- footer part -->

<%@ include file="../layout/footer.jsp"%>


