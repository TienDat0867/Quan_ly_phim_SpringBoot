<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>Visual Admin</h1>
        </header>
        <div class="profile-photo-container">
          <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">  
          <div class="profile-photo-overlay"></div>
        </div>      
        <!-- Search box -->
        <form class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">           
          </div>
        </form>
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
            <li><a href="/admin/index" class="active"><i class="fa fa-home fa-fw"></i>Quản Lý</a></li>
            <li><a href="data-visualization.html"><i class="fa fa-bar-chart fa-fw"></i>Biểu Đồ</a></li>
            <li><a href="data-visualization.html"><i class="fa fa-database fa-fw"></i>Thống kê doanh thu</a></li>
            <li><a href="/admin/phim"><i class="fa fa-map-marker fa-fw"></i>Quản Lý Kho Phim</a></li>
            <li><a href="/admin/users"><i class="fa fa-users fa-fw"></i>Quản Lý Khách Hàng</a></li>
            <li><a href="/admin/orders"><i class="fa fa-users fa-fw"></i>Quản Lý Hóa Đơn </a></li>
            <li><a href="preferences.html"><i class="fa fa-sliders fa-fw"></i>Quản Lý Lịch Chiếu</a></li>
            <li><a href="login.html"><i class="fa fa-eject fa-fw"></i>Đăng Xuất</a></li>
          </ul>  
        </nav>
      </div>