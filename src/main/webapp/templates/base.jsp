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
    <!-- Navbar -->
   <%@ include file="includes/navbar.jsp" %>

 <!-- Đây là phần mà các trang khác sẽ nhúng nội dung vào -->
    <jsp:include page="${param.contentPage}" />

    <!-- Footer -->
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
