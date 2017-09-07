<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ include file="jspf/header.jspf" %>
<div class="row" id="give">
<div class="col-sm-10 col-sm-offset-1" >
<c:if test="${not empty error}">
        <div class="alert alert-warning"><c:out value="${error}"/></div>
</c:if>

	<table class="table is-bordered is-striped is-narrow is-fullwidth">
		<thead class="thead-inverse">
    		<tr>
     			<th>ID</th>
      			<th>Title</th>
      			<th>City</th>
      			<th>Category</th>
				<th>Description</th>																																																
      			<th>Added by</th>
      			<th>Do this! </th> 
      		</tr>
  		</thead>
  		<tbody>
  		<form method="post"> 
  				<c:forEach items="${requests}" var="request" >
  				<tr> 
  					<td> ${request.id}</td>
  					<td> ${request.title}</td>
  					<td> ${request.city}</td>
  					<td> ${request.category}</td>
  					<td> ${request.description}</td>
  					<td> ${request.user}</td>
  					<td><button  value="${request.id}" name="requestId"> CLICK </button> </td> 					
  				</tr>
  				</c:forEach>
  		</form>
  		</tbody>
  	</table>
	</div>	
</div>
<%@ include file="jspf/footer.jspf" %>