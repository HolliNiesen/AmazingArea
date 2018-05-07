<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Mathtastic Games" />
<html>
<c:import url="template/head.jsp" />
<body>
<c:import url="template/header.jsp" />

<div class="section no-pad-bot no-pad-top" id="index-banner">
  <div class="container main">
    <br /><br />
    <h4 class="header center blue-text">Users</h4>
    <div class="row center">
      <form method="GET" action="getUsers">
        <div class="input-field col s12">
          <label for="term" class="col offset-s3">First Name</label>
          <input type="text" name="term" id="term" class="col s6 offset-s3" />
        </div>
        <button type="submit" name="submit" value="search" class="btn waves-effect waves-light blue">Search Users</button>
        <button type="submit" name="submit" value="all" class="btn waves-effect waves-light blue">All Users</button>
      </form>
    </div>
    <br /><br />
    <div class="row center">
      <form method="GET" action="addUserForm">
        <button type="submit" class="btn-large waves-effect waves-light blue">Add User</button>
      </form>
    </div>
    <br /><br />
  </div>
</div>

<c:import url="template/footer.jsp" />
</body>
</html>
