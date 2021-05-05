let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
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
			alert("Posting completed");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	},

	deleteById: function() {
		var id = $("#id").text();

		$.ajax({
			// 수행 요청
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json"
		}).done(function(resp) {
			// 요청 완료시
			alert("Delete completed");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	}

}

index.init();