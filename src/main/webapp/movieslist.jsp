<%@page import="dao.MovieDao"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	
body{
    min-height: 99vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 50px;
    background-color: bisque;
}
table,th,td{
    border: 1px solid black;
    border-collapse: collapse;
}
img{
    height: 80px;
    width: 100px;
}
table{
    width: 800px;
    text-align: center;
}
	
</style>
</head>
<body>

	<% List<Movie> movies = (List) request.getAttribute("movielist"); %>

	<table>
		<thead>
			<tr>
				<th>Movie</th>
				<th>Actor</th>
				<th>Genre</th>
				<th>Price</th>
				<th>Rating</th>
				<th>Release Date</th>
				<th>Image</th>
			</tr>
		</thead>
		<tbody>
		<% for(Movie m : movies){ %>
			<tr>
				<td><%= m.getMovie() %></td>
				<td><%= m.getActor() %></td>
				<td><%= m.getGenre() %></td>
				<td><%= m.getPrice() %></td>
				<td><%= m.getRating() %></td>
				<td><%= m.getReleaseDate() %></td>
				<% String image = new String(Base64.getEncoder().encode(m.getImage()));%>
				<td><img src="data:image/jpeg;base64, <%= image%>"></td>
			</tr>
		<% } %>	
		</tbody>
	</table>
	
</body>
</html>