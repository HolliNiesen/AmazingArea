<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Users" />
<html>
<c:import url="../template/head.jsp" />
<body>
  <c:import url="../template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <div class="row">
        <div class="col s8 offset-s2">
          <table class="table">
            <thead>
            <tr>
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
                <td>${user.firstName}</td>
                <td>${user.account.lastName}</td>
                <td>${user.age}</td>
                <td>
                  <c:forEach var="role" items="${user.roles}">${role.roleName}</c:forEach>
                </td>
                <td>
                  <form method="GET" action="updateUserForm">
                    <button type="submit" name="update" value="${user.id}" class="btn waves-effect waves-light blue">Update</button>
                  </form>
                </td>
                <td>
                  <form method="POST" action="deleteUser">
                    <button type="submit" name="delete" value="${user.id}" class="btn waves-effect waves-light blue">X</button>
                  </form>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <br /><br />
    </div>
  </div>

  <c:import url="../template/footer.jsp" />
</body>
</html>
