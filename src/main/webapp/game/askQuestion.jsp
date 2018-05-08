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
          <p>
            ${game.gameQuestions[0].question.leftNumber} x ${game.gameQuestions[0].question.leftNumber} =
          </p>
          <form action="startGame">
            <div class="input-field col s12">
              <label for="answer" class="col offset-s3">Answer</label>
              <input name="answer" id="answer" type="number" class="col s6 offset-s3" required />
            </div>
            <br /><br />
            <div class="col offset-s1">
              <button type="submit" class="btn waves-effect waves-light blue">Answer</button>
            </div>
          </form>
        </div>
      </div>
      <br /><br />
    </div>
  </div>

  <c:import url="../template/footer.jsp" />
</body>
</html>
