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
        <p>${numberFact}</p>
        <p>
          ${currentGameQuestion.question.leftNumber} x ${currentGameQuestion.question.rightNumber} = ${currentGameQuestion.question.solution}
        </p>
        <form method="GET" action="askQuestion">
          <button type="submit" class="btn waves-effect waves-light blue">Next Question</button>
        </form>
      </div>
    </div>
    <br /><br />
  </div>
</div>

<c:import url="../template/footer.jsp" />
</body>
</html>
