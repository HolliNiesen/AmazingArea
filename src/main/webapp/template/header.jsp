<%--
  Created by IntelliJ IDEA.
  User: Holli
  Date: 4/30/2018
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="light-blue lighten-1" role="navigation">
  <div class="nav-wrapper container"><a id="logo-container" href="/amazing-area" class="brand-logo">MG!</a>
    <ul class="right">
      <% if (request.getRemoteUser() == null) { %>
        <li><a href="login">Log In</a></li>
        <li><a href="createAccountForm">Create Account</a></li>
      <% } else { %>
        <li><a href="loadGame">Play Amazing Area</a></li>
        <li><a href="myAccount">My Account</a></li>
        <li><a href="logout">Log Out</a></li>
      <% } %>
    </ul>
  </div>
</nav>
