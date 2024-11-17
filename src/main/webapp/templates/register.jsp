<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>GreatKart | One of the Biggest Online Shopping Platform</title>
 <!-- Favicon -->
       <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon">


    <!-- jQuery -->
       <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js" type="text/javascript"></script>

    <!-- Bootstrap4 files -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

   <!-- Font awesome 5 -->
       <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css" rel="stylesheet">

       <!-- Custom style -->
       <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css"/>
       <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)" />

       <!-- Custom javascript -->
       <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>

</head>
<body>

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">

<!-- ============================ COMPONENT REGISTER   ================================= -->
	<div class="card mx-auto" style="max-width:520px; margin-top:40px;">
      <article class="card-body">
		<header class="mb-4"><h4 class="card-title">Sign up</h4></header>
		<form action="register">
				<div class="form-row">
					<div class="col form-group">
						<label >First name</label>
					  	<input name ="FirstName" type="text" class="form-control" placeholder="">
					</div> <!-- form-group end.// -->
					<div class="col form-group">
						<label>Last name</label>
					  	<input name ="LastName" type="text" class="form-control" placeholder="">
					</div> <!-- form-group end.// -->
				</div> <!-- form-row end.// -->
				<div class="form-group">
					<label>Email</label>
					<input name="Email" type="email" class="form-control" placeholder="">
					<small class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div> <!-- form-group end.// -->
				<div class="form-group">
					<label class="custom-control custom-radio custom-control-inline">
					  <input name="gender" class="custom-control-input" checked="" type="radio" name="gender" value="1">
					  <span class="custom-control-label"> Male </span>
					</label>
					<label class="custom-control custom-radio custom-control-inline">
					  <input name="gender" class="custom-control-input" type="radio" name="gender" value="0">
					  <span class="custom-control-label"> Female </span>
					</label>
				</div> <!-- form-group end.// -->
				<div class="form-row">
					<div class="form-group col-md-6">
					  <label>Quốc Gia</label>
					  <input type="text" class="form-control">
					</div> <!-- form-group end.// -->
					<div class="form-group col-md-6">
					  <label>Thành phố / Tỉnh</label>
					  <select name="city" id="inputState" class="form-control">
					    <option selected=""> Choose...</option>
					      <option name="city" value="Long An">Long An</option>
					      <option name="city" value="Bình Định">Bình Địng</option>
					      <option name="city" value="Quy Nhơn" >Quy Nhơn</option>
					      <option name="city" value="Quảng Ngãi">Quảng Ngãi</option>
					      <option name="city" value="Hà Nội">Hà Nội</option>
					      <option name="city" value="Hồ Chí Minh">Hồ Chí Minh</option>
					  </select>
					</div> <!-- form-group end.// -->
				</div> <!-- form-row.// -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Create password</label>
					    <input name="password" class="form-control" type="password">
					</div> <!-- form-group end.// -->
					<div class="form-group col-md-6">
						<label>Repeat password</label>
					    <input name="CheckPassword" class="form-control" type="password">
					</div> <!-- form-group end.// -->
				</div>
			    <div class="form-group">
			        <button type="submit" class="btn btn-primary btn-block"> Register  </button>
			    </div> <!-- form-group// -->

			</form>
		</article><!-- card-body.// -->
    </div> <!-- card .// -->
    <p class="text-center mt-4">Have an account? <a href="login.jsp">Log In</a></p>
    <br><br>
<!-- ============================ COMPONENT REGISTER  END.// ================================= -->


</section>
<!-- ========================= SECTION CONTENT END// ========================= -->


<!-- ========================= FOOTER ========================= -->
<footer class="section-footer border-top padding-y">
	<div class="container">
		<p class="float-md-right">
			&copy Copyright 2019 All rights reserved
		</p>
		<p>
			<a href="#">Terms and conditions</a>
		</p>
	</div><!-- //container -->
</footer>
<!-- ========================= FOOTER END // ========================= -->


</body>