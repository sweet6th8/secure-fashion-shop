
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title>
    <meta charset="utf-8"/>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>GreatKart | One of the Biggest Online Shopping Platform</title>

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon"/>


    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js" type="text/javascript"></script>

    <!-- Bootstrap4 files -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <!-- Font awesome 5 -->
    <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css"
          rel="stylesheet"/>

    <!-- Custom style -->
    <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet"
          media="only screen and (max-width: 1200px)"/>

    <!-- Custom javascript -->
    <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>
</head>
<style>

    /* Tabs */
    .tabs {
        display: flex;
        border-bottom: 1px solid #ccc;
        margin-bottom: 15px;
    }

    .tab-btn {
        flex: 1;
        padding: 10px;
        background-color: #eee;
        border: none;
        cursor: pointer;
    }

    .tab-btn.active,
    .tab-btn:hover {
        background-color: #007bff;
        color: #fff;
    }

    .tab-content {
        display: none;
        height: 600px;
    }

    .tab-content.active {
        display: block;
    }
.col-md-12 a {
    font-size: 24px;
    margin: 10px;

}

</style>
<body>
<%@ include file="/templates/includes/navbar.jsp" %>
<section class="section-content">
<div class="container p-4">
<div class="row ">
    <div class="col-md-4">
     <div class="container">
         <div class="row">
             <div class="col-md-2">
                 <img src="../static/images/avatars/guest.png" class="img-fluid" alt="" style="width: 50px; height: 50px;"/>
             </div>
             <div class="col-md-6">
                 <h4>Trần Nhựt Anh</h4>
                 <a href="edit?id=123">Chỉnh sửa hồ sơ </a>
             </div>
         </div>
         <div class="row">
             <div class="col-md-12">
                 <a href="myAccount.jsp">My Account</a>
             </div>
         </div>
         <div class="row">
             <div class="col-md-12">
                 <a href="order">Orders</a>
             </div>
         </div>
         <div class="row">
             <div class="col-md-12">
                 <a href="notify">Notify</a>
             </div>
         </div>
         <div class="row">
             <div class="col-md-12">
                 <a href="voucher">Voucher</a>
             </div>
         </div>
     </div>
    </div>
    <div class="col-md-8">
        <div class="header">
            <ul class="sidenav d-flex gap-4 m-2 nav-underline">
                <a onclick="openTab(0)" href="#" class="nav-item nav-link fw-bold fs-3 text-black-50">Home</a>
                <a onclick="openTab(1)" href="#" class="nav-item nav-link fw-bold fs-3 text-black-50">Group diary</a>
                <a onclick="openTab(2)" href="#" class="nav-item nav-link fw-bold fs-3 text-black-50">Project</a>
            </ul>
        <div id="requirement" class="tab-content"> re </div>
        <div id="design" class="tab-content"> de </div>
        <div id="implementation" class="tab-content"> im </div>

    </div>
</div>
</div>
</div>
</section>
<script>
    console.log("check event")
    const tab = document.getElementsByClassName("tab-content");
    const tabLink = document.getElementsByClassName("tab-btn");
    const listLink = Array.from(tabLink);
    const listTab = Array.from(tab);

    function openTab(index) {
        listLink.forEach(content => content.classList.remove("bg-primary"));
        listTab.forEach(content => content.classList.remove("active"));
        listTab[index].classList.add("active");
        listLink[index].classList.add("bg-primary");
    }

</script>
<%--<%@ include file="/templates/includes/footer.jsp" %>--%>

</body>
</html>
