<%--
  Created by IntelliJ IDEA.
  User: Holli
  Date: 3/19/2018
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <form method="POST" action="j_security_check">
    <label>
      Email<br />
      <input name="j_username" type="text" />
    </label>
    <br /><br />
    <label>
      Password<br />
      <input name="j_password" type="password" />
    </label>
    <button type="submit" name="submit">Login</button>
  </form>
</body>
</html>
