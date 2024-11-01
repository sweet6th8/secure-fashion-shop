// create handle in4

function validateInput() {
       const input = document.getElementById("email").value;
       const errorMessage = document.getElementById("error-message");
       const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
       // Kiểm tra xem đầu vào có hợp lệ không
       if (regex.test(input)) {
           errorMessage.style.display = "none"; // Ẩn thông báo lỗi nếu hợp lệ
           alert("Thông tin hợp lệ!");
       } else {
           errorMessage.style.display = "block"; // Hiện thông báo lỗi nếu không hợp lệ
       }
   }