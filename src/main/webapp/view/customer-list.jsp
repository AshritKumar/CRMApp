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
  <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/resources/css/crmStyl.css"/>
<title>CRM - Customers</title>
</head>
<body>
<div id="wrapper">
	<div id= "header">
		<h2>Customer Relationship Manager</h2>
	</div>
	<button type="button" class="btn btn-primary" onclick="window.location.href='addCustForm'; return false">Add Customer</button>
</div>
<div id="container">
	<table class="table table-hover" style="width: 1350px;">
		<tr>
  		<th> Id </th>
  		<th> First Name </th>
  		<th> Last Name </th>
  		<th> Email </th>
  		<th>Action</th>
  		</tr>
  		<c:url var="custUrl" value="/customer/custUpdtaeForm">
  			<c:param name="custId" value=""></c:param>
  		</c:url>
  		<c:forEach var="cust" items="${customerList }">
  		<tr>
  			<td>${cust.id }</td>
  			<td>${cust.firstName }</td>
  			<td>${cust.lastName }</td>
  			<td>${cust.email }</td>
  			<c:url var="custUrl" value="/customer/custUpdtaeForm">
  				<c:param name="custId" value="${cust.id}"></c:param> <!-- This will creat id a http://localhost:8080/CRMApp/customer/custUpdateForm?custId = 2 -->
  			</c:url>
  			
  			<c:url var="custDelUrl" value="/customer/delete">
  				<c:param name="custId" value="${cust.id}"></c:param> <!-- This will creat id a http://localhost:8080/CRMApp/customer/custUpdateForm?custId = 2 -->
  			</c:url>
  			<td><a href="${custUrl}">update</a> | <a href="#" onclick="confirmDelete('${custDelUrl}')" >delete</a> <a href="${custDelUrl}" hidden="true" id="deleteCust">delete</a> </td> 
  		</tr>
  		</c:forEach>
	</table>
	
	 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Delete Customer</h4>
        </div>
        <div class="modal-body">
          <p>Are You Sure You want to delete this customer</p>
           <center>
          <button type="button" class="btn btn-danger" id="delYes">Yes</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
          </center>
        </div>
        <!-- div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div-->
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	function confirmDelete(url){
		
		$('#myModal').modal('show'); 
		$('#delYes').click(function(){
			window.location.href=url;
		});
	}
</script>

</body>

</html>