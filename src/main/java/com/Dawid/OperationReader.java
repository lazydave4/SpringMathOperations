package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OperationReader {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<OperationData> getOperationList() {
        return jdbcTemplate.query("SELECT operation,first,second FROM Operation_Data",
                (rs, rowNum) -> new OperationData(rs.getString("operation"), rs.getInt("first"), rs.getInt("second")));

    }

    public void deleteRecords() {
        jdbcTemplate.execute("DELETE Operation_Data WHERE first<5");
    }

    public void updateRecords(String nameOperation) {

        jdbcTemplate.execute("UPDATE Operation_Data SET first=8,second=7 WHERE operation=" + "'" + nameOperation + "'");

    }

    public List<OperationData> selectRecord() {
        return jdbcTemplate.query("SELECT operation,first,second FROM Operation_Data WHERE first=2 AND second<5 ",
                (rs, rowNum) -> new OperationData(rs.getString("operation"), rs.getInt("first"), rs.getInt("second")));
    }


}
