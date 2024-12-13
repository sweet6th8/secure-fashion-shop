<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>GreatKart | One of the Biggest Online Shopping Platform</title>

    <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js" type="text/javascript"></script>

    <!-- Bootstrap4 files-->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <!-- Font awesome 5 -->
    <link href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css" type="text/css" rel="stylesheet">

    <!-- custom style -->
    <link href="${pageContext.request.contextPath}/static/css/ui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)" />

    <!-- custom javascript -->
    <script src="${pageContext.request.contextPath}/static/js/script.js" type="text/javascript"></script>

</head>
<body>
<%@ include file="/templates/includes/navbar.jsp" %>

<section class="section-content padding-y bg">
    <div class="container">

        <!-- Cart Section -->
        <div class="row">
            <aside class="col-lg-9">
                <div class="card">
                    <table class="table table-borderless table-shopping-cart">
                        <thead class="text-muted">
                        <tr class="small text-uppercase">
                            <th scope="col">Product</th>
                            <th scope="col" width="120">Quantity</th>
                            <th scope="col" width="120">Price</th>
                            <th scope="col" class="text-right" width="200"> </th>
                        </tr>
                        </thead>
                        <tbody>


                        <c:forEach var="cartItem" items="${cart.items.values()}">
                            <pre>${cartItem}</pre>

                            <tr>
                                <td>
                                    <figure class="itemside align-items-center">
<%--                                        <div class="aside"><img src="<c:out value='${cartItem.product.photo}'/>" class="img-sm"></div>--%>
                                        <figcaption class="info">
                                            <a href="#" class="title text-dark"><c:out value='${cartItem.product.name}'/></a>
                                        </figcaption>
                                    </figure>
                                </td>
                                <td>
                                    <div class="input-group">
                                        <input type="number" class="form-control" value="<c:out value='${cartItem.product.quantity}'/>" min="1">
                                    </div>
                                </td>
                                <td>
                                    <div class="price-wrap">
                                        <var class="price"><c:out value='${cartItem.getTotalPrice}'/></var>
                                        <small class="text-muted"> ${cartItem.product.price} each </small>
                                    </div>
                                </td>
                                <td class="text-right">
                                    <form action="removeFromCart" method="POST">
                                        <input type="hidden" name="productId" value="<c:out value='${cartItem.product.id}'/>">
                                        <button type="submit" class="btn btn-danger"> Remove</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </aside>

            <aside class="col-lg-3">
                <div class="card">
                    <div class="card-body">
                        <dl class="dlist-align">
                            <dt>Total:</dt>
                            <dd class="text-right"> <strong><c:out value='${totalPrice}'/> USD</strong> </dd>
                        </dl>
                        <hr>
                        <a href="checkout" class="btn btn-primary btn-block">Proceed to checkout</a>
                    </div>
                </div>
            </aside>

        </div>

    </div>
</section>
<%@ include file="/templates/includes/footer.jsp" %>
</body>
</html>
