package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/addmovie")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class AddMovie extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		if (((String) session.getAttribute("adminname")) != null) {
			
			Movie m = new Movie();
			
			m.setMovie(req.getParameter("movie"));
			m.setActor(req.getParameter("actor"));
			m.setGenre(req.getParameter("genre"));
			m.setPrice(Double.parseDouble(req.getParameter("price")));
			m.setRating(Double.parseDouble(req.getParameter("rating")));
			m.setReleaseDate(req.getParameter("releasedate"));
			Part imgpart = req.getPart("image");
			m.setImage(imgpart.getInputStream().readAllBytes());
			
			MovieDao dao = new MovieDao();
			dao.saveMovie(m);
			
			RequestDispatcher rd = req.getRequestDispatcher("addmovie.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("message", "Access Denied, Login Requiered..!");
			RequestDispatcher rd = req.getRequestDispatcher("admin_login.jsp");
			rd.include(req, resp);
		}
	}
}