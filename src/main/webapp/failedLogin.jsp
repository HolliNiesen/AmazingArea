<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Log In" />
<html>
<c:import url="template/head.jsp" />
<body>
  <c:import url="template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <h4>Invalid email or password. <a href="login">Try again</a>.</h4>
      <br /><br />
    </div>
  </div>

  <c:import url="template/footer.jsp" />
</body>
</html>
