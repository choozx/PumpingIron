function pleaseLogin_calendar() {
	
	alert('로그인을 해주세요!');
	
}



function login_check() {
	
	login = document.getElementById('loginCheck').value;
	
	if (login == '' || login == null) {
		alert('회원전용 기능입니다!');
//		return false;
	}
	
}





$(function() {
	
	
/*	$('.delRoutine').click(function() {
		
		if (confirm('정말로 삭제하시겠습니까?')) {
			
		}
	});*/
	

	/*$('#input-data').click(function() {
		
		let routineVal = $('#input-box').val();
		
		if ($('#input-box').val() != "") {
			
			$.ajax({
				url : 'routine.insert',
				
				type : 'GET',
				
				dataType : 'xml',
				
				data : {
					"cr_text" : routineVal
			},
			
			success : function(data) {
				$("#todaysRoutine").empty();
				console.log(data);
				successRoutineSelect(data);
				
			}
			
			});
			
		}
		
		
	});
	
	function successRoutineSelect(data) {
		
		data = $(data).find('routines');

		console.log(data);
		
		$.each(data, function(i, rr) {
			//console.log(data[i]);	// 같은
			console.log(rr);		//  결과
			
			let text = $(m).find("cr_text").text(); // 안에 내용 보는 거
			
			console.log(text);
			
			$("#todaysRoutine").append("<div>" + - text + "<a>" + X + "</a>" 
					+ "</div>");
		});
		
	}*/
	
	
});

