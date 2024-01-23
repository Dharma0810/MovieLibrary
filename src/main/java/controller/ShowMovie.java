package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

@WebServlet("/showmovie")
public class ShowMovie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieDao dao = new MovieDao();
		
		req.setAttribute("movielist", dao.getAllMovie());
		
		RequestDispatcher rd = req.getRequestDispatcher("showmovie.jsp");
		rd.include(req, resp);
	}
}
