<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.w3-btn {margin-bottom:10px;}
</style>
</head>
<body>
<form action="searchBooks.htm" method="POST">
BookId <input type="text" name="bookId">
<input type="submit" value="search">
<br><br>
<table class="table table-bordered"border="1px" cellpadding="8px" >
<thead>
<tr>
<th>BookId</th>
<th>BookName</th>
<th>AuthorName</th>
<th>pirce</th>
</tr>
</thead>
<tbody> 
<tr>
<%-- <c:if test="${books.size()<=0}">
<tr>
<td>NoRecords Found</td>
</tr>
</c:if> --%>

<c:forEach items="${books}" var="b">

<tr>
<td>${b.bookId}</td>
<td>${b.bookName}</td>
<td>${b.authorName}</td>
<td>${b.bookPrice}</td>
</tr>

</c:forEach>



</tbody>


</table>

</form>

<spring:url value="/report/?type=xls" var="xlsURL" />
 <spring:url value="/report/?type=pdf" var="pdfURL" />
 <button type="button" class="btn btn-outline-primary"><a href="${xlsURL }">Download Excel</a></button>
 <button class="w3-btn w3-white w3-border"><a href="${pdfURL }">Download PDF</a></button>
 
 
</body>
</html>