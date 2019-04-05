/**
 * modifyForm.jsp
 */

$(function() {
	$("#changePwd").validate({
		errorPlacement:function(error,element){ 
			$(element).closest("form")
			.find("small[id='"+element.attr("id")+"']")
			.append(error);
			},
		rules : {
			password : {
				required : true,
				/*remote : {
					url : "checkPwd",
					type : "post",
					data : {
						password : function() {
							return $('#password').val();
						}
					}
				}*/
			},
			new_password : {
				required : true,
				validNewPass : true
			},
			confirm_password : {
				required : true,
				equalTo : "#new_password"
			}
		},
		messages : {
			password : {
				required : "현재 비밀번호를 입력해주세요"/*,*/
				//remote: "현재 비밀번호가 일치하지 않습니다.",
			},
			new_password : {
				required : "새 비밀번호를 입력해주세요"
			},
			confirm_password : {
				required : "다시 한번 새 비밀번호를 입력해주세요"
			}
		}
	});

$.validator.addMethod("validNewPass",function(value) {
var regNewPass = /^(?=.*[a-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
return regNewPass.test(value);
}, '비밀번호는 문자, 숫자, 특수문자 조합으로 8~15자 사이로 입력해주세요.');});
