<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/update.css">
</head>
<body>
	
	<% Movie m = (Movie) request.getAttribute("movie"); %>
	
	<div id="container">

		<form action="updatemovie" enctype="multipart/form-data" method="post">

			<table>
				<tbody>
					<tr>
						<td><label>Movie ID </label></td>
						<td><input type="number" name="id" value="<%= m.getId() %>" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label>Movie Name </label></td>
						<td><input type="text" name="movie" value="<%= m.getMovie() %>"></td>
					</tr>
					<tr>
						<td><label>Actor Name </label></td>
						<td><input type="text" name="actor" value="<%= m.getActor() %>"></td>
					</tr>
					<tr>
						<td><label>Movie Genre </label></td>
						<td><input type="text" name="genre" value="<%= m.getGenre() %>"></td>
					</tr>
					<tr>
						<td><label>Movie Price </label></td>
						<td><input type="number" name="price" value="<%= m.getPrice() %>"></td>
					</tr>
					<tr>
						<td><label>Movie Rating </label></td>
						<td><input type="number" name="rating" value="<%= m.getRating() %>"></td>
					</tr>
					<tr>
						<td><label>Release Date </label></td>
						<td><input type="date" name="releasedate" value="<%= m.getReleaseDate() %>"></td>
					</tr>
					<tr>
						<td><label>New Image </label></td>
						<td><input type="file" name="image"></td>
					</tr>
				</tbody>
			</table>

			<button>submit</button>
		</form>
	</div>
	
</body>
</html>