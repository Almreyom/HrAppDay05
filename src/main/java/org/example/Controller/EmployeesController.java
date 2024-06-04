package org.example.Controller;


import org.example.DAO.EmployeesDAO;
import org.example.DAO.JobsDAO;
import org.example.Models.Employees;
import org.example.Models.Jobs;
import jakarta.ws.rs.*;

import java.util.ArrayList;

@Path("/Employees")
public class EmployeesController {

    EmployeesDAO dao = new EmployeesDAO();

    @GET
    public ArrayList<Employees> getAllEmployess() {

        try {
            return dao.selectEmployee();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{EmptId}")
    public Employees getEmployee(@PathParam("empId") int EmployeeId) {

        try {
            return dao.selectEmployee(EmployeeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{EmpId}")
    public void deleteEmployee(@PathParam("EmpId") int EmployeeId) {

        try {
            dao.DeleteEmployee(EmployeeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public void setInsertEmployee(Employees e) {

        try {
            dao.setInsertEmployee(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{EmpId}")
    public void setUpdateEmployee(@PathParam("empId") int EmpId, Employees e) {

        try {
            e.setEmployeeID(EmpId);
            dao.setUpdateEmployee(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
