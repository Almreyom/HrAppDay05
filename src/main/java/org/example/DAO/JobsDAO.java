package org.example.DAO;

import org.example.JobsFilterDto.JobsFilterDto;
import org.example.Models.Jobs;

import java.sql.*;
import java.util.ArrayList;
    public class JobsDAO {

        private static final String URL =  "jdbc:sqlite:C:\\Users\\dev\\Downloads\\hr.db";
        private static final String SELECT_ALL_JOBS = "select * from JOBsi";
        private static final String SELECT_JOBS_WITH_LOC = "select * from departments where location_id = ?";
        private static final String SELECT_JOBS_WITH_LOC_PAGINATION = "select * from jobs where min_salary = ? order by job_id limit ? offset ? ";
        private static final String SELECT_JOBS_WITH_PAGINATION = "select * from jobs order by job_id limit ? offset ?";
        private static final String SELECT_ONE_JOBS = "select * from JOBS where job_id = ?";
        private static final String INSERT_JOBS = "insert into jobs values (?, ?, ?,?)";
        private static final String UPDATE_JOBS = "update jobs set job_name = ?, job_id = ? where job_id = ?";
        private static final String DELETE_JOBS = "delete from jobs where jobd_id = ?";

        public void setInsertJob(Jobs j) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(INSERT_JOBS);
            st.setInt(1, j.getJob_Id());
            st.setString(2, j.getJob_title());
            st.setDouble(3, j.getMin_salary());
            st.setDouble(4, j.getMax_salary());
            st.executeUpdate();
        }

        public void setUpdateJob(Jobs j) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(UPDATE_JOBS);
            st.setInt(1, j.getJob_Id());
            st.setString(2, j.getJob_title());
            st.setDouble(3, j.getMin_salary());
            st.setDouble(4, j.getMax_salary());
            st.executeUpdate();
        }

        public void DeleteJob(int jobId) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(DELETE_JOBS);
            st.setInt(1, jobId);
            st.executeUpdate();
        }

        public Jobs selectJob(int JobId) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOBS);
            st.setInt(1, JobId);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return new Jobs(rs);
            }
            else {
                return null;
            }
        }

//        public ArrayList<Jobs> selectAlljobs(int offset , double Max_salary, double Min_salary) throws SQLException, ClassNotFoundException {
//            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection(URL);
//            PreparedStatement st;
//            if(Min_salary!= null && JobsFilterDto.getLimit()!= null){
//                st = conn.prepareStatement(SELECT_JOBS_WITH_LOC_PAGINATION);
//                st.setInt(1,filter.getMin_salary());
//                st.setInt(2,fitler.getLimit());
//                st.setInt(3,filter.getOffset());
//            } else if(filter.getMin_salary() != null) {
//                st = conn.prepareStatement(SELECT_JOBS_WITH_LOC);
//                st.setInt(1, getMin_salary() );
//            }
//            else if(filter.getLimit() != null) {
//                st = conn.prepareStatement(SELECT_JOBS_WITH_PAGINATION);
//                st.setInt(1, filter.getLimit());
//                st.setInt(2, filter.getOffset());
//            }
//            else {
//                st = conn.prepareStatement(SELECT_ALL_JOBS);
//            }
//            ResultSet rs = st.executeQuery();
//            ArrayList<Jobs> Jobs = new ArrayList<>();
//            while (rs.next()) {
//                Jobs.add(new Jobs(rs));
//            }
//
//            return Jobs;
//        }

        public ArrayList<Jobs> selectAlljobs(JobsFilterDto filter) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st;
            if(filter.getMin_salary() != null && filter.getLimit()!= null){
                st = conn.prepareStatement(SELECT_JOBS_WITH_LOC_PAGINATION);
                st.setDouble(1,filter.getMin_salary());
                st.setInt(2,filter.getLimit());
                st.setInt(3,filter.getOffset());
            } else if(filter.getMin_salary() != null) {
                st = conn.prepareStatement(SELECT_JOBS_WITH_LOC);
                st.setDouble(1, filter.getMin_salary() );
            }
            else if(filter.getLimit() != null) {
                st = conn.prepareStatement(SELECT_JOBS_WITH_PAGINATION);
                st.setInt(1, filter.getLimit());
                st.setInt(2, filter.getOffset());
            }
            else {
                st = conn.prepareStatement(SELECT_ALL_JOBS);
            }
            ResultSet rs = st.executeQuery();
            ArrayList<Jobs> Jobs = new ArrayList<>();
            while (rs.next()) {
                Jobs.add(new Jobs(rs));
            }

            return Jobs;
        }

    }


