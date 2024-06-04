package org.example.Controller;

import jakarta.ws.rs.core.MediaType;
import org.example.DAO.JobsDAO;
import org.example.JobsFilterDto.JobsFilterDto;
import org.example.Models.Jobs;
import jakarta.ws.rs.*;

import java.awt.*;
import java.util.ArrayList;

    @Path("/Jobs")
    public class JobsController {

        JobsDAO dao = new JobsDAO();

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public ArrayList<Jobs> getAllJobs(@BeanParam JobsFilterDto filter) {
            try {
                return dao.selectAlljobs(filter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @GET
        @Path("{jobId}")
        public Jobs getJobs(@PathParam("jobId") int JobId) {

            try {
                return dao.selectJob(JobId);
            } catch (Exception e) {
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
        public void setInsertJob(Jobs j) {

            try {
                dao.setInsertJob(j);
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


    }

