package controller.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/uploadAI")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 50   // 50 MB
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/images/uploads");
        File uploadDir = new File(uploadPath);

        // Ensure the upload directory exists
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String humanFile = "human.jpg";
        String clothFile = "cloth.jpg";

        boolean humanUploaded = false;
        boolean clothUploaded = false;

        // Process uploaded parts
        for (Part part : request.getParts()) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString().toLowerCase(); // Get file name
            if (fileName.contains("human")) {
                part.write(uploadPath + File.separator + humanFile);
                humanUploaded = true;
            } else if (fileName.contains("cloth")) {
                part.write(uploadPath + File.separator + clothFile);
                clothUploaded = true;
            }
        }

        // Ensure both files are uploaded
        if (!humanUploaded || !clothUploaded) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Both human and cloth images must be uploaded.");
            return;
        }

        // Forward files to AI processing
        request.setAttribute("human", humanFile);
        request.setAttribute("cloth", clothFile);
        request.getRequestDispatcher("aiprocess").forward(request, response);
    }
}