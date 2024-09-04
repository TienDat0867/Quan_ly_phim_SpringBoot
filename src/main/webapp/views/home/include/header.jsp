<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
      <script>
        function submitForm() {
            document.getElementById("filmForm").submit();
        }
    </script>

   <header class="header" data-header>
    <div class="container">

      <div class="overlay" data-overlay></div>

      <a href="/" class="logo">
        <img src="/images/logo.svg" alt="Filmlane logo">
      </a>

      <div class="header-actions">

        <button class="search-btn">
          <ion-icon name="search-outline"></ion-icon>
        </button>

        <div class="lang-wrapper">
          <label for="language">
            <ion-icon name="globe-outline"></ion-icon>
          </label>

          <select name="language" id="language">
            <option value="en">EN</option>
            <option value="au">AU</option>
            <option value="ar">AR</option>
            <option value="tu">TU</option>
          </select>
        </div>

        <c:choose>
	<c:when test="${not empty sessionScope.matk}">
		<a href="logout">
			<button class="btn btn-primary">Sign out</button>
		</a> 
	</c:when>
	<c:otherwise>
		<a href="/login">
			<button class="btn btn-primary">Sign in</button>
		</a> 
	</c:otherwise>
</c:choose>
		 <div class="toggle" >
                    <i class="fas fa-moon toggle-icon"></i>
                    <i class="fas fa-sun toggle-icon"></i>
                    <div class="toggle-ball"></div>
                </div>
      </div>

      <button class="menu-open-btn" data-menu-open-btn>
        <ion-icon name="reorder-two"></ion-icon>
      </button>

      <nav class="navbar" data-navbar>

        <div class="navbar-top">

          <a href="./index.html" class="logo">
            <img src="/images/logo.svg" alt="Filmlane logo">
          </a>

          <button class="menu-close-btn" data-menu-close-btn>
            <ion-icon name="close-outline"></ion-icon>
          </button>

        </div>

        <ul class="navbar-list">

          <li>
            <a href="/" class="navbar-link">Home</a>
          </li>
          <li>
            <a href="#" class="navbar-link">Tv Show</a>
          </li>

          <li>
            <a href="#" class="navbar-link">Pricing</a>
          </li>
          <li>
            <a href="/Admin/index111" class="navbar-link">Admin</a>
          </li>	
          <li><div style="position: absolute; top: 10px; right: 60px; transform: translate(50%, 0);">
					<div style="text-align: center;">
						<div
							style="display: inline-block; position: relative; text-align: left;">
							<div
								style="width: 100px; height: 100px; overflow: hidden; margin: 0 auto;">
								<a href="/themThongTinTaiKhoan/${sessionScope.matk}">
								<img style="width: 80%; height: 50%;"
									src="${pageContext.request.contextPath	}/imageNhanVien/${sessionScope.anh}">
									</a>
							</div>
							
							<div style="text-align: center;">
							<span style="color: white;">${sessionScope.tenNv}</span>	 <span style="color: white;">${sessionScope.chucVu}</span> 
							</div>
						</div>
					</div>
					</div>
          </li>
           <li>
           
            	 	<div class="lang-wrapper" >
	 			   <form id="filmForm" action="/home/ticket" method="GET">
				        <select class=" form-select-lg mb-3" name="maphim" onchange="submitForm()">
				            <option selected>Choose Film</option>
				            <c:forEach items="${ls_phim}" var="phim">
				                <option value="${phim.maphim}" ${phimChoose.maphim == phim.maphim ? 'selected' : ''} >${phim.tenphim}</option>
				            </c:forEach>
				        </select>
				    </form>
				    
	 			</div>
          </li>

        </ul>

        <ul class="navbar-social-list">

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-pinterest"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-youtube"></ion-icon>
            </a>
          </li>

        </ul>

      </nav>

    </div>
  </header>