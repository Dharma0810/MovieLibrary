package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MovieDao;

@WebServlet("/deletemovie")
public class DeleteMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		if (((String) session.getAttribute("adminname")) != null) {
			
			MovieDao dao = new MovieDao();

			dao.removeMovie(Integer.parseInt(req.getParameter("id")));

			req.setAttribute("movielist", dao.getAllMovie());

			RequestDispatcher rd = req.getRequestDispatcher("showmovie.jsp");
			rd.include(req, resp);
		}
		else {
			req.setAttribute("message", "Access Denied, Login Requiered..!");
			RequestDispatcher rd = req.getRequestDispatcher("admin_login.jsp");
			rd.include(req, resp);
		}
	}
}
