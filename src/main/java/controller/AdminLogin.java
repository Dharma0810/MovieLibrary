package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dto.Admin;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		AdminDao dao = new AdminDao();
		
		Admin a = dao.findByEmail(email);
		
		if(a != null) {
			if(password.equals(a.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("adminname", a.getName());
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("message", "Wrong Password...!");
				RequestDispatcher rd = req.getRequestDispatcher("admin_login.jsp");
				rd.include(req, resp);
			}
		}
		else {
			req.setAttribute("message", "Wrong Email...!");
			RequestDispatcher rd = req.getRequestDispatcher("admin_login.jsp");
			rd.include(req, resp);
		}
	}
}
