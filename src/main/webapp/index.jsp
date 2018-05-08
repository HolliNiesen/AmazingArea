<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Mathtastic Games" />
<html>
<c:import url="template/head.jsp" />
<body>
  <script src="javascript/index.js"></script>
  <c:import url="template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <h2 class="header blue-text">Mathtastic Games!</h2>
      <div class="row">
        <h4 class="blue-text">Fun Fact About Numbers:</h4>
        <br />
        <div class="col s2"></div>
        <div class="col s8 center-align">
          <p id="mathFact"></p>
        </div>
        <div class="col s2"></div>
      </div>
      <br /><br />
    </div>
  </div>

  <c:import url="template/footer.jsp" />
</body>
</html>
