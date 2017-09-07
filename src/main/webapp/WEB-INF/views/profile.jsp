<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ include file="jspf/header.jspf" %>
<div class="row" id="profile">
<div class="col-sm-10 col-sm-offset-1" >

	<table class="table is-bordered is-striped is-narrow is-fullwidth">
		<thead class="thead-inverse">
    		<h2> Commitments: </h2>
    		<tr>
     			<th>ID</th>
      			<th>Title</th>
      			<th>City</th>
      			<th>Category</th>
				<th>Description</th>																																																
      			<th>Added by</th>
      		</tr>
  		</thead>
  		<tbody> 
  				<c:forEach items="${userResponses}" var="response" >
  				<tr> 
  					<td> ${response.id}</td>
  					<td> ${response.request.title}</td>
  					<td> ${response.request.city}</td>
  					<td> ${response.request.category}</td>
  					<td> ${response.request.description}</td>
  					<td> ${response.request.user}</td>
  				</tr>
  				</c:forEach>
  		</tbody>
  	</table>
</div>

<div class="col-sm-10 col-sm-offset-1" >

	<table class="table is-bordered is-striped is-narrow is-fullwidth">
		<thead class="thead-inverse">
    		<h2> Your requests: </h2>
    		<tr>
     			<th>ID</th>
      			<th>Title</th>
      			<th>City</th>
      			<th>Category</th>
				<th>Description</th>																																																
      			<th>Added by</th>
      		</tr>
  		</thead>
  		<tbody> 
  				<c:forEach items="${yourRequests}" var="request" >
  				<tr> 
  					<td> ${request.id}</td>
  					<td> ${request.title}</td>
  					<td> ${request.city}</td>
  					<td> ${request.category}</td>
  					<td> ${request.description}</td>
  					<td> ${request.user}</td>
  				</tr>
  				</c:forEach>
  		</tbody>
  	</table>
</div>




<div class="col-sm-offset-1 col-sm-10">
<p/>
<p/>

	<h2> Edit profile</h2>
	<table>
	<tr>
	<td> Login: </td> 
	<td> ${user.login} </td>
	</tr>
	<tr> 
	<td> Email: </td> 
	<td> ${user.email} </td>
	</tr>
	<tr>
	<td> FirstName: </td> 
	<td> ${userDet.firstName} </td>
	</tr>
	<tr>
	<td> LastName: </td> 
	<td> ${userDet.lastName} </td>
	</tr>
	<tr>
	<td>City:</td> 
	<td> ${userDet.city} </td>
	</tr>
	</table>

</div>	
	
	
</div>
<%@ include file="jspf/footer.jspf" %>