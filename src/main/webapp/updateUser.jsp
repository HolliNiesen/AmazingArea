<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<html>
<body>

<h2>Update User</h2>

<form method="POST" action="updateUser">
  <label for="firstName">First Name</label>
  <input type="text" name="firstName" id="firstName" value="${user.firstName}" />
  <label for="account">Last Name</label>
  <select id="account" name="account">
    <c:forEach var="account" items="${accounts}">
      <option value="${account.id}"<c:if test="${account.id == user.account.id}">selected</c:if>>${account.familyName}</option>
    </c:forEach>
  </select>
  <label for="dateOfBirth" value="${user.dateOfBirth}">Date of Birth</label>
  <input type="date" name="dateOfBirth" id="dateOfBirth" />
  <label for="role">Role</label>
  <select id="role" name="role">
    <c:forEach var="role" items="${roles}">
      <option value="${role.id}"<c:if test="${role.id == user.role.id}">selected</c:if>>${role.name}</option>
    </c:forEach>
  </select>
  <input type="hidden" name="id" value="${user.id}" />
  <button type="submit">Update User</button>
</form>

</body>
</html>