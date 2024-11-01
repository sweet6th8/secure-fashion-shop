<!-- Chức năng: Trang chính hiển thị danh sách sản phẩm nổi bật và các banner quảng cáo.
     Nội dung: Danh sách sản phẩm từ cơ sở dữ liệu, các mục quảng cáo và liên kết đến các trang khác. -->



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

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
                          // Lấy danh sách sản phẩm từ request
                                     List<Product> productList = (List<Product>) request.getAttribute("productList");
                
                                     // Kiểm tra xem danh sách sản phẩm có null hay không
                                     if (productList != null && !productList.isEmpty()) {
                                         for (Product product : productList) {
                                         System.out.println(product.getId());
                                 %>
                                     <div class="col-md-3">
                                         <div class="card card-product-grid">
                                             <a href="" class="img-wrap">
                                                 <img src="<%= product.getPhoto() != null ? product.getPhoto() : "" %>">
                                             </a>
                                             <figcaption class="info-wrap">
                                                 <a href="./product-detail.jsp?id=<%= product.getId() %>" class="title"><%= product.getName() %></a>
                                                 <div class="price mt-1">$<%= product.getPrice() %></div>
                                             </figcaption>
                                         </div>
                                     </div>
                                 <%
                                         } // Kết thúc vòng lặp
                                     } else {
                                 %>
                                     <div class="col-md-12">
                                         <p>No products available.</p>
                                     </div>
                                 <%
                                     } // Kết thúc kiểm tra
                                 %>
        </div>
    </div>
</section>
