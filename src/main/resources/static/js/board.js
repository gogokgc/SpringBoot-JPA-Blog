let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
			this.save();
		});
		
	},
	
	save: function(){
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
		}).done(function(resp){
			// 요청 완료시
			alert("Posting completed");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	}
	
}

index.init();