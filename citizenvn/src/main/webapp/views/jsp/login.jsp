<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=	no">
  <title>CitizenVn login </title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/feather/feather.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/typicons/typicons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/simple-line-icons/css/simple-line-icons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/template/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/views/template/images/favicon.png" />
</head>

<body>
  <div class="container-scroller" >
    <div class="container-fluid page-body-wrapper full-page-wrapper" >
      <div class="content-wrapper d-flex align-items-center auth px-0" style="background-color: rgb(155, 183, 235); ">
        <div class="row w-100 mx-0" >
          <div class="col-lg-4 mx-auto" >
            <div class="auth-form-light text-left py-5 px-4 px-sm-5" style="border-radius: 5px;">
              <h4 style="text-align: center;">CitizenVN</h4>
              <form class="pt-3" action="login" method="POST">
                <div class="form-group">
                  <input name = "user" class="form-control form-control-lg"  placeholder="Tên đăng nhập" >
                </div>
                <div class="form-group">
                  <input name = "pass" type="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Mật khẩu">
                </div>
                <div class="form-check">
                    <input type="checkbox">
                    Lưu tài khoản
                </div>
                <div class="mt-3">
                  <button class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Đăng nhập</button>
                </div>
                <div class="my-2 d-flex justify-content-between align-items-center">
                  <a href="#" class="auth-link text-black">Quên mật khẩu</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/views/template/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="${pageContext.request.contextPath}/views/template/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/views/template/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/views/template/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/views/template/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/views/template/js/settings.js"></script>
  <script src="${pageContext.request.contextPath}/views/template/js/todolist.js"></script>
  <!-- endinject -->
</body>

</html>
