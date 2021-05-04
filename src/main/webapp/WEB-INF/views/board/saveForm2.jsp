<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- header part -->

<div class="container">

	<form>

		<div class="form-group">
			<label for="title">Title</label> <input type="text"
				class="form-control" placeholder="Enter title" id="title">
		</div>

		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>

		<button id="btn-save" class="btn btn-primary">Save</button>

	</form>

</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>

<!-- footer part -->

<%@ include file="../layout/footer.jsp"%>

