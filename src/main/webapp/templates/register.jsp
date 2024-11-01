<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="max-age=604800" />
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
    <link href="src/main/webapp/static/js/register.js" />
  </head>
  <body>
    <section class="section-content padding-y">
      <div class="card mx-auto" style="max-width: 520px; margin-top: 40px">
        <article class="card-body">
          <header class="mb-4"><h4 class="card-title">Sign up</h4></header>
          <form action="register" method="GET">
            <div class="form-row">
              <div class="col form-group">
                <label>Họ </label>
                <input
                  name="FirstName"
                  type="text"
                  class="form-control"
                  placeholder=""
                  maxlength="255"
                  autofocus
                />
              </div>
              <div class="col form-group">
                <label>Tên</label>
                <input
                  name="LastName"
                  type="text"
                  class="form-control"
                  placeholder=""
                  maxlength="255"
                />
              </div>
            </div>
            <div class="form-group">
              <label>Email</label>
              <input
                id="email"
                name="Email"
                type="email"
                class="form-control"
                placeholder=""
                onChange="validateEmail()"
              />
              <p id="error-email" style="color: red; display: none">
                Email không hợp lệ
              </p>
            </div>
            <div class="form-group">
              <label>phone</label>
             <input type="text" id="phone" placeholder="Nhập số điện thoại" oninput="validatePhone()"     class="form-control" />
             <span id="error-phone" style="color: red; display: none;">Số điện thoại không hợp lệ. Vui lòng nhập lại.</span>

            </div>
            <div class="form-group">
              <label class="custom-control custom-radio custom-control-inline">
                <input
                  name="gender"
                  class="custom-control-input"
                  checked=""
                  type="radio"
                  name="gender"
                  value="1"
                />
                <span class="custom-control-label"> Nam </span>
              </label>
              <label class="custom-control custom-radio custom-control-inline">
                <input
                  name="gender"
                  class="custom-control-input"
                  type="radio"
                  name="gender"
                  value="0"
                />
                <span class="custom-control-label"> Nữ </span>
              </label>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label>Quốc Gia</label>
                <input type="text" class="form-control" />
              </div>
              <div class="form-group col-md-6">
                <label>Thành phố / Tỉnh</label>
                <input list="inputState" class="form-control" />
                <datalist name="city" id="inputState">
                  <option name="city" value="Long An"></option>
                  <option name="city" value="Bình Định"></option>
                  <option name="city" value="Quy Nhơn"></option>
                  <option name="city" value="Quảng Ngãi"></option>
                  <option name="city" value="Hà Nội"></option>
                  <option name="city" value="Hồ Chí Minh"></option>
                </datalist>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="password">Mật khẩu:</label>
                <input
                  type="password"
                  name="password"
                  id="password"
                  class="form-control"
                  onchange="validatePassword()"
                />
                <p id="password-error" style="color: red; display: none">
                  Mật khẩu phải có từ 8 đến 20 ký tự, bao gồm chữ hoa, chữ
                  thường, số và ký tự đặc biệt.
                </p>
              </div>
              <div class="form-group col-md-6">
                <label>Nhập lại mật khẩu </label>
                <input
                  id="Checkpassword"
                  name="Checkpassword"
                  class="form-control"
                  type="password"
                  onChange="validateCheckPassword()"
                />
                <p id="Checkpassword-error" style="color: red; display: none">
                  Mật khẩu không trùng khớp !
                </p>
              </div>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-block">
                Register
              </button>
            </div>
          </form>
        </article>
        <!-- card-body.// -->
      </div>
      <!-- card .// -->
      <p class="text-center mt-4">
        Have an account? <a href="login.jsp">Log In</a>
      </p>
      <br /><br />
    </section>
    <footer class="section-footer border-top padding-y">
      <div class="container">
        <p class="float-md-right">&copy Copyright 2019 All rights reserved</p>
        <p>
          <a href="#">Terms and conditions</a>
        </p>
      </div>
    </footer>
    <script>
      function validateEmail() {
        const input = document.getElementById("email").value;
        const errorMessage = document.getElementById("error-email");
        const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        // Kiểm tra xem đầu vào có hợp lệ không
        if (regex.test(input)) {
          errorMessage.style.display = "none"; // Ẩn thông báo lỗi nếu hợp lệ
        } else {
          errorMessage.style.display = "block"; // Hiện thông báo lỗi nếu không hợp lệ
        }
      }
      function validatePassword() {
        const password = document.getElementById("password").value;
        const passwordError = document.getElementById("password-error");
        const regex =
          /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;

        // Kiểm tra xem mật khẩu có hợp lệ không
        if (regex.test(password)) {
          passwordError.style.display = "none"; // Ẩn thông báo lỗi nếu hợp lệ
        } else {
          passwordError.style.display = "block"; // Hiện thông báo lỗi nếu không hợp lệ
        }
      }
function validatePhone() {
  const phone = document.getElementById("phone").value;
  const phoneError = document.getElementById("error-phone");
  const regex = /^(0|\+84)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5]|9[0-9])\d{7}$/;

  // Kiểm tra xem số điện thoại có hợp lệ không
  if (regex.test(phone)) {
    phoneError.style.display = "none"; // Ẩn thông báo lỗi nếu hợp lệ
  } else {
    phoneError.style.display = "block"; // Hiện thông báo lỗi nếu không hợp lệ
    phoneError.textContent = "Số điện thoại không hợp lệ. Vui lòng nhập lại.";
  }
}

      function validateCheckPassword() {
        const password = document.getElementById("password").value;
        const checkPassword = document.getElementById("Checkpassword").value;
        const checkPasswordError = document.getElementById(
          "Checkpassword-error"
        );

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
