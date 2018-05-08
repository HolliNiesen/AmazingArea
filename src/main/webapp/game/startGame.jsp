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
          <form action="startGame">
            <div class="input-field col s12">
              <label class="col offset-s1">
                <input name="hardQuestions" id="hardQuestions" type="checkbox" class="col offset-s1" />
                <span class="black-text">Hard Questions</span>
              </label>
            </div>
            <br /><br />
            <div class="col offset-s1">
              <button type="submit" class="btn waves-effect waves-light blue">Start Game</button>
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
