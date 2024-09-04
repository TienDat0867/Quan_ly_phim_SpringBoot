<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Khách Hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/users/createUsers.css" />

</head>
<body>
<br />
<div class="container">
	  <form:form modelAttribute="khachhang" action="/admin/users/store" method="POST" enctype="multipart/form-data">
	  <div class="field" tabindex="1">
			<label >
				<i class="far fa-user"></i>Mã Khách Hàng
			</label>
			<form:input path="makh" placeholder="Mã Khách Hàng (Auto)"  type="text" readonly="true"></form:input>
			
		</div>
		<div class="field" tabindex="1">
			<label >
				<i class="far fa-user"></i>Tên Khách Hàng
			</label>
			<form:input path="hoten" placeholder="Họ tên"  type="text"></form:input>
			<form:errors path="hoten" class="text-danger" style="font-weight:bold"></form:errors>
		</div>
		<div class="field" tabindex="2">
			<label >
				<i class="far fa-envelope"></i> Email
			</label>
			<form:input path="email" placeholder="Email"  type="text"></form:input>
			<form:errors path="email" class="text-danger" style="font-weight:bold"></form:errors>
		</div>
		<div class="field" tabindex="3">
			<label ">
				<i class="far fa-edit"></i>Địa Chỉ
			</label>
			<form:input path="diachi" placeholder="Địa Chỉ"  type="text"></form:input>
			<form:errors path="diachi" class="text-danger" style="font-weight:bold"></form:errors>
		</div>
		<div class="field" tabindex="3">
			<label ">
				<i class="far fa-edit"></i>Số điện thoại
			</label>
			<form:input path="sodienthoai" placeholder="Số điện thoại"  type="text"></form:input>
			<form:errors path="sodienthoai" class="text-danger" style="font-weight:bold"></form:errors>
		</div>
		<div class="field" tabindex="3">
			<label ">
				<i class="far fa-edit"></i>Ngày Sinh
			</label>
			<form:input path="ngaysinh" type="date" placeholder="Ngày sinh"  ></form:input>
			<form:errors path="ngaysinh" class="text-danger" style="font-weight:bold"></form:errors>
		</div>
		<div class="field" tabindex="3">
			<label ">
				<i class="far fa-edit"></i>Ảnh
			</label>
			<input name="photo" placeholder="Ảnh"  type="file"></input>
		</div>
		<button >Tạo Mới</button>
		<div class="social-media">
			<a class="fab fa-facebook-f" href="https://facebook.com/uzcho" target="blank_"></a>
			<a class="fab fa-twitter" href="https://twitter.com/uzcho_" target="blank_"></a>
			<a class="fab fa-instagram" href="https://www.instagram.com/uzcho_" target="blank_"></a>
			<a class="fab fa-codepen" href="https://codepen.io/uzcho_" target="blank_"></a>
		</div>
	</form:form>
</div>

<!-- This is not part of Pen -->
<a class="me" href="https://codepen.io/uzcho_/pens/popular/?grid_type=list" target="_blank" style="color:#000"></a>
</body>
</html>