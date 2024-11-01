<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="model.Product" %>
<!-- Nội dung của home.jsp -->

<section class="section-intro padding-y-sm">
    <div class="container">
        <div class="intro-banner-wrap">
             <img src="${pageContext.request.contextPath}/static/images/banners/1.jpg" class="img-fluid rounded">
        </div>
    </div>
</section>

<section class="section-name padding-y-sm">
    <div class="container">
        <header class="section-heading">

               <a href="${pageContext.request.contextPath}/store" class="btn btn-outline-primary float-right">See all</a>


                      <h3 class="section-title">Popular products</h3>
          </header>

        <div class="row">
                        <%
                                      ProductDAO productDAO = new ProductDAO();
                                      List<Product> productList = productDAO.getAllProducts();
                                      System.out.println("Empty ");
                                      for (Product product : productList) {
                                      System.out.println("Product " + product.getId());
                                  %>
                                      <div class="col-md-3">
                                          <div class="card card-product-grid">
                                              <a href="./product-detail.jsp?id=<%= product.getId() %>" class="img-wrap">
                                                  <img src="<%= product.getPhoto() != null ? product.getPhoto() : "default-image.jpg" %>">
                                              </a>
                                              <figcaption class="info-wrap">
                                                  <a href="./product-detail.jsp?id=<%= product.getId() %>" class="title"><%= product.getName() %></a>
                                                  <div class="price mt-1">$<%= product.getPrice() %></div>
                                              </figcaption>
                                          </div>
                                      </div>
                                  <%
                                      } // End of product list iteration
                                  %>
        </div>
    </div>
</section>
