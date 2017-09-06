<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   

 <%@include file="jspf/header.jspf" %>
 	<div class="row" id="register">
 	<div class="col-sm-6">
	
	<h2> Login </h2>
		<form:form method="post" modelAttribute="loged">
	<div class="row form-group">
	<div class="col-sm-offset-4 col-sm-4">
	<p><form:checkbox path="checked" value="true" /> Mam już konto </p>
	</div>
	</div>
	<div class="row form-group">
	<div class="col-sm-offset-2 col-sm-4">
		<label for="login"> Enter login:</label>
	</div>
	<div class="col-sm-4">
		<form:input path="login" />
	</div>
	</div>
	<p />
	<p />
	<div class="row form-group">
	<div class="col-sm-offset-2 col-sm-4">
		<label for="password"> Password:</label>
	</div>
	<div class="col-sm-4">
		<form:input path="password" /> <p />
	</div>
	</div>
	<div class="col-sm-offset-5 col-sm-4">
		<input type="submit" value="Save">
	</div>
	</form:form>
	
	</div> 	
<div class="col-sm-6">
<h2> Register </h2>
<form:form method="post" modelAttribute="user">
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="login"> Enter login:</label>
	</div>
	<div class="col-sm-4">
		<form:input path="login" />
	</div>
</div>
<p />
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="password"> Password:</label>
	</div>
	<div class=" col-sm-4">
		<form:input path="password" /> <p />
	</div>
</div>
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="email"> Email:</label>
	</div>
	<div class="col-sm-4">
		<form:input path="email" /> <p />
	</div>
</div>
<form:form method="post" modelAttribute="userDetails">
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="fistName"> First Name: </label>
	</div>
	<div class="col-sm-4">
		<form:input path="firstName" />
	</div>
</div>
<p />
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="lastName"> Last Name: </label>
	</div>
	<div class=" col-sm-4">
		<form:input path="lastName" />
	</div>
</div>
<p />
<div class="row form-group">
	<div class="col-sm-offset-1 col-sm-4">
		<label for="city"> Choose a city: </label>
	</div>
	<div class=" col-sm-4">
		<form:select path="city" > 
  			<form:option value="NONE"> --SELECT--</form:option>
  			 <form:options items="${cities}" itemValue="id"/>
		</form:select>
	</div>
</div>
<div class="row form-group">
<p />
	<div class="col-sm-offset-5 col-sm-4">
		<input type="submit" value="Save">
	</div>
</div>
</form:form>
</form:form>
</div>
</div>
<%@ include file="jspf/footer.jspf" %>