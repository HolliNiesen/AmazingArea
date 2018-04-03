package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Role;
import com.mathtasticgames.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
@Path("/users")
public class Users {

    public Dao dao = new Dao(User.class);

    @GET
    @Produces("text/html")
    public Response getAllUsers() {
        ArrayList<User> users = (ArrayList<User>) dao.getAll();
        String html = "<html><body><table><tr><th>Name</th><th>Age</th><th>Email</th><th>Role</tr>";

        for (User user : users) {
            html += getUserTableRow(user);
        }
        html += "</table></body></html>";

        return Response.status(200).entity(html).build();
    }

    @GET
    @Produces("text/html")
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {
        User user = (User) dao.getById(id);

        String html = "<html><body><table><tr><th>Name</th><th>Age</th><th>Email</th><th>Role></tr>";
        html += getUserTableRow(user);
        html += "</table></body></html>";

        return Response.status(200).entity(html).build();
    }

    private String getUserTableRow(User user) {
        String html = "<tr><td>" + user.getFirstName() + " " + user.getAccount().getLastName() + "</td>"
                + "<td>" + user.getEmail() + "</td>"
                + "<td>" + user.getAge() + "</td>";

        for (Role role : user.getRoles()) {
            html += "<td>" + role.getRoleName() + "</td>";
        }
        html += "</tr>";

        return html;
    }
}
