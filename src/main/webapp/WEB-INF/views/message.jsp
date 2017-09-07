<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ include file="jspf/header.jspf" %>
<div class="row" id="message">

<div class="row">
        <div class="modal-content col-sm-8 col-sm-offset-2">
          <div class="modal-header">
            <h4 class="modal-title">Compose Message</h4>
          </div>
          <div class="modal-body">
			<form:form method="post" class="form-horizontal" modelAttribute="sent" commandName="sent"> 
			<div class="form-group">
                  <label class="col-sm-1" for="title">Subject</label>
                  <div class="col-sm-11">
           	       <form:input path="title" class="form-control" type="text" /> 
                 	<form:errors path="title" cssClass="error" />
                 </div>
           </div>
                <label for="recipient"> Select recipient:</label>
				<form:select path="recipient" class="form-control">
					 <form:options items="${users}" itemLabel="login" itemValue="id"/>
				</form:select>
				
                <div class="form-group">
                <p />
                  <label class="col-sm-12" for="body">Message</label>
                  <div class="col-sm-12">
                  	<form:textarea path="body" class="form-control" rows="6" /></div>
               	 </div>
            	 <c:if test="${not empty errors}">
                <div class="alert alert-warning"><c:out value="${errors}"/></div>
 	              </c:if>
            	<input type="submit" value="Click">
			</form:form>
          </div>
		 </div>
</div> 
<p />
<p />
<div class="row">
<div class="col-sm-offset-1 col-sm-10">
        <div class="modal-content ">
          <div class="modal-header">
            <h4 class="modal-title">Inbox</h4>
          </div>
          <div class="modal-body">
			<div class="form-horizontal"> 
			
		<c:forEach items="${inbox}" var="message" >	
			
			<div class="form-group table-bordered">
               <h4> <label class="col-sm-offset-4 col-sm-1" for="title">Subject</label>
                  <div class="col-sm-5">
           	     ${message.title}
                 </div>
                </h2>
           </div>
           <div class="form-group">
                <label class="col-sm-9" for="sender"> Sender:
				 ${message.sender.login} </label>
				<label class="col-sm-3" for="send"> Send:
				${message.send} </label>
				</div>
			   <div class="form-group">
                <p />
                  <label class="col-sm-12 " for="messageBody">Message</label>
                  <div class="col-sm-12"> ${message.body} </div>
                </div>
               </c:forEach>
			</div>
          </div>
		 </div>
</div>
</div> 
</div>
<%@ include file="jspf/footer.jspf" %>