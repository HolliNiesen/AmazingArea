<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<html>
<body>

<h2>Add User</h2>

<form method="POST" action="addUser">
  <label for="firstName">First Name</label>
  <input type="text" name="firstName" id="firstName" />
  <label for="account">Last Name</label>
  <select id="account" name="account">
    <c:forEach var="account" items="${accounts}">
      <option value="${account.id}">${account.familyName}</option>
    </c:forEach>
  </select>
  <label for="dateOfBirth">Date of Birth</label>
  <input type="date" id="dateOfBirth" name="dateOfBirth" />
  <label for="role">Role</label>
  <select id="role" name="role">
    <c:forEach var="role" items="${roles}">
      <option value="${role.id}">${role.name}</option>
    </c:forEach>
  </select>
  <button type="submit">Add User</button>
</form>

</body>
</html>