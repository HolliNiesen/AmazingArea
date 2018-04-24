<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/head.jsp"%>

<html><body>

<div class="container-fluid">
  <h2>Search Results: </h2>
  <table class="table">
    <thead>
    <tr>
      <th>User Id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
      <th>Role</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.account.lastName}</td>
        <td>${user.age}</td>
        <td><c:forEach var="role" items="${user.roles}">${role.roleName} </c:forEach></td>
        <td>
          <form method="GET" action="updateUserForm">
            <button type="submit" name="update" value="${user.id}">Fix me</button>
          </form>
        </td>
        <td>
          <form method="POST" action="deleteUser">
            <button type="submit" name="delete" value="${user.id}">X</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
