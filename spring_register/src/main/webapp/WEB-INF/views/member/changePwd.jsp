<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<style>
	body{
		margin-top:100px;
	}
</style>
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/js/jquery.validate.js"></script>
<script src="/resources/js/changepwd.js"></script>
<script>
   	$(function(){
   		var error='${error}';
   		if(error=='changeFailed'){
   			alert("비밀번호 변경 실패");
   		}else if(error=='wrongPassword'){
   			alert("현재 비밀번호와 일치하지 않습니다.")
   		}
   	});
</script>
</head>
<body>
<div class="card border-success mb-3 mx-auto" style="max-width: 25rem;">
  <div class="card-header">비밀번호 변경</div>
  <div class="card-body">
  	<form id="changePwd" method="post" action="goChangePwd">  		
		<div class="form-group row">
	   		<input type="password" class="form-control" size="50" 
	   			id="password" name="password" placeholder="현재 비밀번호" autofocus="autofocus">
	   		<small id="password" class="text-info"></small>
    	</div>
   		<div class="form-group row">
		    <input type="password" class="form-control" size="50" 
		     	id="new_password" name="new_password" placeholder="새 비밀번호">  
		    <small id="new_password" class="text-info"></small> 
		</div>
		<div class="form-group row"> 
		    <input type="password" class="form-control" size="50"
		        id="confirm_password" name="confirm_password" placeholder="새 비밀번호 확인">
		    <small id="confirm_password" class="text-info"></small> 
		</div>
		<div class="form-group row "> 
		    <button type="submit" class="btn btn-primary btn-block">변경</button>
		</div>		
    </form>
</div>
</div>
</body>
</html>