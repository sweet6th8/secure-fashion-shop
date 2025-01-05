<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Nội dung của home.jsp -->
<section class="section-intro padding-y-sm">
    <div class="container">
        <div class="intro-banner-wrap">
            <img src="${pageContext.request.contextPath}/static/images/banners/1.jpg" class="img-fluid rounded" alt="Intro Banner">
        </div>
    </div>
</section>

<section class="section-name padding-y-sm">
    <div class="container">
        <header class="section-heading">
            <a href="${pageContext.request.contextPath}/category?id=all" class="btn btn-outline-primary float-right">See all</a>
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
                                        <img src="${pageContext.request.contextPath}/${product.photo}" alt="${product.name}">
                                    </a>
                                </div>

                                <figcaption class="info-wrap">
                                    <a href="./product?id=${product.id}" class="title">${product.name}</a>
                                    <div class="price mt-1">$ ${product.price}</div>
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
