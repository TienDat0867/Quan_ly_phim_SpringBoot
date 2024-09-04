<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>\
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Phim</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/admin/crud/indexCrud.css" rel="stylesheet">
</head>
  <body>  
    <!-- Left column -->
    <div class="templatemo-flex-row">
		<jsp:include page="${pageContext.request.contextPath}/views/admin/include/navadmin.jsp" flush="true"></jsp:include>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
  <jsp:include page="${pageContext.request.contextPath}/views/admin/include/topnavadmin.jsp" flush="true"></jsp:include>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                   <td>Mã Phim </td>
                   <td>Tên Phim</td>
                   <td>Ảnh</td>
                   <td>Ngày Sản Xuất</td>
                   	<td>Thời Lượng</td>
                    <td>Quốc Gia</td>
                    <td>Action</td>
                    <td>Delete</td>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ls_phim}" var="phim">
                  <tr>
                    <td>${phim.maphim}</td>
                    <td>${phim.tenphim}</td>
                    <td><img src="${pageContext.request.contextPath}/images/${phim.hinhanh}" class="img-fluid" style=" width:120px;height:80px;" /></td>
                    <td>${phim.ngaysanxuat}</td>
                    <td>${phim.thoiluong}</td>
                    <td>${phim.quocgia }</td>
                    <td><a href="/admin/phim/edit/${phim.maphim}" class="btn btn-primary templatemo-edit-btn">Chỉnh Sửa</a></td>
                    <td><a href="/admin/phim/delete/${phim.maphim}" class="btn btn-danger  templatemo-link">Xóa</a></td>
                  </tr>  
                  </c:forEach>                
                </tbody>
              </table>    <br></br>
              <a href="/admin/phim/create"><button class="btn btn-success">Thêm Mới</button></a> 
              
            </div>                          
          </div>          
          
          <br>
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>          
          <footer class="text-right">
            <p>Copyright © 2084 Company Name 
            | Design: HuongCinema</p>
          </footer>         
        </div>
      </div>
    </div>
    
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
  
</body>
</html>