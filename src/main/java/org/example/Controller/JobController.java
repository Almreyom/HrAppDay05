package org.example.Controller;

import org.example.DAO.JobsDAO;
import org.example.Models.Jobs;
import jakarta.ws.rs.*;

import java.util.ArrayList;

    @Path("/Jobs")
    public class JobController {

        JobsDAO dao = new JobsDAO();

        @GET
        public ArrayList<Jobs> getAllJobs() {

            try {
                return dao.selectAlljobs();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @GET
        @Path("{deptId}")
        public Jobs getJobs(@PathParam("deptId") int JobId) {

            try {
                return dao.selectJob(JobId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{JobId}")
        public void deleteDepartment(@PathParam("JobId") int JobId) {

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

