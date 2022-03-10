function productsSort() {
	$("#p_main_sort").change(function() {
		
		let sort_type = $('#p_main_sort option:selected').val();
		let p_type = $('#p_type').val();
		
		$.ajax({
			url: "/pi/products.sort",
			type: 'GET',
			datatype: 'xml',
			data: {
				"p_sort" : sort_type,
				"p_type" : p_type
			},
			success : function(data) {
				$("#products_div").empty();
				console.log(data);
				$("#products_div_first").hide();
				
				data = $(data).find('pproducts');
				$.each(data, function(i, p) { 
					
					let img = $(p).find("p_img").text();
					let name = $(p).find("p_name").text();
					let price = $(p).find("p_price").text();
					let no = $(p).find("p_no").text();
					
					$('#products_div').append("<div class='product_div' id='product_div" + i + "'><a id='product_a" + i + "' href='product.detail?p_no="+ no +"'></a></div>");
					
					$('#product_a' + i).append("<div id='product_img_div'><img class='container' src='resources/img/products/"+ img +".jpg'></div>");
					$('#product_a' + i).append("<div id='product_name_div'>"+ name +"</`div>");
					$('#product_a' + i).append("<div id='product_price_div'>"+ price +"</div>");
				})
			},
			error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		    }
		})
	})
}


function productsFirstSort() {
	$("#p_type").click(function() {

		let sort_type = $('#p_type option:selected').val();
		alert(sort_type);
		/*$.ajax({
			url: "/pi/products.sort",
			type: 'GET',
			datatype: 'xml',
			data: {
				"p_sort" : sort_type,
				"p_type" : p_type
			},
			success : function(data) {
				$("#products_div").empty();
				console.log(data);
				
				data = $(data).find('products');
				$.each(data, function(i, p) { 
					
					let img = $(p).find("p_img").text();
					let name = $(p).find("p_name").text();
					let price = $(p).find("p_price").text();
					let no = $(p).find("p_no").text();
					
					$('#products_div').append("<div class='product_div' id='product_div" + i + "'><a id='product_a" + i + "' href='product.detail?p_no="+ no +"'></a></div>");
					
					$('#product_a' + i).append("<div id='product_img_div'><img class='container' src='resources/img/products/"+ img +".jpg'></div>");
					$('#product_a' + i).append("<div id='product_name_div'>"+ name +"</`div>");
					$('#product_a' + i).append("<div id='product_price_div'>"+ price +"</div>");
				})
			},
			error:function(request,status,error){
				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			}
		})*/
	})
}


$(function () {
	productsSort();
})