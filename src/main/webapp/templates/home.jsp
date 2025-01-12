<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--declare resource--%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />

<c:set var="Context" value="${pageContext.request.contextPath}"/>
<!-- Nội dung của home.jsp -->
<section class="section-intro padding-y-sm">
    <div class="container">
        <div class="intro-banner-wrap">
            <img src="${Context}/static/images/banners/1.jpg" class="img-fluid rounded"
                 alt="Intro Banner">
        </div>
        <!-- New Try On Button -->
        <div class="text-center mt-3">
            <a href="${Context}/templates/tryon.jsp" class="btn btn-primary">Try On</a>
        </div>
    </div>
</section>

<section class="section-name padding-y-sm">
    <p class="fa-2x">
        <fmt:message key="welcome" /></p>

    <div class="container">
        <header class="section-heading">
            <a href="${Context}/category?id=all" class="btn btn-outline-primary float-right">See
                all</a>
            <h3 class="section-title">Popular products</h3>
        </header>
        <div class="row">
            <c:choose>
                <c:when test="${not empty productList}">
                    <c:forEach var="product" items="${productList}">
                        <div class="col-md-3">
                            <div class="card card-product-grid">
                                <div class="img-wrap">
                                    <a href="./product?id=${product.id}">
                                        <img src="${Context}/${product.photo}"
                                             alt="${product.name}">
                                    </a>
                                </div>

                                <figcaption class="info-wrap">
                                    <a href="./product?id=${product.id}" class="title">${product.name}</a>
                                    <div class="price mt-1">
                                        <fmt:message key="exchangeRate" var="rate"/>
                                        <fmt:formatNumber value="${product.price * rate }"
                                                          maxFractionDigits="0"
                                        />
                                        <fmt:message key="currency"/>
                                    </div>
                                </figcaption>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="col-md-12">
                        <p>No products available.</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>
