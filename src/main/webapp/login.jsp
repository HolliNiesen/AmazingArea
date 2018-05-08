<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Log In" />
<html>
<c:import url="template/head.jsp" />
<body>
  <c:import url="template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <h3 class="header blue-text">Log In</h3>
      <div class="row center">
        <form method="POST" action="j_security_check">
          <div class="input-field col s12">
            <label for="email" class="col offset-s3">Email</label>
            <input name="j_username" id="email" type="text" class="col s6 offset-s3" required />
          </div>
          <div class="input-field col s12">
            <label for="password" class="col offset-s3">Password</label>
            <input name="j_password" id="password" type="password" class="col s6 offset-s3" required />
          </div>
          <button type="submit" name="submit" class="btn waves-effect waves-light blue center-align">Login</button>
        </form>
      </div>
      <br /><br />
    </div>
  </div>

  <c:import url="template/footer.jsp" />
</body>
</html>
