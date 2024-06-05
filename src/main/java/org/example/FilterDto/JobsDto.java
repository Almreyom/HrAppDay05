package org.example.FilterDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobsDto {
    private int JobId;
    private String JobName;
    private Double Min_salary;

    private ArrayList<LinkDto> links = new ArrayList<>();

    public JobsDto(int jobId, String jobName, Double min_salary) {
        JobId = jobId;
        JobName = jobName;
        Min_salary = min_salary;
    }

    public JobsDto() {

    }

    public JobsDto(ResultSet rs) throws SQLException {
        JobId = rs.getInt("Job_id");
        JobName = rs.getString("Job_name");
        Min_salary = rs.getDouble("Min_salary");
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public Double getMin_salary() {
        return Min_salary;
    }

    public void setMin_salary(Double min_salary) {
        Min_salary = min_salary;
    }

    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    @Override
    public String toString() {
        return "Job{" +
                "JobId=" + JobId +
                ", JobName='" +JobName + '\'' +
                ", Min_salar=" + Min_salary +
                '}';
    }


}

