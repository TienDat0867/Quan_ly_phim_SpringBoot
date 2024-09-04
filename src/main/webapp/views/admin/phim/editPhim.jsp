<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/users/createUsers.css" />

</head>
<body>
<br />
<div class="container">
	  <form:form modelAttribute="phim" action="/admin/phim/update/${phim.maphim }" method="post" enctype="multipart/form-data">
	  	  <div class="field" tabindex="1">
			<label >
				<i class="far fa-user"></i>Mã Khách Hàng
			</label>
			<form:input path="maphim" placeholder="Mã Phim(Auto)"  type="text" ></form:input>
			
		</div>
		<div class="field" tabindex="1">
			<label >
				<i class="far fa-user"></i>Tên Phim
			</label>
			<form:input path="tenphim" placeholder="Tên Phim"  type="text"></form:input>
			<form:errors path="tenphim" class="text-danger"></form:errors>
		</div>
		<div class="field" tabindex="3">
			<label >
				<i class="far fa-edit"></i>Thời Lượng
			</label>
			<form:input path="thoiluong" placeholder="Thời Lượng"  type="text"></form:input>
		</div>
		<div class="field" tabindex="3">
			<label >
				<i class="far fa-edit"></i>Quốc Gia
			</label>
			<form:input path="quocgia" placeholder="Quốc Gia"  type="text"></form:input>
		</div>
		<div class="field" tabindex="3">
			<label >
				<i class="far fa-edit"></i>Ngày Sản Xuất
			</label>
			<form:input path="ngaysanxuat" type="date" placeholder="Ngày Sản Xuất"  ></form:input>
		</div>
		<div class="field" tabindex="3">
			<label >
				<i class="far fa-edit"></i>Ảnh
			</label>
			<img src="${pageContext.request.contextPath}/images/${phim.hinhanh}" style="width:120px;height:100px" />
			<input name="photo" placeholder="Ảnh"  type="file"></input>
		</div>
		<button >Cập Nhật</button>
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