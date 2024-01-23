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
import dto.Movie;
import dto.User;

@WebServlet("/usersignup")
public class UserSignup extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		UserDao dao = new UserDao();
		
		User saved = dao.saveUser(user);
		
		if(saved != null) {
			req.setAttribute("movielist", (new MovieDao()).getAllMovie());
			RequestDispatcher rd = req.getRequestDispatcher("movieslist.jsp");
			rd.include(req, resp);
		}
		else {
			req.setAttribute("message", "Email Already Exist...!");
			RequestDispatcher rd = req.getRequestDispatcher("user_login");
			rd.include(req, resp);
		}
	}
}
