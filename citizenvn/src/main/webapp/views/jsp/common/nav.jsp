<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/home">
				<i class="mdi mdi-newspaper menu-icon"></i> <span class="menu-title">Tổng
					quan</span>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false"
			aria-controls="ui-basic"> <i class="menu-icon mdi mdi-account"></i>
				<span class="menu-title">Quản lí</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="ui-basic">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/cap-duoi">Cấp
							quyền</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/account">Thêm
							tài khoản</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#tables" aria-expanded="false"
			aria-controls="tables"> <i class="menu-icon mdi mdi-table"></i> <span
				class="menu-title">Dân số</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="tables">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/views/template/pages/tables/basic-table.html">Danh
							sách</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/people">Thêm
							người dân</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#icons" aria-expanded="false"
			aria-controls="icons"> <i class="menu-icon mdi mdi-history"></i>
				<span class="menu-title">Lịch sử</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="icons">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/views/template/pages/icons/mdi.html">Mdi
							icons</a></li>
				</ul>
			</div></li>
	</ul>
</nav>