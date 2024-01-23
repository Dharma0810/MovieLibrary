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

@WebServlet("/adminsignup")
public class AdminSignup extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Admin admin = new Admin();
		admin.setName(req.getParameter("name"));
		admin.setEmail(req.getParameter("email"));
		admin.setPassword(req.getParameter("password"));
		
		AdminDao dao = new AdminDao();
		
		Admin saved = dao.saveAdmin(admin);
		
		if(saved != null) {
			HttpSession session = req.getSession();
			session.setAttribute("adminname", admin.getName());
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("message", "Email Already Exist...!");
			RequestDispatcher rd = req.getRequestDispatcher("admin_login.jsp");
			rd.include(req, resp);
		}
	}
}
