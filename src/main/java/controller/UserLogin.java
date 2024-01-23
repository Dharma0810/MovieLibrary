package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import dao.UserDao;
import dto.User;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao();
		
		User a = dao.findByEmail(email);
		
		if(a != null) {
			if(password.equals(a.getPassword())) {
				req.setAttribute("movielist", (new MovieDao()).getAllMovie());
				RequestDispatcher rd = req.getRequestDispatcher("movieslist.jsp");
				rd.include(req, resp);
			}
			else {
				req.setAttribute("message", "Wrong Password...!");
				RequestDispatcher rd = req.getRequestDispatcher("user_login.jsp");
				rd.include(req, resp);
			}
		}
		else {
			req.setAttribute("message", "Wrong Email...!");
			RequestDispatcher rd = req.getRequestDispatcher("user_login.jsp");
			rd.include(req, resp);
		}
	}
}
