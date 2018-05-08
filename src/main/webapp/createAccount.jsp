<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Holli
  Date: 5/7/2018
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="title" value="Create Account" />
<html>
<c:import url="template/head.jsp" />
<body>
  <script src="javascript/createAccount.js" type="text/javascript"></script>
  <c:import url="template/header.jsp" />

  <div class="section no-pad-bot no-pad-top">
    <div class="container main">
      <div class="row center">
        <br />
        <h4 class="header center blue-text">Create Account</h4>
        <form method="POST" action="createAccount">
          <div class="input-field col s12">
            <label for="parentFirstName" class="col offset-s3">First Name</label>
            <input type="text" name="parentFirstName" id="parentFirstName" class="col s6 offset-s3" required />
          </div>
          <div class="input-field col s12">
            <label for="lastName" class="col offset-s3">Last Name</label>
            <input type="text" name="lastName" id="lastName" class="col s6 offset-s3" required />
          </div>
          <div class="input-field col s12">
            <label for="parentEmail" class="col offset-s3">Email</label>
            <input type="email" name="parentEmail" id="parentEmail" class="col s6 offset-s3" required />
          </div>
          <div class="input-field col s12">
            <label for="parentBirthDate" class="col offset-s3">Date of Birth</label>
            <input type="date" name="parentBirthDate" id="parentBirthDate" class="col s6 offset-s3" placeholder="" required />
          </div>
          <div class="input-field col s12">
            <label for="parentPassword" class="col offset-s3">Password</label>
            <input type="password" name="parentPassword" id="parentPassword" class="col s6 offset-s3" required />
            <input type="hidden" name="parentRole" value="parent" />
          </div>
          <div id="children"></div>
          <p id="addChild" class="blue-text left-align col offset-s3">Add Child</p>
          <div class="col s12">
            <button type="submit" name="submit" class="btn waves-effect waves-light blue center-align">Create Account</button>
          </div>
        </form>
      </div>
      <br />
    </div>
  </div>

  <c:import url="template/footer.jsp" />
</body>
</html>
