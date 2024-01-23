<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
</head>
<body>
	<div id="container">

		<form action="addmovie" enctype="multipart/form-data" method="post">

			<table>
				<tbody>
					<tr>
						<td><label>Movie Name </label></td>
						<td><input type="text" name="movie"></td>
					</tr>
					<tr>
						<td><label>Actor Name </label></td>
						<td><input type="text" name="actor"></td>
					</tr>
					<tr>
						<td><label>Movie Genre </label></td>
						<td><input type="text" name="genre"></td>
					</tr>
					<tr>
						<td><label>Movie Price </label></td>
						<td><input type="number" name="price"></td>
					</tr>
					<tr>
						<td><label>Movie Rating </label></td>
						<td><input type="number" name="rating"></td>
					</tr>
					<tr>
						<td><label>Release Date </label></td>
						<td><input type="date" name="releasedate"></td>
					</tr>
					<tr>
						<td><label>Image </label></td>
						<td><input type="file" name="image"></td>
					</tr>
				</tbody>
			</table>
			
			<button>submit</button>
		</form>
	<h2><a href="showmovie">View List</a></h2>
	</div>
</body>
</html>