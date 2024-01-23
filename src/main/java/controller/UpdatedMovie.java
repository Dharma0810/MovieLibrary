package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class UpdatedMovie extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Movie m = new Movie();
		MovieDao dao = new MovieDao();

		m.setId(Integer.parseInt(req.getParameter("id")));
		m.setMovie(req.getParameter("movie"));
		m.setActor(req.getParameter("actor"));
		m.setGenre(req.getParameter("genre"));
		m.setPrice(Double.parseDouble(req.getParameter("price")));
		m.setRating(Double.parseDouble(req.getParameter("rating")));
		m.setReleaseDate(req.getParameter("releasedate"));
		Part imgpart = req.getPart("image");

		if (imgpart.getSize() > 0) {

			m.setImage(imgpart.getInputStream().readAllBytes());
			dao.updateMovie(m);

			req.setAttribute("movielist", dao.getAllMovie());

			RequestDispatcher rd = req.getRequestDispatcher("showmovie.jsp");
			rd.forward(req, resp);
		} else {

			Movie exMovie = dao.findByMovieId(Integer.parseInt(req.getParameter("id")));

			m.setImage(exMovie.getImage());
			dao.updateMovie(m);

			req.setAttribute("movielist", dao.getAllMovie());

			RequestDispatcher rd = req.getRequestDispatcher("showmovie.jsp");
			rd.forward(req, resp);
		}
	}
}
