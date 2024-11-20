<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">

<head>
  <meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
  <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css"
    rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet"
    media="only screen and (max-width: 1200px)" />
  <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>
  <link href="src/main/webapp/static/js/register.js" />
  <title>GreatKart | One of the Biggest Online Shopping Platform</title>

  <!-- Favicon -->
  <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <!-- jQuery -->
  <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js" type="text/javascript"></script>

  <!-- Bootstrap4 files -->
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css" />

  <!-- Font awesome 5 -->
  <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css"
    rel="stylesheet">

  <!-- Custom style -->
  <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet"
    media="only screen and (max-width: 1200px)" />

  <!-- Custom javascript -->
  <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>



</head>

<body>
  <section class="section-conten padding-y" style="min-height:84vh">
    <div class="card mx-auto" style="max-width: 380px; margin-top:100px;">
      <div class="card-body">
        <h4 class="card-title mb-4">Sign in</h4>
        <form action="login" method="GET">
          <div class="form-group">
            <input type="email" class="form-control" placeholder="Email Address" name="email">
          </div> <!-- form-group// -->
          <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" name="password">
          </div> <!-- form-group// -->
          <div class="form-group">
            <a href="forgetPassword.jsp" class="float-right">Forgot password?</a>
          </div> <!-- form-group form-check .// -->
          <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block"> Login </button>
          </div> <!-- form-group// -->
          <!-- Hiển thị thông báo lỗi nếu có -->
          <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
          </c:if>
        </form>
      </div> <!-- card-body.// -->
    </div> <!-- card .// -->
    <p class="text-center mt-4">Don'\'t have account? <a href="register.jsp">Sign up</a></p>
    <br><br>
  </section>
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
</body>

</html>