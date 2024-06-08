package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.example.dto.EmployeeDto;

@Singleton
@Path("myresource")
public class MyResource {

    @Context HttpHeaders headers;
    @Context UriInfo uriInfo;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }


    @GET
    @Path("/employees/{employee_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto getDate(@PathParam("employee_id") EmployeeDto employee_id) {
        return employee_id;
    }

}