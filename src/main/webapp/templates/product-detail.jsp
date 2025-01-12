<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<fmt:message key="exchangeRate" var="rate"/>
<fmt:message key="currency" var="currency"/>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>GreatKart | One of the Biggest Online Shopping Platform</title>
    <jsp:include page="headerResource.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navbar.css" type="text/css"/>
</head>
<body>
<!-- Navbar -->
<%@ include file="includes/navbar.jsp" %>
<c:set var="singleProduct" value="${requestScope.product}"/>
<section class="section-content padding-y bg mt-5">
    <div class="container">
        <!-- ============================ COMPONENT 1 ================================= -->
        <div class="card">
            <div class="row no-gutters">
                <aside class="col-md-6">
                    <article class="gallery-wrap">
                        <div class="img-big-wrap">
                            <a href="#"><img src="${pageContext.request.contextPath}/${singleProduct.getPhoto()}"
                                             alt="${singleProduct.getName()}"></a>
                        </div> <!-- img-big-wrap.// -->
                    </article> <!-- gallery-wrap .end// -->
                </aside>
                <main class="col-md-6 border-left">
                    <article class="content-body">

                        <h2 class="title">${singleProduct.getName()}</h2>

                        <div class="mb-3">
                            <fmt:formatNumber value="${singleProduct.getPrice() * rate}"
                                              maxFractionDigits="0"
                            />
                            ${currency}
                        </div>

                        <p>${singleProduct.getDescription()}</p>
                        <hr>
                        <!-- item-option-select -->
                        <%--                         <hr>--%>
                        <%--                         <hr>--%>
                        <%--                         <div class="row">--%>
                        <%--                             <div class="item-option-select">--%>
                        <%--                                 <h6>Choose Color</h6>--%>
                        <%--                                 <div class="btn-group btn-group-sm btn-group-toggle" data-toggle="buttons">--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_color"> Silver--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_color" > Gray--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light active">--%>
                        <%--                                         <input type="radio" name="radio_color checked"> Gold--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_color"> Black--%>
                        <%--                                     </label>--%>
                        <%--                                 </div>--%>
                        <%--                             </div>--%>
                        <%--                         </div> <!-- row.// -->--%>
                        <%--                         <div class="row">--%>
                        <%--                             <div class="item-option-select">--%>
                        <%--                                 <h6>Select Size</h6>--%>
                        <%--                                 <div class="btn-group btn-group-sm btn-group-toggle" data-toggle="buttons">--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_size"> S--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light active">--%>
                        <%--                                         <input type="radio" name="radio_size" checked> M--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_size"> L--%>
                        <%--                                     </label>--%>
                        <%--                                     <label class="btn btn-light">--%>
                        <%--                                         <input type="radio" name="radio_size"> XL--%>
                        <%--                                     </label>--%>
                        <%--                                 </div>--%>
                        <%--                             </div>--%>
                        <%--                         </div> <!-- row.// -->--%>
                        <%--                         <hr>--%>
                        <%--                         <a href="addToCart" class="btn  btn-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i>  </a>--%>
                        <form action="${pageContext.request.contextPath}/secure/cart" method="post">
                            <input type="hidden" name="action" value="addToCart">
                            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                            <%--                            <script>--%>
                            <%--                                $(document).ready(function () {--%>
                            <%--                                    $("#addToCartBtn").click(function (e) {--%>
                            <%--                                        e.preventDefault();--%>
                            <%--                                        const productId = $("#productId").val();--%>
                            <%--                                        const quantity = $("#quantity").val();--%>

                            <%--                                        $.ajax({--%>
                            <%--                                            url: "${pageContext.request.contextPath}/cart",--%>
                            <%--                                            type: "POST",--%>
                            <%--                                            data: {--%>
                            <%--                                                productId: productId,--%>
                            <%--                                                quantity: quantity--%>
                            <%--                                            },--%>
                            <%--                                            success: function (response) {--%>
                            <%--                                                if (response.success) {--%>
                            <%--                                                    // Display success notification--%>
                            <%--                                                    $("#notification").text("Item added to cart successfully!").css("color", "green");--%>
                            <%--                                                } else if (response.loginRequired) {--%>
                            <%--                                                    // Redirect to login page if user isn't logged in--%>
                            <%--                                                    window.location.href = "${pageContext.request.contextPath}/templates/login.jsp";--%>
                            <%--                                                } else {--%>
                            <%--                                                    // Display error message (e.g., out of stock)--%>
                            <%--                                                    $("#notification").text(response.message).css("color", "red");--%>
                            <%--                                                }--%>
                            <%--                                            },--%>
                            <%--                                            error: function (xhr, status, error) {--%>
                            <%--                                                // Handle unexpected errors--%>
                            <%--                                                $("#notification").text("An unexpected error occurred. Please try again.").css("color", "red");--%>
                            <%--                                            }--%>
                            <%--                                        });--%>
                            <%--                                    });--%>
                            <%--                                });--%>
                            <%--                            </script>--%>

                            <%--                            <!-- Add To Cart Button, Notification Section, and Quantity Input -->--%>
                            <%--                            <div id="notification" style="margin-top: 10px; font-weight: bold;"></div>--%>
                            <%--&lt;%&ndash;                            <input type="hidden" id="productId" value="${singleProduct.getId()}"/>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;                            <input type="number" id="quantity" value="1" min="1"/>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;                            <button id="addToCartBtn">Add to Cart</button>&ndash;%&gt;--%>
                            <input type="hidden" name="productId" value="${singleProduct.getId()}">

                            <input type="number" name="quantity" min="1" value="1" required
                                   style="width: 80px; padding: 10px; font-size: 14px; text-align: left;">

                            <button type="submit" class="btn btn-primary">
                                <span class="text"> <fmt:message key="btnAddToCart"/></span>
                                <i class="fas fa-shopping-cart"></i>
                            </button>
                        </form>
                    </article> <!-- product-info-aside .// -->
                </main> <!-- col.// -->
            </div> <!-- row.// -->
        </div> <!-- card.// -->
        <br>
    </div> <!-- container .// -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->
<!-- Footer -->
<%--<script src="${pageContext.request.contextPath}/js/navbar.js"></script>--%>
<%@ include file="includes/footer.jsp" %>
</body>

