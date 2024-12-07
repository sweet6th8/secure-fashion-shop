<!--Chức năng: Hiển thị sản phẩm theo danh mục (ví dụ: quần áo nam, nữ, trẻ em).
Nội dung: Danh sách sản phẩm thuộc danh mục cụ thể mà người dùng chọn.-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Our store</title>
<jsp:include page="headerResource.jsp"/>
</head>
</head>
<body>


<%@ include file="/templates/includes/navbar.jsp" %>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
    <div class="container">
        <h2 class="title-page">Our Store</h2>
    </div>
</section>

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
    <div class="container">
        <div class="row">
            <aside class="col-md-3">
                <div class="card">
                    <article class="filter-group">
                        <header class="card-header">
                            <a href="#" data-toggle="collapse" data-target="#collapse_1" aria-expanded="true" class="">
                                <i class="icon-control fa fa-chevron-down"></i>
                                <h6 class="title">Categories</h6>
                            </a>
                        </header>
                        <div class="filter-content collapse show" id="collapse_1">
                            <div class="card-body">
                                <ul class="list-menu">
                                    <li><a href="${pageContext.request.contextPath}/category?id=all">All products</a>
                                    </li>
                                    <c:set var="list" value="${applicationScope.categoryList}"/>
                                    <c:choose>
                                        <c:when test="${list!= null}">
                                            <c:forEach var="item" items="${list}">
                                                <li>
                                                    <a class="dropdown-item"
                                                       href="${pageContext.request.contextPath}/category?id=${item.getId()}">
                                                            ${ item.getTitle()}
                                                    </a>
                                                </li>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <li>No categories available.</li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </article>

                    <!-- Các Filter cho sizes và price range có thể giữ nguyên -->
                    <article class="filter-group">
                        <header class="card-header">
                            <a href="#" data-toggle="collapse" data-target="#collapse_4" aria-expanded="true" class="">
                                <i class="icon-control fa fa-chevron-down"></i>
                                <h6 class="title">Sizes</h6>
                            </a>
                        </header>
                        <div class="filter-content collapse show" id="collapse_4">
                            <div class="card-body">
                                <label class="checkbox-btn">
                                    <input type="checkbox">
                                    <span class="btn btn-light"> XS </span>
                                </label>
                                <label class="checkbox-btn">
                                    <input type="checkbox">
                                    <span class="btn btn-light"> SM </span>
                                </label>
                                <label class="checkbox-btn">
                                    <input type="checkbox">
                                    <span class="btn btn-light"> LG </span>
                                </label>
                                <label class="checkbox-btn">
                                    <input type="checkbox">
                                    <span class="btn btn-light"> XXL </span>
                                </label>
                            </div>
                        </div>
                    </article>
                    <form action="filter" method="post">
                        <article class="filter-group">
                            <header class="card-header">
                                <a href="#" data-toggle="collapse" data-target="#collapse_3" aria-expanded="true"
                                   class="">
                                    <i class="icon-control fa fa-chevron-down"></i>
                                    <h6 class="title">Price range</h6>
                                </a>
                            </header>
                            <div class="filter-content collapse show" id="collapse_3">
                                <div class="card-body">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label>Min</label>
                                            <label>
                                                <select name="minPrice" class="mr-2 form-control">
                                                    <option value="0">$0</option>
                                                    <option value="50">$50</option>
                                                    <option value="100">$100</option>
                                                    <option value="150">$150</option>
                                                    <option value="200">$200</option>
                                                    <option value="500">$500</option>
                                                    <option value="1000">$1000</option>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="form-group text-right col-md-6">
                                            <label>Max</label>
                                            <label>
                                                <select name="maxPrice" class="mr-2 form-control">
                                                    <option value="50">$50</option>
                                                    <option value="100">$100</option>
                                                    <option value="150">$150</option>
                                                    <option value="200">$200</option>
                                                    <option value="500">$500</option>
                                                    <option value="1000">$1000</option>
                                                    <option value="2000">$2000+</option>
                                                </select>
                                            </label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-block btn-primary">Apply</button>
                                </div>
                            </div>
                        </article>
                    </form>

                </div>
            </aside>
            <c:set var="products" value="${requestScope.productList}"/>
            <main class="col-md-9">
                <header class="border-bottom mb-4 pb-3">
                    <div class="form-inline">

                        <span class="mr-md-auto"><b><c:out value="${products.size()}"/> </b> Items found</span>
                    </div>
                </header>
                <div class="row">
                    <c:choose>
                        <c:when test="${products!= null}">
                            <c:forEach var="item" items="${products}">
                                <div class="col-md-4">
                                    <figure class="card card-product-grid">
                                        <div class="img-wrap">
                                            <a href="./product?id=${item.getId()}">
                                                <img src="${pageContext.request.contextPath}${item.getPhoto()}"
                                                     alt="${item.getName()}"></a>
                                        </div>
                                        <figcaption class="info-wrap">
                                            <div class="fix-height">
                                                <a href="./product?id=${item.getId()}"
                                                   class="title">${item.getName()}</a>
                                                <div class="price-wrap mt-2">
                                                    <span class="price">${ item.getPrice()}</span>
                                                </div>
                                            </div>
                                            <a href="#" class="btn btn-block btn-success">Add to cart</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-12">
                                <p>No products found.</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <nav class="mt-4" aria-label="Page navigation sample">
                    <ul class="pagination">
                        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                </nav>
            </main>
        </div>
    </div>
</section>

<%@ include file="/templates/includes/footer.jsp" %>
</body>
</html>
