<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>BookSeat</title>


  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

  <!-- 
    - google font link
  -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Sen:wght@400..800&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ticket.css" />
   <script>
        function submitFilm() {
            document.getElementById("filmForm").submit();
        }
        function submitDay() {
        	document.getElementById("dayShow").submit();;
        }
        function submitTime() {
        	document.getElementById("timeShow").submit();;
        }
    </script>
    
        <style>
       	  .seat-link {
            width: 30px;
            height: 30px;
            background-color: #ccc;
            cursor: pointer;
          	 margin:5px 5px;
            text-decoration: none;
        }

       	 .seat-link.selected {
       	  width: 30px;
            height: 30px;
            background-color: red;
            cursor: pointer;
           margin:5px 5px;
            
        }
        
        .cinema-seating-container {
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    height: 100vh; /* Chiều cao 100% của viewport để căn giữa theo chiều dọc */
		}
        
        .cinema-seating {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
            gap: 0.5px;
            padding-left: 15px;
        }


        .seat a {
            text-decoration: none;
            color: inherit;
            font-size:12px;
            text-align:center;
        }
        .ticket
        {
 			color:white ; 
 			 font-family: Arial, sans-serif;
 			 font-size:15px;       
 			 padding-top:10px
        }
        .ticket h5
        {
            color: #f60;
        }
        
    </style>
</head>

<body id="#top">

  <!-- 
    - #HEADER
  -->

  <jsp:include page="${pageContext.request.contextPath}/views/home/include/header.jsp"></jsp:include>

  <main>
    <article>

      <!-- 
        - #MOVIE DETAIL
      -->
      
      <section class="movie-detail">
       <div class="container" style="padding:30px"> 
       	
       <div class="lang-wrapper" >
	 			   <form id="filmForm" action="/home/ticket" method="GET">
				        <select class="form-select-lg mb-3" name="maphim" onchange="submitForm()">
				            <option selected>Choose Film</option>
				            <c:forEach items="${ls_phim}" var="phim">
				                <option value="${phim.maphim}" ${phimChoose.maphim == phim.maphim ? 'selected' : ''} >${phim.tenphim}</option>
				            </c:forEach>
				        </select>
				    </form>
				    
	 			</div>
	 		<div class="lang-wrapper" >
	 		<form id="dayShow" action="/home/ticket/day" method="GET">
	 			<select class=" form-select-lg mb-3" name="ngaychieu" onchange="submitDay()">
				  <option selected>Choose show day </option>
				  <c:forEach items="${ls_lichchieuByIdPhim }" var="lichchieu">
				 	<option  value="${lichchieu.ngaychieu }" ${ngaychieuChoose == lichchieu.ngaychieu ? 'selected' : ''}>Date Show: ${lichchieu.ngaychieu }  </option>
				  </c:forEach>
				</select>
				</form>
				</div>
				
				
			<div class="lang-wrapper">
			    <form id="timeShow" action="/home/ticket/time" method="GET">
			        <select class=" form-select-lg mb-3" name="giochieu" onchange="submitTime()">
			            <option selected>Choose show time</option>
			            <c:forEach items="${ls_lichchieuByIdPhimAndDay}" var="lichchieu">
			                <option value="${lichchieu.giochieu}" ${giochieuChoose == lichchieu.giochieu ? 'selected' : '' }>Time Show: ${lichchieu.giochieu}</option>
			            </c:forEach>
			        </select>
			    </form>
			</div>	 			
 			
       </div>
        	 	
 			 	<div class="container">
 			 		<div class="row">
 			 		
 			 			<div class="col-sm-6">
			     			<img src="${pageContext.request.contextPath }/images/${phimChoose.hinhanh}" width="220px" height="180px" style="padding-left:10px"/>
			     			<%-- Ticket in here --%>
			     			<div class="ticket" style=" ">
			     			 <h5>${phimChoose.tenphim}</h5>
						    <p>2D Lồng tiếng</p>
						    <p>${ls_xuatChieu[0].tenphongchieu }</p>
						    <p>Suất:  ${giochieuChoose}  -  ${ngaychieuChoose}</p>
						    <p> ${totalQuantity} x Ghế đơn</p>
						    <p>Ghế:
						       <c:choose>
					            <c:when test="${not empty sessionScope.ls_seat}">
					                <c:forEach items="${sessionScope.ls_seat}" var="seat" varStatus="status">
					                    ${seat}<c:if test="${!status.last}">, </c:if>
					                </c:forEach>
					            </c:when>
					            <c:otherwise>
					                Chưa Chọn Ghế.
					            </c:otherwise>
					        </c:choose>
						    </p>
						    <h5>Tổng cộng: ${totalPrice } ₫</h5>
						    <button class="btnn">Quay lại</button>
						    <a class="btnn" href="/checkout">Tiếp tục</a>
						    </div>
			     		</div>
			     		<div class="col-sm-6">
			     	<c:if test="${not empty giochieuChoose }">
			     	<div class="row">
			     		<div class="col-sm-8">
			     	
			     	<%-- <c:forEach items="${gheThuong}" var="ghe">
						    <!-- Dãy ghế -->
						   		 <div class="seat"><a href="/home/chooseSeat/${ghe.maghe}">${ghe.soghe}</div>
			       			 </c:forEach>
			       			 
			       			  <c:forEach items="${gheVip}" var="ghe">
						    <!-- Dãy ghế -->
						    	<div class="seat"><a href="/home/chooseSeat/${ghe.maghe}">V${ghe.soghe}</div>
			       			 </c:forEach> --%>
			     	 	
						     <div class="cinema-seating">
							        <c:forEach items="${gheThuong}" var="ghe" varStatus="seatIndex">
							                <div  class="seat seat-link ${sessionScope.ls_seat != null && sessionScope.ls_seat.contains(ghe.soghe) ? 'selected' : ''}">
							                    <a href="/home/chooseSeat/${ghe.maghe}">${ghe.soghe }</a>
							                </div>
							        </c:forEach>
							    <%-- Ghe Vip --%>
							    <c:forEach items="${gheVip}" var="ghe">
							    <div  class="seat seat-link ${sessionScope.ls_seat != null && sessionScope.ls_seat.contains(ghe.soghe) ? 'selected' : ''}">
							    <a href="/home/chooseSeat/${ghe.maghe}"> ${ghe.soghe}</a></div>
							    </c:forEach>
							</div>
			     		</div>
			     		</div>
			     		</c:if>
			     	</div>
			     </div>
			     </div>
      </section>
    </article>
  </main>
  <!-- 
    - #FOOTER
  -->

  <footer class="footer">

    <div class="footer-top">
      <div class="container">

        <div class="footer-brand-wrapper">

          <a href="./index.html" class="logo">
            <img src="/images/logo.svg" alt="Filmlane logo">
          </a>

          <ul class="footer-list">

            <li>
              <a href="./index.html" class="footer-link">Home</a>
            </li>

            <li>
              <a href="#" class="footer-link">Movie</a>
            </li>

            <li>
              <a href="#" class="footer-link">TV Show</a>
            </li>

            <li>
              <a href="#" class="footer-link">Web Series</a>
            </li>

            <li>
              <a href="#" class="footer-link">Pricing</a>
            </li>

          </ul>

        </div>

        <div class="divider"></div>

        <div class="quicklink-wrapper">

          <ul class="quicklink-list">

            <li>
              <a href="#" class="quicklink-link">Faq</a>
            </li>

            <li>
              <a href="#" class="quicklink-link">Help center</a>
            </li>

            <li>
              <a href="#" class="quicklink-link">Terms of use</a>
            </li>

            <li>
              <a href="#" class="quicklink-link">Privacy</a>
            </li>

          </ul>

          <ul class="social-list">

            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-facebook"></ion-icon>
              </a>
            </li>

            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-twitter"></ion-icon>
              </a>
            </li>

            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-pinterest"></ion-icon>
              </a>
            </li>

            <li>
              <a href="#" class="social-link">
                <ion-icon name="logo-linkedin"></ion-icon>
              </a>
            </li>

          </ul>

        </div>

      </div>
    </div>

    <div class="footer-bottom">
      <div class="container">

        <p class="copyright">
          &copy; 2022 <a href="#">codewithsadee</a>. All Rights Reserved
        </p>

        <img src="/images/footer-bottom-img.png" alt="Online banking companies logo" class="footer-bottom-img">

      </div>
    </div>

  </footer>
  <!-- 
    - #GO TO TOP
  -->

  <a href="#top" class="go-top" data-go-top>
    <ion-icon name="chevron-up"></ion-icon>
  </a>





  <!-- 
    - custom js link
  -->
  <script src="/js/index.js"></script>

  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>