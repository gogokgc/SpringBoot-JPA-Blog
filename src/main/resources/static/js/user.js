let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
			this.save();
		});
		
		$("#btn-update").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
			this.update();
		});
	},
	
	save: function(){
		//alert('calling user function');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		//console.log(data);
		
		// ajax호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
		
		$.ajax({
			// 회원가입 수행 요청
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), //http body 데이터 //위의 let data 는 자바스크립스 오브젝트로 자바에서 이해할수있게 json으로 변형시켜 전달
			contentType: "application/json; charset=utf-8", // 바디데이터가 어떤 타입인지 (MIME)
			dataType: "json" // 요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열 (생긴게 json이라면)=>자바스크립트 오브젝트로 변경
		}).done(function(resp){
			// 요청 완료시
			alert("Member registration complete");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	},
	
	update: function(){
		let data = {
			id:$("#id").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		$.ajax({
			// 수행 요청
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			// 요청 완료시
			alert("Member information modificated successfully");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			// 요청 실패시
			alert(JSON.stringify(error));
		});
	}
	
}

index.init();