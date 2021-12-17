<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:url var="APIurl" value="/api-down-level" />
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<title>Star Admin2</title>
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
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/select2/select2.min.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/views/template/css/vertical-layout-light/style.css">
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
											<div class="col-12 grid-margin stretch-card">
												<div class="card">
													<div class="card-body">
														<h4 class="card-title">Thêm tài khoản A2</h4>
														<!-- BEGIN CREATE ACCOUNT -->
														<form class="forms-sample" id="formcreateuser">
															<div class="form-group">
																<label for="exampleInputUsername1">TÊN KHU VỰC</label>
																<input name="name" type="text" class="form-control"
																	id="exampleInputUsername1" placeholder="Name">
															</div>
															<div class="form-group">
																<label for="exampleInputUsername1">MÃ KHU VỰC</label>
																<input name="code" type="number" class="form-control"
																	id="exampleInputUsername1" placeholder="Code">
															</div>
															<div class="form-group">
																<label for="exampleInputPassword1">MẬT KHẨU</label>
																<input name="pass" type="password" class="form-control"
																	id="exampleInputPassword1" placeholder="Password">
															</div>
															<div class="form-group">
																<label for="exampleInputConfirmPassword1">NHẬP LẠI
																	MẬT KHẨU</label> <input name="confirmpass"
																	type="password" class="form-control"
																	id="exampleInputConfirmPassword1"
																	placeholder="Password">
															</div>
															<input name="id_superior" type="hidden"
																value="${sessionScope.account.id}"> <input name="area"
																type="hidden" value="2222"> <input name="permit"
																type="hidden" value="1">
															<button id="createUser" type="submit"
																class="btn btn-primary me-2">THÊM</button>
														</form>
														<!-- END CREATE ACCOUNT -->
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- BEGIN: FOOTER -->
									<%@ include file="/views/jsp/common/footer.jsp" %>
										<!-- END: FOOTER -->
								</div>
					</div>
			</div>
			<script src="${pageContext.request.contextPath}/views/template/vendors/js/vendor.bundle.base.js"></script>
			<script
				src="${pageContext.request.contextPath}/views/template/vendors/typeahead.js/typeahead.bundle.min.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/vendors/select2/select2.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/views/template/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/off-canvas.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/hoverable-collapse.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/template.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/settings.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/todolist.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/file-upload.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/typeahead.js"></script>
			<script src="${pageContext.request.contextPath}/views/template/js/select2.js"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script>
				$("#createUser").on("click", function (e) {
					e.preventDefault();
					var data = {}
					var formData = $("#formcreateuser").serializeArray()
					$.each(formData, function (index, value) {
						data["" + value.name + ""] = value.value
					})
					if (!data.name) {
						alert("Sai tên khu vực")
					} else if (!data.code || data.code.length != 2) {
						alert("Mã code chưa đúng")
					} else if (!data.id_superior) {
						alert("lỗi không xác định")
					} else if (data.pass != data.confirmpass) {
						alert("mật khẩu không khớp")
					} else {
						postData = {}
						postData['name'] = data.name
						postData['area'] = data.area
						postData['pass'] = data.pass
						postData['code'] = data.code
						postData['id_superior'] = data.id_superior
						postData['permit'] = data.permit
						console.log(postData);
						$.ajax({
							type: "POST",
							url: "${APIurl}",
							contentType: "application/json",
							data: JSON.stringify(postData),
							dataType: "json",
							error: function () {
								alert("lỗi")
							},
							success: function (data) {
								console.log(data.value);
								alert(data.value)
							}
						});
					}
				});
			</script>
		</body>

		</html>