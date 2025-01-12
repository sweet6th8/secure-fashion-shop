<%--
  Created by IntelliJ IDEA.
  User: NGUYEN THI LANG
  Date: 1/12/2025
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <title>AI Upload</title>
</head>
<body>
<h1>Upload Images for AI Processing</h1>
<form action="${pageContext.request.contextPath}/uploadAI" method="post" enctype="multipart/form-data">
    <!-- Field for Human Image -->
    <label for="humanFile">Upload Human Image:</label>
    <input type="file" name="humanFile" id="humanFile" required><br><br>

    <!-- Field for Cloth Image -->
    <label for="clothFile">Upload Cloth Image:</label>
    <input type="file" name="clothFile" id="clothFile" required><br><br>

    <!-- Submit Button -->
    <input type="submit" value="Upload">
</form>
</body>
</html>

