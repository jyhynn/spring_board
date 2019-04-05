<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/resources/css/signin.css"/>
<title>Insert title here</title>
</head>
<body>
<form class="form-signin" action="signin" method="post">  
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
</form>
</body>
</html>