<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/views/jsp/common/taglist.jsp" %>
		<c:url var="UrlApi" value="/api-people" />
		<c:url var="UrlApiDiaChi" value="/api-dia-chi" />
		<!DOCTYPE html>
		<html lang="en">

		<head>
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
														<h4 class="card-title">Thông tin</h4>
														<form class="forms-sample">
															<div class="form-group">
																<label for="exampleInputName1">Họ và tên</label> <input
																	type="text" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleInputEmail3">Ngày sinh</label> <input
																	type="date" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleSelectGender">Giới tính</label>
																<select class="form-control">
																	<option>Nam</option>
																	<option>Nữ</option>
																</select>
															</div>
															<div class="form-group">
																<label for="exampleInputEmail3">CMND/CCCD</label> <input
																	type="text" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleInputEmail3">Dân tộc</label> <input
																	type="text" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleInputEmail3">Tôn giáo</label> <input
																	type="text" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleInputCity1">Quê quán</label><br>
																<label for="exampleInputCity1">Tỉnh thành</label>
																<select class="form-control tinhthanh">
																	<option selected>-- chọn tỉnh thành --</option>
																	<c:forEach items="${listDiaChi }" var="d">
																		<option>${d.name }</option>
																	</c:forEach>
																</select> <label for="exampleInputCity1">Quận
																	huyện</label> <select
																	class="form-control quanhuyen">
																	<option selected>-- chọn quận/huyện --</option>
																</select> <label for="exampleInputCity1">Xã /
																	Phường</label> <select
																	class="form-control xaphuong">
																	<option selected>-- chọn xã/phường --</option>
																</select> <label for="exampleInputCity1">Thôn /
																	Xóm</label> <select class="form-control thonxom">
																	<option selected>-- chọn thôn /xóm / tổ --</option>
																</select>
															</div>
															<div class="form-group">
																<label for="exampleInputCity1">Đ/c thường
																	trú</label><br>
																<label for="exampleInputCity1">Tỉnh thành</label>
																<select class="form-control tinhthanh">
																	<option selected>-- chọn tỉnh thành --</option>
																	<c:forEach items="${listDiaChi }" var="d">
																		<option>${d.name }</option>
																	</c:forEach>
																</select> <label for="exampleInputCity1">Quận
																	huyện</label> <select
																	class="form-control quanhuyen">
																	<option selected>-- chọn quận/huyện --</option>
																</select> <label for="exampleInputCity1">Xã /
																	Phường</label> <select
																	class="form-control xaphuong">
																	<option selected>-- chọn xã/phường --</option>
																</select> <label for="exampleInputCity1">Thôn /
																	Xóm</label> <select class="form-control thonxom">
																	<option selected>-- chọn thôn /xóm / tổ --</option>
																</select>
															</div>
															<div class="form-group">
																<label for="exampleInputCity1">Đ/c tạm trú</label><br>
																<label for="exampleInputCity1">Tỉnh thành</label>
																<select class="form-control tinhthanh">
																	<option selected>-- chọn tỉnh thành --</option>
																	<c:forEach items="${listDiaChi }" var="d">
																		<option>${d.name }</option>
																	</c:forEach>
																</select> <label for="exampleInputCity1">Quận
																	huyện</label> <select
																	class="form-control quanhuyen">
																	<option selected>-- chọn quận/huyện --</option>
																</select> <label for="exampleInputCity1">Xã /
																	Phường</label> <select
																	class="form-control xaphuong">
																	<option selected>-- chọn xã/phường --</option>
																</select> <label for="exampleInputCity1">Thôn /
																	Xóm</label> <select class="form-control thonxom">
																	<option selected>-- chọn thôn /xóm / tổ --</option>
																</select>
															</div>
															<div class="form-group">
																<label for="exampleInputCity1">Trình độ văn hóa</label>
																<input type="text" class="form-control">
															</div>
															<div class="form-group">
																<label for="exampleInputEmail3">Nghề nghiệp</label>
																<input type="text" class="form-control">
															</div>
															<button type="submit"
																class="btn btn-primary me-2">Thêm</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- BEGIN: NAV -->
									<%@ include file="/views/jsp/common/footer.jsp" %>
										<!-- END: NAV -->
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
			<script src="https://momentjs.com/downloads/moment.min.js"></script>
			<script>
				$('.tinhthanh').on('click', function (e) {
					e.preventDefault()
					var dataGet = []
					var select = $(this).closest('.form-group').find('select')
					var tinh = select.eq(0).val().trim()
					t = {}
					t['name'] = tinh
					dataGet.push(t)
					getDiaChi(dataGet, select.eq(1))
				})
				$('.quanhuyen').on('click', function (e) {
					e.preventDefault()
					var dataGet = []
					var select = $(this).closest('.form-group').find('select')
					var tinh = select.eq(0).val().trim()
					var huyen = select.eq(1).val().trim()
					t = {}
					t['name'] = tinh
					dataGet.push(t)
					h = {}
					h['name'] = huyen
					dataGet.push(h)
					getDiaChi(dataGet, select.eq(2))
				})
				$('.xaphuong').on(
					'click',
					function (e) {
						e.preventDefault()
						var dataGet = []
						var select = $(this).closest('.form-group').find('select')
						var tinh = select.eq(0).val().trim()
						var huyen = select.eq(1).val().trim()
						var xaphuong = select.eq(2).val().trim()
						t = {}
						t['name'] = tinh
						dataGet.push(t)
						h = {}
						h['name'] = huyen
						dataGet.push(h)
						p = {}
						p['name'] = xaphuong
						dataGet.push(p)
						getDiaChi(dataGet, select.eq(3))
					})
				function getDiaChi(dataGet, thisSelect) {
					$.ajax({
						type: "POST",
						url: "${UrlApiDiaChi}",
						contentType: "application/json",
						data: JSON.stringify(dataGet),
						dataType: "json",
						error: function () {
							// alert("lỗi")
						},
						success: function (data) {
							console.log(data);
							$(thisSelect).find('option').remove()
							$(data).each(function (i, e) {
								$(thisSelect).append('<option>' + e.name + '</option>')
							})
						}
					});
				}
				$('button.btn-primary').on(
					'click',
					function (e) {
						e.preventDefault()
						dataPost = {}
						var group = $(this).closest('.forms-sample').find(
							'.form-group')
						var hoten = group.eq(0).find('input').val().trim()
						var ngaysinh = group.eq(1).find('input').val().trim()
						var gioitinh = group.eq(2).find('select').val().trim()
						var cmnd = group.eq(3).find('input').val().trim()
						var dantoc = group.eq(4).find('input').val().trim()
						var tongiao = group.eq(5).find('input').val().trim()
						var quequan = group.eq(6).find('select')
						var thuongtru = group.eq(7).find('select')
						var tamtru = group.eq(8).find('select')
						var trinhdohv = group.eq(9).find('input').val().trim()
						var nghenghiep = group.eq(10).find('input').val().trim()
						if (hoten && ngaysinh && gioitinh && cmnd && dantoc
							&& tongiao && quequan && thuongtru && tamtru
							&& trinhdohv && nghenghiep) {
							dataPost['hoten'] = hoten
							dataPost['ngaysinh'] = ngaysinh
							dataPost['gioitinh'] = gioitinh
							dataPost['cmnd'] = cmnd
							dataPost['dantoc'] = dantoc
							dataPost['tongiao'] = tongiao
							dataPost['quequan'] = quequan.eq(0).val().trim() + ',' + quequan.eq(1).val().trim() + ',' + quequan.eq(2).val().trim() + ',' + quequan.eq(3).val().trim()
							dataPost['thuongtru'] = thuongtru.eq(0).val().trim() + ',' + thuongtru.eq(1).val().trim() + ',' + thuongtru.eq(2).val().trim() + ',' + thuongtru.eq(3).val().trim()
							dataPost['tamtru'] = tamtru.eq(0).val().trim() + ',' + tamtru.eq(1).val().trim() + ',' + tamtru.eq(2).val().trim() + ',' + tamtru.eq(3).val().trim()
							dataPost['trinhdohv'] = trinhdohv
							dataPost['nghenghiep'] = nghenghiep
							console.log(dataPost);
							$.ajax({
								type: "POST",
								url: "${UrlApi}",
								contentType: "application/json",
								data: JSON.stringify(dataPost),
								dataType: "json",
								error: function () {
									alert("lỗi")
								},
								success: function (data) {
									alert(data.value)
								}
							});
						} else {
							alert("Thiếu thông tin !")
						}

					})
			</script>
		</body>

		</html>