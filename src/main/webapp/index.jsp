<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>GreatKart | One of the Biggest Online Shopping Platform</title>
    <!-- Favicon -->
    <link href="static/images/favicon.ico" rel="shortcut icon" type="image/x-icon">


    <!-- jQuery -->
    <script src="static/js/jquery-2.0.0.min.js" type="text/javascript"></script>

    <!-- Bootstrap4 files -->
    <script src="static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <!-- Font awesome 5 -->
    <link href="static/fonts/fontawesome/css/all.min.css" type="text/css" rel="stylesheet">

    <!-- Custom style -->
    <link href="static/css/ui.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)"/>

    <!-- Custom javascript -->
    <script src="static/js/script.js" type="text/javascript"></script>
</head>
<body>
<!-- Navbar -->
<%@ include file="templates/includes/navbar.jsp" %>

<!-- Main Content Area -->
<div class="container">
    <jsp:include page="templates/home.jsp">
        <jsp:param name="contentPage" value="/templates/home.jsp"/>
    </jsp:include>
</div>
<button id="cai-nut">Cai nut</button>
<div id="person">
    <h1>Ca khung</h1>
    <h3 id="name-person"></h3>
    <p id="age-person"></p>
</div>
<script>
    $.ajax({
        url: "http://localhost:8080/FashionWebProject/HelloWorld",
        success: (res) => {
            console.log(res)
            //Window.
            $("#name-person").text(res.name);
            $("#age-person").text(res.age);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
        }
    });

</script>
<!-- Footer -->
<%@ include file="templates/includes/footer.jsp" %>
<script src="src/main/webapp/js/script.js"></script>
</body>
</html>
