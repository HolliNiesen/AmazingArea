<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="template/head.jsp" />
<body>
  <c:import url="template/header.jsp" />

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

  <c:import url="template/footer.jsp" />
</body>
</html>
