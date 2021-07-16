<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Customer List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Email</th><th>Address</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="customer" items="${list}">
   <tr>
   <td>${customer.id}</td>
   <td>${customer.name}</td>
   <td>${customer.email}</td>
   <td>${customer.address}</td>
   <td><a href="editcustomer/${customer.id}">Edit</a></td>
   <td><a href="deletecustomer/${customer.id}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="customerform">Add New Employee</a>