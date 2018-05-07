<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Update Account" />
<html>
<c:import url="../template/head.jsp" />
<body>
  <c:import url="../template/header.jsp" />

  <h2>Update User</h2>

  <form method="POST" action="updateUser">
    <label for="email">Email</label>
    <input type="text" name="email" id="email" value="${user.email}" />
    <label for="firstName">First Name</label>
    <input type="text" name="firstName" id="firstName" value="${user.firstName}" />
    <label for="account">Last Name</label>
    <select id="account" name="account">
      <c:forEach var="account" items="${accounts}">
        <option value="${account.id}"><c:if test="${account.id == user.account.id}">selected</c:if>${account.lastName}</option>
      </c:forEach>
    </select>
    <label for="dateOfBirth">Date of Birth</label>
    <input type="date" value="${user.dateOfBirth}" name="dateOfBirth" id="dateOfBirth" />
    <label for="password">Password</label>
    <input type="password" name="password" id="password" value="${user.password}" />
    <label for="role">Role</label>
    <select id="role" name="role">
      <option value="parent">Parent</option>
      <option value="child">Child</option>
    </select>
    <input type="hidden" name="id" value="${user.id}" />
    <button type="submit">Update User</button>
  </form>

  <c:import url="../template/footer.jsp" />
</body>
</html>
