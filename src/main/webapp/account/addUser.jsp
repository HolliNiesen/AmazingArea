<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../template/head.jsp" />
<body>
  <c:import url="../template/header.jsp" />

  <h2>Add User</h2>

  <form method="POST" action="addUser">
    <label for="email">Email</label>
    <input type="text" name="email" id="email" />
    <label for="firstName">First Name</label>
    <input type="text" name="firstName" id="firstName" />
    <label for="account">Last Name</label>
    <select id="account" name="account">
      <c:forEach var="account" items="${accounts}">
        <option value="${account.id}">${account.lastName}</option>
      </c:forEach>
    </select>
    <label for="dateOfBirth">Date of Birth</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" />
    <label for="role">Role</label>
    <select id="role" name="role">
      <option value="parent">Parent</option>
      <option value="child">Child</option>
    </select>
    <label for="password">Password</label>
    <input type="password" name="password" id="password" />
    <button type="submit">Add User</button>
  </form>

  <c:import url="../template/footer.jsp" />
</body>
</html>
