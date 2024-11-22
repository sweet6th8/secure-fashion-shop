<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css"
          rel="stylesheet">

    <!-- Custom style -->
    <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet"
          media="only screen and (max-width: 1200px)"/>

    <!-- Custom javascript -->
    <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>
</head>
<body>
<!-- Navbar -->
<%@ include file="includes/navbar.jsp" %>
<c:set value="${requestScope.product}" var="item"/>
<!-- Main Content Area -->
<section class="section-content padding-y bg">
    <div class="container">
        <c:choose>
            <c:when test="${item!= null}">
                <div class="card">
                    <div class="row no-gutters">
                        <aside class="col-md-6">
                            <article class="gallery-wrap">
                                <div class="img-big-wrap">
                                    <a href="#"><img src="${pageContext.request.contextPath}${item.getPhoto()}"
                                                     alt="${ item.getName()}"></a>
                                </div> <!-- img-big-wrap.// -->
                            </article> <!-- gallery-wrap .end// -->
                        </aside>
                        <main class="col-md-6 border-left">
                            <article class="content-body">
                                <h2 class="title">${item.getName()}</h2>
                                <div class="mb-3">
                                    <var class="price h4">${item.getPrice()}</var>
                                </div>
                                <p>${item.getDescription()}</p>
                                <!-- item-option-select -->
                                <hr>
                                <hr>
                                <div class="row">
                                    <div class="item-option-select">
                                        <h6>Choose Color</h6>
                                        <div class="btn-group btn-group-sm btn-group-toggle" data-toggle="buttons">
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_color"> Silver
                                            </label>
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_color"> Gray
                                            </label>
                                            <label class="btn btn-light active">
                                                <input type="radio" name="radio_color checked"> Gold
                                            </label>
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_color"> Black
                                            </label>
                                        </div>
                                    </div>
                                </div> <!-- row.// -->
                                <div class="row">
                                    <div class="item-option-select">
                                        <h6>Select Size</h6>
                                        <div class="btn-group btn-group-sm btn-group-toggle" data-toggle="buttons">
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_size"> S
                                            </label>
                                            <label class="btn btn-light active">
                                                <input type="radio" name="radio_size" checked> M
                                            </label>
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_size"> L
                                            </label>
                                            <label class="btn btn-light">
                                                <input type="radio" name="radio_size"> XL
                                            </label>
                                        </div>
                                    </div>
                                </div> <!-- row.// -->
                                <hr>
                                <a href="addToCart?id=${singleProduct.getId()}&size=radio_size&color=radio_color"
                                   class="btn  btn-primary"> <span class="text">Add to cart</span> <i
                                        class="fas fa-shopping-cart"></i> </a>
                                <hr>
                            </article> <!-- product-info-aside .// -->
                        </main> <!-- col.// -->
                    </div> <!-- row.// -->
                </div>
                <!-- card.// -->
            </c:when>
            <c:otherwise>
                <h2>Product not found</h2>
            </c:otherwise>
        </c:choose>
        <br>
    </div> <!-- container .// -->
</section>
<!-- Footer -->
<%@ include file="includes/footer.jsp" %>
</body>