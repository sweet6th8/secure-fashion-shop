<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>GreatKart | One of the Biggest Online Shopping Platform</title>
    <%@include file="templates/headerResource.jsp"%>

</head>

<body>
     <!-- Navbar -->
         <%@ include file="templates/includes/navbar.jsp" %>

         <!-- Main Content Area -->
     <jsp:include page="templates/home.jsp">
         <jsp:param name="contentPage" value="/templates/home.jsp" />
     </jsp:include>
         <!-- Footer -->
         <%@ include file="templates/includes/footer.jsp" %>
         <script src ="src/main/webapp/js/script.js"></script>
</body>
</html>
