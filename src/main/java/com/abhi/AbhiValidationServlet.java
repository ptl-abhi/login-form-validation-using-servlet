package com.abhi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/authentication")
public class AbhiValidationServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		String uid = request.getParameter("userid");
		String pass = request.getParameter("password");
		if (uid.equals("admin") && pass.equals("cetpa")) {
			response.sendRedirect("home.html");
		} else {
			// response.sendRedirect("login-form.html");
			PrintWriter pw=response.getWriter();
			RequestDispatcher dp=request.getRequestDispatcher("login-form.html");
			dp.include(request,response);
			pw.println("<div style='margin-top:30px;'>");
			pw.println("<h1 style='color:red; text-align:center;'>Authentication failed</h1>");
			pw.println("</div>");
		}
	}
}
