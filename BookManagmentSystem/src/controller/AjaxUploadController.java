package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ajax/upload")
public class AjaxUploadController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String location = "/resources/image/";
		
		// get server path
		String UPLOAD_DIRECTORY = req.getServletContext().getRealPath(location);
		System.out.println(UPLOAD_DIRECTORY);
		// check if folder exist or not
		File file = new File(UPLOAD_DIRECTORY);
		if (!file.exists()) {
			file.mkdirs();
			System.out.println("make directory");
		}

		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						// get original file name
						String originalName = new File(item.getName()).getName();

						// get file extension
						String extension = originalName.substring(originalName.lastIndexOf("."));

						// random file name using UUID
						String fileName = UUID.randomUUID().toString() + extension;
						location += fileName;
						System.out.println("filename: " + location);
						
						item.write(new File(UPLOAD_DIRECTORY + File.separator + fileName));
					}
				}

				// File uploaded successfully
				req.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				req.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			req.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		
		resp.getWriter().write(location);

	}

}
