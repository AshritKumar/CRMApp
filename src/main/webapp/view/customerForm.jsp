<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet"  type="text/css" href="/CRMApp/resources/css/crmStyl.css"/>
<title>Add Customer</title>
</head>
<body>
<div id="wrapper">
	<div id= "header">
		<h2>Add Customer</h2>
	</div>
	<a class="btn" href="${pageContext.request.contextPath }/customer/list">Back</a>
</div>
<div class="container">
<form:form action="${action }" method="POST" cssClass="form-horizontal" modelAttribute="customer">
	<form:hidden path="id"/>
	<div class="form-group">
		<label class="control-label col-sm-2" for=firstName>First Name:</label>
		<div class="col-sm-7">
		<form:input path="firstName" class="form-control" id="firstName" required = "true"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for=lastName>Last Name:</label>
		<div class="col-sm-7">
		<form:input path="lastName" class="form-control" id="lstName" required = "true"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for=email>Email:</label>
		<div class="col-sm-7">
		<form:input path="email" class="form-control" id="email" required = "true"/>
		</div>
	</div>
	<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
			<input type="submit" value="Save" class="btn btn-default">
		</div>
	</div>
</form:form>
</div>

</body>
</html>