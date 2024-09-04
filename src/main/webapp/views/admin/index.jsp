<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Home</title>
<meta name="description" content="">
<meta name="author" content="templatemo">
<!-- 
    Visual Admin Template
    https://templatemo.com/tm-455-visual-admin
    -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700"
	rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="${pageContext.request.contextPath}/css/admin/crud/indexCrud.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


<script type="text/javascript" charset="UTF-8"
	src="https://www.gstatic.com/charts/51/loader.js"></script>
<link id="load-css-0" rel="stylesheet" type="text/css"
	href="https://www.gstatic.com/charts/51/css/core/tooltip.css">
<link id="load-css-1" rel="stylesheet" type="text/css"
	href="https://www.gstatic.com/charts/51/css/util/util.css">
<script type="text/javascript" charset="UTF-8"
	src="https://www.gstatic.com/charts/51/js/jsapi_compiled_default_module.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://www.gstatic.com/charts/51/js/jsapi_compiled_graphics_module.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://www.gstatic.com/charts/51/js/jsapi_compiled_ui_module.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://www.gstatic.com/charts/51/js/jsapi_compiled_corechart_module.js"></script>
</head>
<body>
	<%--  <jsp:include page="${pageContext.request.contextPath }/views/home/include/header.jsp"></jsp:include> <br /> --%>

	<!-- Left column -->
	<div class="templatemo-flex-row">
		<jsp:include
			page="${pageContext.request.contextPath}/views/admin/include/navadmin.jsp"
			flush="true"></jsp:include>
		<!-- Main content -->
		<div class="templatemo-content col-1 light-gray-bg">
			<jsp:include
				page="${pageContext.request.contextPath}/views/admin/include/topnavadmin.jsp"
				flush="true"></jsp:include>
			<div class="templatemo-content-container">


				<form:form modelAttribute="item" method="post"
					action="/Admin/create" enctype="multipart/form-data">
					<div>


						<div class=card>
							<div class="row m-0 ">
								<div class="text-center">
									<h2>
										Vui lòng nhập thông tin ${sessionScope.chucVu}
										</h3>
								</div>
								<br> <br>
								<div class="col-sm-5 ">
									<h6>Nhập họ tên:</h6>
									<form:input path="hoten" class="form-control" />
									
								</div>
								<div class="col-sm-5">
									<h6>Nhập email:</h6>
									<form:input path="email" class="form-control" />
								</div>
								<div class="col-sm-5">
									<h6>Nhập địa chỉ:</h6>
									<form:input path="diachi" class="form-control" />
								</div>
								<div class="col-sm-5">
									<h6>Nhập số điện thoại:</h6>
									<form:input path="sdt" class="form-control" />
								</div>

								<div class="col-sm-5">
									<h6>Ngày vào làm:</h6>
									<form:input path="ngayvaolam" class="form-control" />
								</div>
								<div class="col-sm-5">
									<h6>trạng thái:</h6>

									<form:select path="trangthai" items="${trangthais}"
										class="form-control" />
								</div>
								<div class="col-sm-5">
									<h6>Mã tài khoản:</h6>
									<form:input path="matk" class="form-control" />
								</div>
								<c:choose>
									<c:when test="${sessionScope.matk==1}">
										<div class="col-sm-5">
											<h6>Chức vụ:</h6>


											<form:select path="chucvu" class="form-control"
												items="${chucvus}"></form:select>
										</div>
									</c:when>
								</c:choose>


							</div>
							<br>
						</div>

						<div class="col-sm-5">
							<h6>chọn ảnh:</h6>
							<input type="file" name="luuAnh">
						</div>




					</div>
					<h5>${message }</h5>
					<button class="btn btn-success"
						formaction="/Admin/update/${item.manv }">update</button>
							<button class="btn btn-success" formaction="/Admin/create">Create</button>
					<c:choose>
						<c:when test="${sessionScope.role==0}">
						

							<button class="btn btn-danger"
								formaction="/Admin/delete/${item.manv}">Delete</button>
							<button class="btn btn-success" formaction="/Admin/index111">Reset</button>
						</c:when>
					</c:choose>

					<div class="row">
				</form:form>
				<form action="/findbyname" method="post">
					<div class="row">
						<div class="col-sm-4">
							<input type="text" class="form-control" name="find">
						</div>
						<div class="col-sm-2">
							<button class="btn btn-success">Find</button>
						</div>
					</div>

				</form>
			</div>
		</div>

		<a class="btn btn-default active ms-3" href="/export/excel">export</a>
		<a class="btn btn-default active ms-3" href="/thongke">Thống kê</a>
		<div class="templatemo-flex-row flex-content-row">




			<div class="col-1">
				<div
					class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
					<i class="fa fa-times"></i>
					<div class="panel-heading templatemo-position-relative">
						<h2 class="text-uppercase">User Table</h2>
					</div>
					<div class="table-responsive">
						<table class="table table-hover table-bordered">
							<thead>
								<tr>
									<td>STT</td>
									<td>Họ và tên</td>
									<td>Email</td>
									<td>Địa chỉ</td>
									<td>Số điện thoại</td>
									<td>Ảnh</td>
									<td>ngày vào làm</td>
									<td>Chức vụ</td>
									<td>Mã tài khoản</td>
									<td>Role</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${items}" varStatus="loop">
									<tr>
										<td>${loop.index + 1}
										<td>${item.hoten}</td>
										<td>${item.email}</td>
										<td>${item.diachi}</td>
										<td>${item.sdt}</td>

										<td class="text-center" width="10%"><img
											class="img-fluid" src="/imageNhanVien/${item.anh}"></td>
										<td><fmt:formatDate value="${item.ngayvaolam}"
												pattern="yyyy/MM/dd" var="formattedDate" />
											${formattedDate}</td>
										<td>${item.chucvu}</td>

										<td>${item.matk.matk}</td>
										<td>
											<c:choose>
											<c:when test="${item.matk.loaitk==0}"> Admin</c:when>
											<c:when test="${item.matk.loaitk==1}"> Nhân viên</c:when>
											<c:when test="${item.matk.loaitk==2}"> Khách hàng</c:when>
											</c:choose>
											</td>
										<td><a class="btn btn default active"
											href="/Admin/edit/${item.manv}">Edit</a></td>
											
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- Second row ends -->
		<div
			class="templatemo-flex-row flex-content-row templatemo-overflow-hidden">
			<!-- overflow hidden for iPad mini landscape view-->
			<div class="col-1 templatemo-overflow-hidden">
				<div
					class="templatemo-content-widget white-bg templatemo-overflow-hidden">
					<i class="fa fa-times"></i>
					<div class="templatemo-flex-row flex-content-row">
						<div class="col-1 col-lg-6 col-md-12">
							<h2 class="text-center">
								Modular<span class="badge">new</span>
							</h2>
							<div id="pie_chart_div" class="templatemo-chart">
								<div style="position: relative;">
									<div dir="ltr"
										style="position: relative; width: 597px; height: 300px;">
										<div
											style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;"
											aria-label="A chart.">
											<svg width="597" height="300" aria-label="A chart."
												style="overflow: hidden;">
													<defs id="_ABSTRACT_RENDERER_ID_3"></defs>
													<rect x="0" y="0" width="597" height="300" stroke="none"
													stroke-width="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="100" y="37.2"
													font-family="Arial" font-size="12" font-weight="bold"
													stroke="none" stroke-width="0" fill="#000000">How Much Pizza I Ate Last Night</text>
													<rect x="100" y="27" width="397" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect></g>
													<g>
													<rect x="364" y="58" width="133" height="88" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g column-id="Mushrooms">
													<rect x="364" y="58" width="133" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="381" y="68.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Mushrooms</text></g>
													<circle cx="370" cy="64" r="6" stroke="none"
													stroke-width="0" fill="#3366cc"></circle></g>
													<g column-id="Onions">
													<rect x="364" y="77" width="133" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="381" y="87.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Onions</text></g>
													<circle cx="370" cy="83" r="6" stroke="none"
													stroke-width="0" fill="#dc3912"></circle></g>
													<g column-id="Olives">
													<rect x="364" y="96" width="133" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="381" y="106.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Olives</text></g>
													<circle cx="370" cy="102" r="6" stroke="none"
													stroke-width="0" fill="#ff9900"></circle></g>
													<g column-id="Zucchini">
													<rect x="364" y="115" width="133" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="381" y="125.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Zucchini</text></g>
													<circle cx="370" cy="121" r="6" stroke="none"
													stroke-width="0" fill="#109618"></circle></g>
													<g column-id="Pepperoni">
													<rect x="364" y="134" width="133" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="381" y="144.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Pepperoni</text></g>
													<circle cx="370" cy="140" r="6" stroke="none"
													stroke-width="0" fill="#990099"></circle></g></g>
													<g>
													<path
													d="M223,151L223,59A92,92,0,0,1,288.0538238691624,216.0538238691624L223,151A0,0,0,0,0,223,151"
													stroke="#ffffff" stroke-width="1" fill="#3366cc"></path>
													<text text-anchor="start" x="263.2732868906926"
													y="131.4766278081899" font-family="Arial" font-size="12"
													stroke="none" stroke-width="0" fill="#ffffff">37.5%</text></g>
													<g>
													<path
													d="M223,151L131,151A92,92,0,0,1,223,59L223,151A0,0,0,0,0,223,151"
													stroke="#ffffff" stroke-width="1" fill="#990099"></path>
													<text text-anchor="start" x="163.51106303000557"
													y="107.7110630300056" font-family="Arial" font-size="12"
													stroke="none" stroke-width="0" fill="#ffffff">25%</text></g>
													<g>
													<path
													d="M223,151L157.9461761308376,216.0538238691624A92,92,0,0,1,131,151L223,151A0,0,0,0,0,223,151"
													stroke="#ffffff" stroke-width="1" fill="#109618"></path>
													<text text-anchor="start" x="148.7267131093074"
													y="178.9233721918101" font-family="Arial" font-size="12"
													stroke="none" stroke-width="0" fill="#ffffff">12.5%</text></g>
													<g>
													<path
													d="M223,151L223,243A92,92,0,0,1,157.9461761308376,216.0538238691624L223,151A0,0,0,0,0,223,151"
													stroke="#ffffff" stroke-width="1" fill="#ff9900"></path>
													<text text-anchor="start" x="180.4294006786446"
													y="216.9328876796244" font-family="Arial" font-size="12"
													stroke="none" stroke-width="0" fill="#ffffff">12.5%</text></g>
													<g>
													<path
													d="M223,151L288.0538238691624,216.0538238691624A92,92,0,0,1,223,243L223,151A0,0,0,0,0,223,151"
													stroke="#ffffff" stroke-width="1" fill="#dc3912"></path>
													<text text-anchor="start" x="231.57059932135542"
													y="216.9328876796244" font-family="Arial" font-size="12"
													stroke="none" stroke-width="0" fill="#ffffff">12.5%</text></g>
													<g></g></svg>
											<div
												aria-label="A tabular representation of the data in the chart."
												style="position: absolute; left: -10000px; top: auto; width: 1px; height: 1px; overflow: hidden;">
												<table>
													<thead>
														<tr>
															<th>Topping</th>
															<th>Slices</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Mushrooms</td>
															<td>3</td>
														</tr>
														<tr>
															<td>Onions</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Olives</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Zucchini</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Pepperoni</td>
															<td>2</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div aria-hidden="true"
										style="display: none; position: absolute; top: 310px; left: 607px; white-space: nowrap; font-family: Arial; font-size: 12px;">Pepperoni</div>
									<div></div>
								</div>
							</div>
							<!-- Pie chart div -->
						</div>
						<div class="col-1 col-lg-6 col-md-12">
							<h2 class="text-center">
								Interactive<span class="badge">new</span>
							</h2>
							<div id="bar_chart_div" class="templatemo-chart">
								<div style="position: relative;">
									<div dir="ltr"
										style="position: relative; width: 597px; height: 300px;">
										<div
											style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;"
											aria-label="A chart.">
											<svg width="597" height="300" aria-label="A chart."
												style="overflow: hidden;">
													<defs id="_ABSTRACT_RENDERER_ID_4">
													<clipPath id="_ABSTRACT_RENDERER_ID_5">
													<rect x="100" y="58" width="397" height="185"></rect></clipPath></defs>
													<rect x="0" y="0" width="597" height="300" stroke="none"
													stroke-width="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="100" y="37.2"
													font-family="Arial" font-size="12" font-weight="bold"
													stroke="none" stroke-width="0" fill="#000000">How Much Pizza I Ate Last Night</text>
													<rect x="100" y="27" width="397" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect></g>
													<g>
													<rect x="509" y="58" width="76" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<rect x="509" y="58" width="76" height="12" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g>
													<text text-anchor="start" x="538" y="68.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Slices</text></g>
													<rect x="509" y="58" width="24" height="12" stroke="none"
													stroke-width="0" fill="#3366cc"></rect></g></g>
													<g>
													<rect x="100" y="58" width="397" height="185" stroke="none"
													stroke-width="0" fill-opacity="0" fill="#ffffff"></rect>
													<g
													clip-path="url(file:///C:/Users/ASUS/Downloads/templatemo_455_visual_admin/templatemo_455_visual_admin/index.html#_ABSTRACT_RENDERER_ID_5)">
													<g>
													<rect x="100" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#cccccc"></rect>
													<rect x="232" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#cccccc"></rect>
													<rect x="364" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#cccccc"></rect>
													<rect x="496" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#cccccc"></rect>
													<rect x="166" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#ebebeb"></rect>
													<rect x="298" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#ebebeb"></rect>
													<rect x="430" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#ebebeb"></rect></g>
													<g>
													<rect x="101" y="66" width="395" height="22" stroke="none"
													stroke-width="0" fill="#3366cc"></rect>
													<rect x="101" y="102" width="131" height="23" stroke="none"
													stroke-width="0" fill="#3366cc"></rect>
													<rect x="101" y="139" width="131" height="23" stroke="none"
													stroke-width="0" fill="#3366cc"></rect>
													<rect x="101" y="176" width="131" height="23" stroke="none"
													stroke-width="0" fill="#3366cc"></rect>
													<rect x="101" y="213" width="263" height="22" stroke="none"
													stroke-width="0" fill="#3366cc"></rect></g>
													<g>
													<rect x="100" y="58" width="1" height="185" stroke="none"
													stroke-width="0" fill="#333333"></rect></g></g>
													<g></g>
													<g>
													<g>
													<text text-anchor="middle" x="100.5" y="260.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#444444">0</text></g>
													<g>
													<text text-anchor="middle" x="232.5" y="260.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#444444">1</text></g>
													<g>
													<text text-anchor="middle" x="364.5" y="260.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#444444">2</text></g>
													<g>
													<text text-anchor="middle" x="496.5" y="260.2"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#444444">3</text></g>
													<g>
													<text text-anchor="end" x="88" y="81.10000000000001"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Mushrooms</text></g>
													<g>
													<text text-anchor="end" x="88" y="117.89999999999999"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Onions</text></g>
													<g>
													<text text-anchor="end" x="88" y="154.7"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Olives</text></g>
													<g>
													<text text-anchor="end" x="88" y="191.49999999999997"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Zucchini</text></g>
													<g>
													<text text-anchor="end" x="88" y="228.29999999999998"
													font-family="Arial" font-size="12" stroke="none"
													stroke-width="0" fill="#222222">Pepperoni</text></g></g></g>
													<g></g></svg>
											<div
												aria-label="A tabular representation of the data in the chart."
												style="position: absolute; left: -10000px; top: auto; width: 1px; height: 1px; overflow: hidden;">
												<table>
													<thead>
														<tr>
															<th>Topping</th>
															<th>Slices</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Mushrooms</td>
															<td>3</td>
														</tr>
														<tr>
															<td>Onions</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Olives</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Zucchini</td>
															<td>1</td>
														</tr>
														<tr>
															<td>Pepperoni</td>
															<td>2</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div aria-hidden="true"
										style="display: none; position: absolute; top: 310px; left: 607px; white-space: nowrap; font-family: Arial; font-size: 12px;">Slices</div>
									<div></div>
								</div>
							</div>
							<!-- Bar chart div -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="text-right">
			<p>Copyright © 2084 Company Name | Design: Template Mo</p>
		</footer>
	</div>
	</div>
	</div>

	<!-- JS -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<!-- jQuery -->
	<script src="js/jquery-migrate-1.2.1.min.js"></script>
	<!--  jQuery Migrate Plugin -->
	<script src="https://www.google.com/jsapi"></script>
	<!-- Google Chart -->
	<script>
		/* Google Chart 
		-------------------------------------------------------------------*/
		// Load the Visualization API and the piechart package.
		google.load('visualization', '1.0', {
			'packages' : [ 'corechart' ]
		});

		// Set a callback to run when the Google Visualization API is loaded.
		google.setOnLoadCallback(drawChart);

		// Callback that creates and populates a data table,
		// instantiates the pie chart, passes in the data and
		// draws it.
		function drawChart() {

			// Create the data table.
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Topping');
			data.addColumn('number', 'Slices');
			data.addRows([ [ 'Mushrooms', 3 ], [ 'Onions', 1 ],
					[ 'Olives', 1 ], [ 'Zucchini', 1 ], [ 'Pepperoni', 2 ] ]);

			// Set chart options
			var options = {
				'title' : 'How Much Pizza I Ate Last Night'
			};

			// Instantiate and draw our chart, passing in some options.
			var pieChart = new google.visualization.PieChart(document
					.getElementById('pie_chart_div'));
			pieChart.draw(data, options);

			var barChart = new google.visualization.BarChart(document
					.getElementById('bar_chart_div'));
			barChart.draw(data, options);
		}

		$(document).ready(function() {
			if ($.browser.mozilla) {
				//refresh page on browser resize
				// http://www.sitepoint.com/jquery-refresh-page-browser-resize/
				$(window).bind('resize', function(e) {
					if (window.RT)
						clearTimeout(window.RT);
					window.RT = setTimeout(function() {
						this.location.reload(false); /* false to get page from cache */
					}, 200);
				});
			} else {
				$(window).resize(function() {
					drawChart();
				});
			}
		});
	</script>
	<script type="text/javascript" src="js/templatemo-script.js"></script>
	<!-- Templatemo Script -->


</body>
</html>