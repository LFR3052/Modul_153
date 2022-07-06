package ch.lamas.backendlamas.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateMapper implements RowMapper<Date> {

    @Override
    public Date mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate("betriebstag");
    }
}
