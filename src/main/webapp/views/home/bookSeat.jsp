<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        /* Sử dụng CSS đã cung cấp */
        .cinema-seating {
            display: grid;
            grid-template-columns: repeat(15, 1fr);
            gap: 1px;
            padding-top: 15px;
        }

        .seat {
            width: 30px;
            height: 30px;
            background-color: #ccc;
            cursor: pointer;
        }

        .seat a {
            text-decoration: none;
            color: inherit;
        }

        .seat.vip {
            background-color: rgb(244, 52, 11);
        }

        .seat.selected {
            background-color: #6c6;
        }
    </style>
</head>
<body>
<h1>Rạp Phim - Chọn Ghế Ngồi</h1>

   <div class="cinema-seating">
        <!-- Dãy ghế -->
        <% for (int i = 1; i <= 15; i++) { %>
            <div class="seat"><a href="#">A<%= i %></a></div>
        <% } %>
    </div>
    
    
    <%--    <% char currentChar = 'A'; %>
							    <c:set var="seatOfRow" value="10" />
							    <c:set var="totalSeat" value="${fn:length(gheThuong)}" />
							    <c:set var="totalRow" value="${(totalSeat + seatOfRow - 1) / seatOfRow}" />
							    <!-- Vòng Lặp ngoài : là vòng lặp sẽ lặp tương đương với từng hàng -->   
							    <c:forEach begin="0" end="${totalRow - 1}" var="rowIndex">
							        <% int seatNumber = 1; %>
							        <c:forEach items="${gheThuong}" var="ghe" varStatus="seatIndex">
							            <c:if test="${seatIndex.index >= rowIndex * seatOfRow && seatIndex.index < (rowIndex + 1) * seatOfRow}">
							                <div class="seat">
							                    <a href="/home/chooseSeat/${ghe.maghe}"> <%= currentChar %><%= seatNumber %></a>
							                </div>
							                <% seatNumber++; %>
							            </c:if>
							        </c:forEach>
							        <!-- Tăng giá trị của currentChar sau mỗi hàng -->
							        <% currentChar++;  %>
							    </c:forEach>--%>
     <%--<div class="body py-5">
    <div class="container">
        <div class="w-50 m-auto">
            <!-- Thêm lớp "my-4" để tạo ra khoảng cách trên và dưới tiêu đề trang -->
            <h1 class="my-3 text-danger text-center">${status}</h1>
            <!-- Sử dụng lớp "alert" và "alert-danger" để tạo ra thông báo lỗi -->
            <h2 class="my-2">Chi tiết đơn hàng</h2>
            <!-- Sử dụng lớp "table" và "table-bordered" để tạo ra bảng hiển thị thông tin chi tiết đơn hàng -->
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>Thông tin đơn hàng:</td>
                    <td><span >${orderId}</span></td>
                </tr>
                <tr>
                    <td>Tổng tiền:</td>
                    <td><span >${totalPrice}</span></td>
                </tr>
                <tr>
                    <td>Thời gian thanh toán:</td>
                    <td><span >${paymentTime}</span></td>
                </tr>
                <tr>
                    <td>Mã giao dịch:</td>
                    <td><span>${transactionId}</span></td>
                </tr>
                </tbody>
            </table>
            <a href="/" class="btn btn-primary">Về trang chủ</a>
        </div>
    </div>
</div> --%>
</body>
</html>