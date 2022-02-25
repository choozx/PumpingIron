function productsSort() {
	$("#p_main_sort").change(function() {
		
		let sort_type = $('#p_main_sort option:selected').val();
		let p_type = $('#p_type').val();
		
		
		$.ajax({
			url: "/pi/products.sort",
			type: 'GET',
			datatype: 'json',
			data: {
				"p_sort" : sort_type,
				"p_type" : p_type
			},
			success : function(data) {
				alert("aaa");
				console.log(data);
				function successcall2(data) {
					data = data["products"];
					$.each(data, function(i, p) { 
						let img = $(p).find("p_img").text();
						let name = $(p).find("p_name").text();
						let price = $(p).find("p_price").text();
						
						alert("asd");
						$('#product_tb').append("<tr><td>" + name + "</td></tr>");
						$('#product_tb').append("<tr><td>" + price + "</td></tr>");
						
						//$('#product_div').append("<div id='product_img_div'><img class='container' src='resources/img/products/"+ img +".jpg'></div>");
						//$('#product_div').append("<div id='product_name_div'>"+ name +"</`div>");
						//$('#product_div').append("<div id='product_price_div'>"+ price +"</div>");
					})
				}
			},
			error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		    }
		})
	})
}

$(function () {
	productsSort();
})