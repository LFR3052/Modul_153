package ch.lamas.backendlamas.mapper;

import ch.lamas.backendlamas.statistics.models.StatisticResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticMapper implements RowMapper<StatisticResponse> {

    @Override
    public StatisticResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        StatisticResponse response = new StatisticResponse(resultSet.getString("name"),
                resultSet.getInt("number_of_drives"), resultSet.getDouble("delay"));
        return response;
    }
}
