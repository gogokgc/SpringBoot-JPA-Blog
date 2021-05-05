let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
	},

	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			// 수행 요청
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 요청 완료시
			alert("Posting complete");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	},

	deleteById: function() {
		let id = $("#id").text();

		$.ajax({
			// 수행 요청
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json"
		}).done(function(resp) {
			// 요청 완료시
			alert("Delete complete");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	},

	update: function() {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			// 수행 요청
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 요청 완료시
			alert("Edit complete");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	},
}

index.init();