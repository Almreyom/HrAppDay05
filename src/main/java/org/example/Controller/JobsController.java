package org.example.Controller;

import jakarta.ws.rs.core.*;
import org.example.DAO.JobsDAO;
import org.example.Exceptions.DataNotFoundException;
import org.example.FilterDto.JobsDto;
import org.example.FilterDto.JobsFilterDto;
import org.example.Models.Jobs;
import jakarta.ws.rs.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

    @Path("/Jobs")
    public class JobsController {

        JobsDAO dao = new JobsDAO();
        @Context
        UriInfo uriInfo;
        @Context
        HttpHeaders headers;
        @Path("/departments")

            @GET
            @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
            public Response getAllJobs(
                    @BeanParam JobsFilterDto filter
            ) {
                try {
                    GenericEntity<ArrayList<Jobs>> j = new GenericEntity<ArrayList<Jobs>>(dao.selectAlljobs(filter)) {};
                    if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                        return Response
                                .ok(j)
                                .type(MediaType.APPLICATION_XML)
                                .build();
                    }

                    return Response
//                    .ok()
//                    .entity(depts)
//                    .type(MediaType.APPLICATION_JSON)
                            .ok(j, MediaType.APPLICATION_JSON)
                            .build();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


        @GET
        @Path("{deptId}")
        public Response getJobs(@PathParam("Job_Id") int Job_Id) throws SQLException {

            try {
                Jobs j  = dao.selectJob(Job_Id);

                if (j == null) {
                    throw new DataNotFoundException("Job " + Job_Id + "Not found");
                }

                JobsDto Jto = new JobsDto();
                Jto.setJobId(Jto.getJobId());
                Jto.setJobName(Jto.getJobName());
                Jto.setMin_salary(Jto.getMin_salary());

                return Response.ok(Jto).build();
            }
            catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        @DELETE
        @Path("{JobId}")
        public void deleteJobs(@PathParam("JobId") int JobId) {

            try {
                dao.DeleteJob(JobId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        @Consumes(MediaType.APPLICATION_XML)
        public Response setInsertJob(Jobs j) {

            try {
                dao.setInsertJob(j);
                NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
                URI uri = uriInfo.getAbsolutePathBuilder().path(j.getJob_Id()+ "").build();
                return Response
                        .created(uri)
                        .cookie(cookie)
                        .header("Created by", "Wael")
                        .build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{JobId}")
        public void setUpdateJob(@PathParam("JobId") int JobtId, Jobs j) {

            try {
                j.setJob_Id(JobtId);
                dao.setUpdateJob(j);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Path("{Job_Id}/Jobs")
        public JobsController getJobsController() {
            return new JobsController();
        }
    }

