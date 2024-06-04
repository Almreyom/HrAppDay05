package org.example.JobsFilterDto;

import jakarta.ws.rs.QueryParam;

public class JobsFilterDto {
    private @QueryParam("min_salary") Double min_salary;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Double getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(double min_salary) {
        this.min_salary = min_salary;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}

