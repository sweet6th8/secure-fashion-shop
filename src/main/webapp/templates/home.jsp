<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            <a href="./store.jsp" class="btn btn-outline-primary float-right">See all</a>
            <h3 class="section-title">Popular products</h3>
        </header>

        <div class="row">
            <div class="col-md-3">
                <div class="card card-product-grid">
                    <a href="./product-detail.jsp" class="img-wrap">
                         <img src="${pageContext.request.contextPath}/static/images/items/1.jpg">
                    </a>
                    <figcaption class="info-wrap">
                        <a href="./product-detail.jsp" class="title">Just another product name</a>
                        <div class="price mt-1">$179.00</div>
                    </figcaption>
                </div>
            </div>
            <!-- Repeat for other products -->
            <div class="col-md-3">
                <div class="card card-product-grid">
                    <a href="./product-detail.jsp" class="img-wrap">
                          <img src="${pageContext.request.contextPath}/static/images/items/2.jpg">
                    </a>
                    <figcaption class="info-wrap">
                        <a href="./product-detail.jsp" class="title">Some item name here</a>
                        <div class="price mt-1">$280.00</div>
                    </figcaption>
                </div>
            </div>
            	<div class= "col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			<img src="${pageContext.request.contextPath}/static/images/items/3.jpg"> </a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Great product name here</a>
            				<div class="price mt-1">$56.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
            	<div class="col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			<img src="${pageContext.request.contextPath}/static/images/items/4.jpg"> </a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Just another product name</a>
            				<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
            	<div class="col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			<img src="${pageContext.request.contextPath}/static/images/items/5.jpg"> </a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Just another product name</a>
            				<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
            	<div class="col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			 <img src="${pageContext.request.contextPath}/static/images/items/6.jpg"> </a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Some item name here</a>
            				<div class="price mt-1">$280.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
            	<div class="col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			<img src="${pageContext.request.contextPath}/static/images/items/7.jpg"></a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Great product name here</a>
            				<div class="price mt-1">$56.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
            	<div class="col-md-3">
            		<div class="card card-product-grid">
            			<a href="./product-detail.html" class="img-wrap">
            			<img src="${pageContext.request.contextPath}/static/images/items/8.jpg"> </a>
            			<figcaption class="info-wrap">
            				<a href="./product-detail.html" class="title">Just another product name</a>
            				<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
            			</figcaption>
            		</div>
            	</div> <!-- col.// -->
        </div>
    </div>
</section>
