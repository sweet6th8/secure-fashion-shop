<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>

    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>GreatKart | One of the Biggest Online Shopping Platform</title>
    <link
            href="${pageContext.request.contextPath}/static/images/favicon.ico"
            rel="shortcut icon"
            type="image/x-icon"
    />
    <script
            src="${pageContext.request.contextPath}/static/js/jquery-2.0.0.min.js"
            type="text/javascript"
    ></script>
    <script
            src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"
            type="text/javascript"
    ></script>
    <link
            href="${pageContext.request.contextPath}/static/css/bootstrap.css"
            rel="stylesheet"
            type="text/css"
    />
    <link
            href="${pageContext.request.contextPath}/static/fonts/fontawesome/css/all.min.css"
            type="text/css"
            rel="stylesheet"
    />
    <link
            href="${pageContext.request.contextPath}/static/css/ui.css"
            rel="stylesheet"
            type="text/css"
    />
    <link
            href="${pageContext.request.contextPath}/static/css/responsive.css"
            rel="stylesheet"
            media="only screen and (max-width: 1200px)"
    />
    <script
            src="${pageContext.request.contextPath}/static/js/script.js"
            type="text/javascript"
    ></script>
</head>
<body>
<section class="section-conten padding-y" style="min-height: 84vh">
    <div class="card mx-auto" style="max-width: 380px; margin-top: 100px">
        <div class="card-body">
            <h4 class="card-title mb-4">Tạo mật khẩu mới</h4>
            <form action="CreatePassword" method="GET">
                <div class="form-row">
                    <label>Mật khẩu cũ</label>
                    <input id="OldPassword" name="Email" type="password" class="form-control" placeholder="" require>
                </div>
                <div class="form-row">

                    <label for="password">Mật khẩu:</label>
                    <input type="password" name="password" id="password" class="form-control"
                           onchange="validatePassword()">
                    <p id="password-error" style="color: red; display: none;">Mật khẩu phải có từ 8 đến 20 ký tự, bao
                        gồm chữ hoa, chữ thường, số và ký tự đặc biệt.</p>

                </div>
                <div class="form-row">
                    <label>Nhập lại mật khẩu </label>
                    <input id="Checkpassword" name="Checkpassword" class="form-control" type="password"
                           onChange="validateCheckPassword()">
                    <p id="Checkpassword-error" style="color: red; display: none;"> Mật khẩu không trùng khớp </p>
                </div>
                <div class="form-group mt-4">
                    <button type="submit" class="btn btn-primary btn-block">
                        Cập nhật mật khẩu
                    </button>
                </div>
            </form>
        </div>
    </div>
    <p class="text-center mt-4">
        Don'\'t have account? <a href="register.jsp">Sign up</a>
    </p>
    <br/><br/>
</section>
<script>
    function validateCheckPassword() {
        const password = document.getElementById("password").value;
        const checkPassword = document.getElementById("Checkpassword").value;
        const checkPasswordError = document.getElementById("Checkpassword-error");

        // Kiểm tra xem mật khẩu có khớp không
        if (password === checkPassword) {
            checkPasswordError.style.display = "none"; // Ẩn thông báo lỗi nếu mật khẩu khớp
        } else {
            checkPasswordError.style.display = "block"; // Hiện thông báo lỗi nếu mật khẩu không khớp
        }
    }

</script>
</body>
</html>
