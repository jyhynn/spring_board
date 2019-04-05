<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- 모바일/데스크탑 등으로 들어오는 장치 구분해서 반응형웹으로 만들어줌 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="/mvc_dbcp_books/insert.do" method="post">
		<div class="form-group">
			<label for="code">code</label>
			<input type="text" class="form-control" id="code" name="code" placeholder="도서코드입력" required="required"/>
		</div>
		<div class="form-group">
			<label for="title">title</label>
			<input type="text" class="form-control" name="title" placeholder="도서제목입력" required="required"/>
		</div>
		<div class="form-group">
			<label for="writer">writer</label>
			<input type="text" class="form-control" name="writer" placeholder="도서저자입력" required="required"/>
		</div>
		<div class="form-group">
			<label for="price">price</label>
			<input type="number" class="form-control" id="price" name="price" placeholder="도서가격입력" required="required"/>
		</div>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</form>


</body>
</html>