<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Update Account" />
<html>
<c:import url="../template/head.jsp" />
<body>
  <c:import url="../template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <h3 class="header blue-text">Update ${user.firstName}</h3>
      <br />
      <div class="row center">
        <form method="POST" action="updateUser">
          <div class="input-field col s12">
            <label for="firstName" class="col offset-s3">First Name</label>
            <input type="text" name="firstName" id="firstName" value="${user.firstName}" class="col s6 offset-s3" />
          </div>
          <div class="input-field col s12">
            <label for="email" class="col offset-s3">Email</label>
            <input name="email" id="email" type="text" class="col s6 offset-s3" value="${user.email}" required />
          </div>
          <div class="input-field col s12">
            <label for="dateOfBirth" class="col offset-s3">Date of Birth</label>
            <input type="date" value="${user.dateOfBirth}" name="dateOfBirth" id="dateOfBirth" class="col s6 offset-s3" />
          </div>
          <div class="input-field col s12">
            <label for="password" class="col offset-s3">Password</label>
            <input type="password" name="password" id="password" value="${user.password}" class="col s6 offset-s3" />
          </div>
          <input type="hidden" name="id" value="${user.id}" />
          <button type="submit" class="btn waves-effect waves-light blue center-align">Update</button>
        </form>
      </div>
      <br /><br />
    </div>
  </div>

  <c:import url="../template/footer.jsp" />
</body>
</html>
