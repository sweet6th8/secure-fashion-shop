<!--Chức năng: Hiển thị sản phẩm theo danh mục (ví dụ: quần áo nam, nữ, trẻ em).
    Nội dung: Danh sách sản phẩm thuộc danh mục cụ thể mà người dùng chọn.-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="model.Category" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
  <meta charset="utf-8">

     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>Our store</title>

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
                                    <li><a href="${pageContext.request.contextPath}/category?id=all">All products</a></li>
                                    <%
                                        List<Category> categories = (List<Category>) application.getAttribute("categoryList");
                                       if (categories != null) {
                                            for (Category category : categories) {
                                    %>
                                        <li>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/category?id=<%= category.getId() %>">
                                                <%= category.getTitle() %>
                                            </a>
                                        </li>
                                    <%
                                            }
                                        } else {
                                    %>
                                        <li>No categories available.</li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                        </div>
                    </article>

                    <!-- Các filter cho sizes và price range có thể giữ nguyên -->
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
                                <a href="#" data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" class="">
                                    <i class="icon-control fa fa-chevron-down"></i>
                                    <h6 class="title">Price range</h6>
                                </a>
                            </header>
                            <div class="filter-content collapse show" id="collapse_3">
                                <div class="card-body">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label>Min</label>
                                            <select name="minPrice" class="mr-2 form-control">
                                                <option value="0">$0</option>
                                                <option value="50">$50</option>
                                                <option value="100">$100</option>
                                                <option value="150">$150</option>
                                                <option value="200">$200</option>
                                                <option value="500">$500</option>
                                                <option value="1000">$1000</option>
                                            </select>
                                        </div>
                                        <div class="form-group text-right col-md-6">
                                            <label>Max</label>
                                            <select name="maxPrice" class="mr-2 form-control">
                                                <option value="50">$50</option>
                                                <option value="100">$100</option>
                                                <option value="150">$150</option>
                                                <option value="200">$200</option>
                                                <option value="500">$500</option>
                                                <option value="1000">$1000</option>
                                                <option value="2000">$2000+</option>
                                            </select>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-block btn-primary">Apply</button>
                                </div>
                            </div>
                        </article>
                    </form>

                </div>
            </aside>

            <main class="col-md-9">
                <header class="border-bottom mb-4 pb-3">
                    <div class="form-inline">
                        <%
                            // Get the product list from the request
                            List<Product> productList = (List<Product>) request.getAttribute("productList");

                            // Get the count of items
                            int itemCount = (productList != null) ? productList.size() : 0; // Ensure null check to avoid NullPointerException
                        %>
                        <span class="mr-md-auto"><b><%= itemCount %></b> Items found</span>
                    </div>
                </header>

                <div class="row">
                    <%
                        // If productList is not null, iterate over it and display products
                        if (productList != null) {
                            for (Product product : productList) {
                    %>
                    <div class="col-md-4">
                        <figure class="card card-product-grid">
                            <div class="img-wrap">
                               <a href="./product?id=<%= product.getId() %>" ><img src="<%= product.getPhoto() %>" alt="<%= product.getName() %>"></a>
                            </div>
                            <figcaption class="info-wrap">
                                <div class="fix-height">
                                    <a href="./product?id=<%= product.getId() %>" class="title"><%= product.getName() %></a>
                                    <div class="price-wrap mt-2">
                                        <span class="price">$ <%= product.getPrice() %></span>
                                    </div>
                                </div>
                                <a href="addToCart?id=<%= product.getId() %>" class="btn btn-block btn-success">Add to cart</a>
                            </figcaption>
                        </figure>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <div class="col-md-12">
                        <p>No products found.</p>
                    </div>
                    <%
                        }
                    %>
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
