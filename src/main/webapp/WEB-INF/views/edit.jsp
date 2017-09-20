<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@include file="jspf/header.jspf" %>
<div class="row" id="profile">
<div class="col-sm-10 col-sm-offset-1" >



<div class="col-sm-offset-1 col-sm-10">
	<div class="row">
		<div class="col-sm-12">
			<h2> Your profile </h2>
  	</div>
	
	<table class="table is-bordered is-striped is-narrow is-fullwidth">
	<tr>
	<td> Login: </td> 
	<td> ${user.login} </td>
	<td> 
	</tr>
	<tr> 
	<td> Email: </td> 
	<td> ${user.email} </td>
	<td> edit </td>
	</tr>
	<tr>
	<td> FirstName: </td> 
	<td> ${userDet.firstName} </td>
	<td><form:form method="post" modelAttribute="userDet">
	<form:input path="firstName"/>
	<form:button type="submit" value="send"/> 
	</form:form>
	</td>
	</tr>
	<tr>
	<td> LastName: </td> 
	<td> ${userDet.lastName} </td>
	<td> edit </td>
	</tr>
	<tr>
	<td>City:</td> 
	<td> ${userDet.city} </td>
	<td> edit </td>
	</tr>
	</table>

</div>	
	</div>
	</div>
</div>
<%@ include file="jspf/footer.jspf" %>