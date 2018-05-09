<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Amazing Area" />
<html>
<c:import url="../template/head.jsp" />
<body>
  <script src="javascript/game.js"></script>
  <c:import url="../template/header.jsp" />

  <div class="section no-pad-bot no-pad-top" id="index-banner">
    <div class="container main center">
      <br />
      <h2 class="header blue-text">Amazing Area!</h2>
      <div class="row center">
        <div id="gameBox">
        <h4>
          Great job! You got ${numberRight} right!
        </h4>
        <p style="font-weight:normal">Here are your questions.</p>
        <c:forEach var="gameQuestion" items="${originalGameQuestions}">
          <ul>
            <li style="font-size:large;font-weight:normal">
                ${gameQuestion.question.leftNumber} x ${gameQuestion.question.rightNumber} = ${gameQuestion.question.solution}
            </li>
          </ul>
        </c:forEach>
      </div>
    </div>
    <br /><br />
  </div>

  <c:import url="../template/footer.jsp" />
</body>
</html>
