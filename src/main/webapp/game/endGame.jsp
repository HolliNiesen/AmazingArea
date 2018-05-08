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
        <p id="gameBox">
        <h4>
          Great job! You got ${numberRight} right!
        </h4>
        <p>Here are your questions.</p>
        <table class="table">
          <thead>
          <tr>
            <th>Question</th>
            <th>Correct</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="gameQuestion" items="${game.gameQuestions}">
            <tr>
              <td>${gameQuestion.left_number} x ${gameQuestion.right_number} = ${gameQuestion.solution}</td>
              <td><c:if test="gameQuestion.correct">X</c:if></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
    <br /><br />
  </div>

  <c:import url="../template/footer.jsp" />
</body>
</html>
