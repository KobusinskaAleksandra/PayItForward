<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
 
 <%@ include file="jspf/header.jspf" %>
	<div class="row" id="get">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<h2> Add request:</h2>
		<form:form method="post" modelAttribute="request">
			<div>
		<c:if test="${not empty error}">
                <div class="alert alert-danger"><c:out value="${error}"/></div>
 	   	</c:if>
			</div>
			
			<div class="form-group">
			<label for="title"> Enter title:</label>
			<form:input path="title" class="form-control" /> 
			</div>
			 <div class="form-group">
			 	<label for="city">Choose a city:</label>
			  	<form:select path="city" class="form-control" >
			  	 <form:options items="${cities}" itemValue="id"/>
			  	 </form:select>
			</div>
			 <div class="form-group">
				<label for="category">Choose a category:</label>
			  		<form:select path="category" class="form-control" >
			 		 <form:options items="${categories}" itemValue="id" />
			    	</form:select>
				</div>
			<div class="form-group">
				<label for="description">Description:</label>
  				<form:textarea path="description" class="form-control" rows="5" />	
			</div> 
			<div class="form-group"> 
				 <input type="submit" value="Submit">
			</div>
			</form:form>	 
		</div>	
	</div>	
<%@ include file="jspf/footer.jspf" %>