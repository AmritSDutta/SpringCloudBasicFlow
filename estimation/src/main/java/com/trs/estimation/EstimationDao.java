package com.trs.estimation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EstimationDao {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public List<TaskEffort> getEfforts(String columnName, String type) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT task," + columnName + " FROM estimation WHERE type= '" + type + "'";

        List<TaskEffort> taskEfforts = new ArrayList();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor() {
                    public List extractData(ResultSet rs) throws SQLException {

                        while (rs.next()) {
                            String name = rs.getString("task");
                            int effort = rs.getInt(columnName);

                            TaskEffort taskEffort = new TaskEffort();
                            taskEffort.setName(name);
                            taskEffort.setEffortInHours(effort);
                            taskEfforts.add(taskEffort);
                        }
                        return taskEfforts;
                    }
                }
        );
        System.out.println(taskEfforts);
        return taskEfforts;
    }


}
