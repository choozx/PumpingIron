
$(function() {
	let idd = $("#likeId").val();
	let emaill = $("#likeEmail").val();
	let imgTag = $('.material-icons').children();
	likeCnt(idd);

	// 디테일 글 진임시 하트 표기 (채운거 or 빈거)
	$.ajax({
		url : "/pi/tipsLikes3",
		data : {
			'ajaxId' : idd,
			'ajaxEmail' : emaill
		},
		success : function(data) {
			console.log(data);
			if (data == 1) {
				// 하트 빨강색으로
				imgTag.attr("src", "resources/img/tips/heart-fill.svg");
				imgTag.attr("value", "1");
			} else {
				// 빈 하트로
				imgTag.attr("src", "resources/img/tips/heart.svg");
				imgTag.attr("value", "0");
			}

		}
	});

	// 좋아요 개수
	function likeCnt(idd) {
		console.log(idd);
		$.ajax({
			url : "/pi/tipsLikes3.cnt",
			data : {'br_no' : idd},
			success : function(data) {
				console.log(data + '??????????');
				$('.viewer-like').text(data)
			}
		});
	}

	// 하트 눌렀을때 이벤트 제어 (채움 하트, 빈하트)
	$('.material-icons').click(function() {

		let val = $(imgTag).attr("value");

		let myurl = '/pi/tipsLikes3.update';

		$.ajax({
			url : myurl,
			data : {
				'ajaxId' : idd,
				'ajaxEmail' : emaill,
				'val' : val
			},
			success : function(data) {
				if (data == 1) {
					// 하트 빨강색으로
					imgTag.attr("src", "resources/img/tips/heart-fill.svg");
					imgTag.attr("value", "1");

				} else {
					// 빈 하트로
					imgTag.attr("src", "resources/img/tips/heart.svg");
					imgTag.attr("value", "0");
				}
				likeCnt(idd);
			}

		});

	});

});
