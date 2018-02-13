<%@include file="head.jsp"%>
<html>
<body>

<h2>Users</h2>

<form method="GET" action="getUsers">
  <label for="term">First Name</label>
  <input type="text" name="term" id="term" />
  <button type="submit" name="submit" value="search">Search Users</button>
  <button type="submit" name="submit" value="all">All Users</button>
</form>

<hr />

<form method="GET" action="addUserForm">
  <button type="submit">Add User</button>
</form>

</body>
</html>