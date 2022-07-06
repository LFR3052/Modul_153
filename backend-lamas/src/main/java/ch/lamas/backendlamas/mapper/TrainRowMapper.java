package ch.lamas.backendlamas.mapper;

import ch.lamas.backendlamas.trains.models.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainRowMapper implements RowMapper<Ride> {


    @Override
    public Ride mapRow(ResultSet resultSet, int i) throws SQLException {
        Operator operator = new Operator(resultSet.getInt("betreiber_id"), resultSet.getString("betreiber_kuerzel"), resultSet.getString("betreiber_name"));
        Station station = new Station(resultSet.getInt("haltestelle_id"), resultSet.getString("haltestelle_name"));
        Route route = new Route(resultSet.getInt("linie_id"), resultSet.getString("linie_linientext"));
        MeansOfTransportation meansOfTransportation = new MeansOfTransportation(resultSet.getInt("verkehrsmittel_id"), resultSet.getString("verkehrsmittel_name"));
        Ride ride = new Ride(resultSet.getInt("id"), resultSet.getDate("betriebstag"), resultSet.getBoolean("ausfall"), resultSet.getBoolean("zusatzfahrt"),
                resultSet.getTimestamp("ankunft"), resultSet.getTimestamp("ankunftprognose"), PredictionStatus.valueOf(resultSet.getString("ankunftprognosestatus")),
                resultSet.getTimestamp("abfahrt"), resultSet.getTimestamp("abfahrtprognose"),
                PredictionStatus.valueOf(resultSet.getString("abfahrtprognosestatus")), resultSet.getBoolean("durchfahrt"),
                resultSet.getBoolean("ankunftsverspaetung"), resultSet.getBoolean("abfahrtsverspaetung"),
                meansOfTransportation, route, operator, station);
        return ride;
    }
}
