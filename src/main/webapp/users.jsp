<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
  <h2>Search Results: </h2>
  <table class="table">
    <thead>
    <tr>
      <th>User Id</th>
      <th>First Name</th>
      <th>Age</th>
      <th>Role Id</th>
      <th>Account Id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.age}</td>
        <td>${user.roleId}</td>
        <td>${user.accountId}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
