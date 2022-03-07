<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
Kakao.init("d8c700a991666a81ea5a505838e662a1");
console.log(Kakao.isInitialized());


	

function loginWithKakao() {
	Kakao.Auth.createLoginButton({

        container: '#kakao-login-btn',

        success: function(authObj) {

          Kakao.API.request({
     
            url: '/v2/user/me',

            success: function(res) {

       //         alert(JSON.stringify(res));

       //         alert(JSON.stringify(authObj));

                  console.log(res.id);
                  console.log(res.connected_at);
                  console.log(res.kakao_account.email);
                  console.log(res.properties['nickname']);
                  console.log(res.properties['profile_image']);
                  console.log(authObj.access_token);
					
                  Kakao.Auth.setAccessToken(authObj.access_token);
                  
                  let id = res.id;
                  let connected_at = res.connected_at;
                  let email = res.kakao_account.email;
               	  let name = res.properties['nickname'];
               	  let profile_image = res.properties['profile_image'];
               	  let tocken = authObj.access_token;
               	  
               	  console.log(id);
               	  console.log(connected_at);
               	  console.log(email);
               	  console.log(name);
               	  console.log(profile_image);
              	  console.log(tocken);
              	  
              	  
$(function() {
	$('#id').val(id);
	$('#connected_at').val(connected_at);
	$('#email').val(email);
	$('#name').val(name);
	$('#profile_image').val(profile_image);
	$('#tocken').val(tocken);
	
	let m_pw = $('input[name=id]').val();
	let m_name = $('input[name=name]').val();
	let m_email = $('input[name=email]').val();
	let m_photo = $('input[name=profile_image]').val();
	let m_regdate = $('input[name=connected_at]').val();
	
	 location.href="member.kakaoGO?email=" + m_email + "&name=" + m_name + "&profile_image=" + m_photo + "&connected_at=" + m_regdate + "&id=" + m_pw

});
                }

              })

            },

            fail: function(error) {

              alert(JSON.stringify(error));

            }

          });
  }


</script>
</head>
<body>

<form action="member.login.do" method="post">
	<div class="wrap">
		<div class="login" style="border: 1px solid gray; margin-top: 70px;">
			<h1 class="mb-3" style="color: black; font-family: facon; text-align: center;">Pumping Iron</h1>
			<div class="login_id">
				<h4>Email</h4>
				<input type="email" name="m_email" id="" placeholder="Email">
			</div>
			<div class="login_pw">
				<h4>Password</h4>
				<input type="password" name="m_pw" id="" placeholder="Password">
			</div>
			<div class="login_etc">
				<div class="checkbox">
					<a href="member.join.go">회원가입</a>
				</div>
				<div class="forgot_pw">
					<a href="">아이디・비밀번호 찾기</a>
				</div>
			</div>
			<div class="submit">
				<input type="submit" value="Sign in">
			</div>
				<div class="mt-2"><a id="kakao-login-btn" href="javascript:loginWithKakao();">
  <img src="https://kauth.kakao.com/public/widget/login/kr/kr_02_medium.png" onmouseover="this.src='https://kauth.kakao.com/public/widget/login/kr/kr_02_medium_press.png'" onmouseout="this.src='https://kauth.kakao.com/public/widget/login/kr/kr_02_medium.png'" style="cursor: pointer">
</a></div>
	<input type="hidden" id="id" name="id" value="">
	<input type="hidden" id="connected_at" name="connected_at" value="">
	<input type="hidden" id="email" name="email" value="">
	<input type="hidden" id="name" name="name" value="">
	<input type="hidden" id="profile_image" name="profile_image" value="">
	<input type="hidden" id="tocken" name="tocken" value="">
		</div>
	</div>
<<<<<<< HEAD
	
=======
</form>

>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f


</body>
</html>