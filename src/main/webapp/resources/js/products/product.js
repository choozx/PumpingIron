function productsSort() {
	$("#p_main_sort").change(function() {
		
		let sort_type = $('#p_main_sort option:selected').val();
		let p_type = $('#p_type').val();
		let pageNo = $('#pageNo').val();
		
		$.ajax({
			url: "/pi/products.sort",
			type: 'GET',
			datatype: 'xml',
			data: {
				"p_sort" : sort_type,
				"p_type" : p_type,
				"pageNo" : pageNo
			},
			success : function(data) {
				$("#products_div").empty();
				console.log(data);
				$("#products_div_first").hide();
				
				$('#products_div').append("<div class='row' id='products_div_in'></div>")
				data = $(data).find('pproducts');
				$.each(data, function(i, p) { 
					
					let img = $(p).find("p_img").text();
					let name = $(p).find("p_name").text();
					let price = $(p).find("p_price").text();
					let no = $(p).find("p_no").text();
					
					$('#products_div_in').append("<div class='col-sm-12 col-lg-3 product_div' id='product_div" + i + "'><a id='product_a" + i + "' href='product.detail?p_no="+ no +"'></a></div>");
					
					$('#product_a' + i).append("<div><img id='product_img_div' class='container' src='resources/file/"+ img +"'></div>");
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


function deleteProduct() {
	$('#delBtn').click(function() {		
		let ok = confirm('정말 삭제 하시겠습니까?');
		let p_no = $('#product_no').val();
		if (ok) {
			location.href = 'deletePeoduct.do?p_no=' + p_no;
		}
	})
}


$(function () {
	productsSort();
	deleteProduct();
})