package com.cassiomolin.example.user.api.resource;

import com.cassiomolin.example.user.api.model.QueryAccountResult;
import com.cassiomolin.example.user.api.model.QueryUserResult;
import com.cassiomolin.example.user.domain.Account;
import com.cassiomolin.example.user.domain.User;
import com.cassiomolin.example.user.service.UserService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JAX-RS resource class that provides operations for users.
 */
@RequestScoped
@Path("users")
public class UserResource {

    @Context
    private UriInfo uriInfo;

    @Context
    private SecurityContext securityContext;

    @Inject
    private UserService userService;
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADMIN"})
    public Response getUsers() {

        List<QueryUserResult> queryUserResults = userService.findAll().stream()
                .map(this::toQueryUserResult)
                .collect(Collectors.toList());

        return Response.ok(queryUserResults).build();
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADMIN"})
    public Response getUser(@PathParam("userId") Long userId) {

        User user = userService.findById(userId).orElseThrow(NotFoundException::new);
        QueryUserResult queryUserResult = toQueryUserResult(user);
        return Response.ok(queryUserResult).build();
    }

    /**
     * Maps a {@link User} instance to a {@link QueryUserResult} instance.
     *
     * @param user
     * @return
     */
    private QueryUserResult toQueryUserResult(User user) {
        QueryUserResult queryUserResult = new QueryUserResult();
        queryUserResult.setId(user.getId());
        queryUserResult.setFirstName(user.getFirstName());
        queryUserResult.setLastName(user.getLastName());
        queryUserResult.setUserName(user.getUserName());
        queryUserResult.setAuthorities(user.getAuthorities());
        return queryUserResult;
    }
    
    @GET
    @Path("me")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAuthenticatedUser() {

        Principal principal = securityContext.getUserPrincipal();

        if (principal == null) {
            QueryUserResult queryUserResult = new QueryUserResult();
            queryUserResult.setUserName("anonymous");
            queryUserResult.setAuthorities(new HashSet<>());
            return Response.ok(queryUserResult).build();
        }

        User user = userService.findByUserName(principal.getName());
        QueryUserResult queryUserResult = toQueryUserResult(user);
        return Response.ok(queryUserResult).build();
    }
}