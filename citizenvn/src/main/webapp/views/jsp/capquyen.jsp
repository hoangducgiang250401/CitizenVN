<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/views/jsp/common/taglist.jsp" %>
		<c:url var="UrlApi" value="/api-down-level" />
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<title>Star Admin2</title>
			<!-- plugins:css -->
			<link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/feather/feather.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/mdi/css/materialdesignicons.min.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/ti-icons/css/themify-icons.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/typicons/typicons.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/simple-line-icons/css/simple-line-icons.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/css/vendor.bundle.base.css">
			<!-- endinject -->
			<!-- Plugin css for this page -->
			<!-- End plugin css for this page -->
			<!-- inject:css -->
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/css/vertical-layout-light/style.css">
			<!-- endinject -->
			<link rel="shortcut icon" href="${pageContext.request.contextPath}/views/template/images/favicon.png" />
		</head>

		<body>
			<div class="container-scroller">
				<!-- BEGIN: HEADER -->
				<%@ include file="/views/jsp/common/header.jsp" %>
					<!-- END: HEADER -->
					<div class="container-fluid page-body-wrapper">
						<!-- BEGIN: SETTING -->
						<%@ include file="/views/jsp/common/setting.jsp" %>
							<!-- END: SETTING -->
							<!-- BEGIN: NAV -->
							<%@ include file="/views/jsp/common/nav.jsp" %>
								<!-- END: NAV -->
								<div class="main-panel">
									<div class="content-wrapper">
										<div class="row">
											<div class="col-lg-12 grid-margin stretch-card">
												<div class="card">
													<div class="card-body">
														<h4 class="card-title">Quản lí tài khoản</h4>
														<div class="table-responsive pt-3">
															<table id="tbl" class="table table-bordered table-hover">
																<thead class="header-row"
																	style="background-color: rgb(120, 157, 226);">
																	<tr>
																		<th>Tên khu vực</th>
																		<th>Mã đăng nhập</th>
																		<th>Mật khẩu</th>
																		<th>Thời gian bắt đầu</th>
																		<th>Thời gian kết thúc</th>
																		<th>Sửa đổi</th>
																		<th>Xóa</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach items="${listCapDuoi }" var="capduoi">
																		<tr>
																			<td>${capduoi.name }</td>
																			<td>${capduoi.code }</td>
																			<td>${capduoi.pass }</td>
																			<td>
																				<p>
																					<time>${capduoi.startTime }</time>
																				</p>
																			</td>
																			<td>
																				<p>
																					<time>${capduoi.endTime }</time>
																				</p>
																			</td>
																			<td>
																				<button
																					class="btn btn-settings mdi mdi-settings js-settings"></button>
																			</td>
																			<td>
																				<button
																					class="btn btn-settings mdi mdi-delete js-delete"></button>
																			</td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- content-wrapper ends -->
									<!-- BEGIN: NAV -->
									<%@ include file="/views/jsp/common/footer.jsp" %>
										<!-- END: NAV -->
								</div>
								<!-- main-panel ends -->
					</div>
					<!-- page-body-wrapper ends -->
			</div>

			<div class="modall js-modall">
				<div class="modall-container">
					<div class="modall-close js-modall-close">
						<i class="ti-close"></i>
					</div>
					<header class="modall-header"> Sửa đổi </header>

					<div class="modall-body">
						<label for="" class="modall-label"> Tên khu vực </label>
						<input type="text" class="modall-input">
						<label for="" class="modall-label"> Mã đăng nhập </label>
						<input type="text" class="modall-input">
						<label for="" class="modall-label">Mật khẩu </label>
						<input type="text" class="modall-input">
						<label for="" class="modall-label"> Thời gian bắt đầu </label>
						<input type="datetime-local" class="modall-input">
						<label for="" class="modall-label"> Thời gian kết thúc </label>
						<input type="datetime-local" class="modall-input">
						<input type="hidden" class="modall-input">
						<button id="saveChange">Lưu</button>
					</div>
				</div>
			</div>
			<!-- set time -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://momentjs.com/downloads/moment.min.js"></script>
			<script>
				const setBtns = document.querySelectorAll('.js-settings')
				const modall = document.querySelector('.js-modall')
				const modallClose = document.querySelector('.js-modall-close')
				function showSet() {
					modall.classList.add('open')
					var tr = $(this).closest('tr')
					var td = $(this).closest('tr').find('td')
					$('.modall-input').eq(0).val(td.eq(0).text().trim())
					$('.modall-input').eq(1).val(td.eq(1).text().trim())
					$('.modall-input').eq(2).val(td.eq(2).text().trim())
					var string3 = moment(td.eq(3).text().trim()).local().format("YYYY-MM-DDTHH:mm:ss")
					var string4 = moment(td.eq(4).text().trim()).local().format("YYYY-MM-DDTHH:mm:ss")
					$('.modall-input').eq(3).val(string3)
					$('.modall-input').eq(4).val(string4)
					$('.modall-input').eq(5).val(td.eq(1).text().trim())
				}
				function hideSet() {
					modall.classList.remove('open')
				}
				for (const setBtn of setBtns) {
					setBtn.addEventListener('click', showSet)
				}
				modallClose.addEventListener('click', hideSet)
				$('.js-delete').on('click', function () {
					if (confirm('BẠN CÓ CHẮC MUỐN XOÁ TÀI KHOẢN')) {
						var tr = $(this).closest('tr')
						var td = $(this).closest('tr').find('td')
						modelCapDuoi = {}
						modelCapDuoi["name"] = td.eq(0).text().trim()
						modelCapDuoi["code"] = td.eq(1).text().trim()
						modelCapDuoi["pass"] = td.eq(2).text().trim()
						modelCapDuoi["startTime"] = td.eq(3).text().trim()
						modelCapDuoi["endTime"] = td.eq(4).text().trim()
						$.ajax({
							type: "DELETE",
							url: "${UrlApi}",
							contentType: "application/json",
							data: JSON.stringify(modelCapDuoi),
							dataType: "json",
							error: function () {
								alert("lỗi")
							},
							success: function (data) {
								if (data.value == "Đã xoá") {
									tr.remove()
									alert(data.value)
								} else {
									alert(data.value)
								}
							}
						});
					}
				})
				$("#saveChange").on('click', function (e) {
					e.preventDefault()
					var dataSave = {}
					var input = $(this).closest('.modall-body').find('input')
					var name = input.eq(0).val().trim()
					var codeNew = input.eq(1).val().trim()
					var pass = input.eq(2).val().trim()
					var startTime = moment(input.eq(3).val().trim()).local().format("YYYY-MM-DD HH:mm:ss")
					var endTime = moment(input.eq(4).val().trim()).local().format("YYYY-MM-DD HH:mm:ss")
					var code = input.eq(5).val().trim()
					dataSave['name'] = name
					dataSave['code'] = code
					dataSave['pass'] = pass
					dataSave['startTime'] = startTime
					dataSave['endTime'] = endTime
					dataSave['codeNew'] = codeNew
					var startDate = new Date(startTime)
					var endDate = new Date(endTime)
					if (endDate > startDate) {
						$.ajax({
							type: "PUT",
							url: "${UrlApi}",
							contentType: "application/json",
							data: JSON.stringify(dataSave),
							dataType: "json",
							error: function () {
								alert("lỗi")
							},
							success: function (data) {
								updateChange(dataSave);
								alert(data.value)
							}
						});
					} else {
						alert("Ngày kết thúc phải lớn hơn ngày bắt đầu !")
					}
				})
				function updateChange(dataSave) {
					var tr = $('#tbl').find('tbody').find('tr')
					tr.each(function (i, e) {
						if ($(e).find('td').eq(1).text().trim() == dataSave.code) {
							console.log("thấy");
							$(e).find('td').eq(0).html(dataSave.name)
							$(e).find('td').eq(1).html(dataSave.codeNew)
							$(e).find('td').eq(2).html(dataSave.pass)
							$(e).find('td').eq(3).find('time').html(dataSave.startTime)
							$(e).find('td').eq(4).find('time').html(dataSave.endTime)
						}
					})
				}
			</script>
			<script src="${pageContext.request.contextPath}/views/template/vendors/js/vendor.bundle.base.js"></script>
			<script
				src="${pageContext.request.contextPath}/views/template/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/off-canvas.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/hoverable-collapse.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/template.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/settings.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/todolist.js"></script>
		</body>

		</html>