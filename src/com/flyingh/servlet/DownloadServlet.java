package com.flyingh.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String realPath = getServletContext().getRealPath("/美女.jpg");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ getFileName(realPath));
		FileInputStream fileInputStream = new FileInputStream(realPath);
		int len = 0;
		byte[] buf = new byte[1024];
		ServletOutputStream os = response.getOutputStream();
		while ((len = fileInputStream.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		fileInputStream.close();
	}

	private String getFileName(String path) throws UnsupportedEncodingException {
		return URLEncoder.encode(
				path.substring(path.lastIndexOf(File.separator) + 1), "utf-8");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
