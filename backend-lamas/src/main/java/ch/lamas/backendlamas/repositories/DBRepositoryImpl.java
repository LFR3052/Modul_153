package ch.lamas.backendlamas.repositories;

import ch.lamas.backendlamas.mapper.DateMapper;
import ch.lamas.backendlamas.mapper.StationMapper;
import ch.lamas.backendlamas.mapper.StatisticMapper;
import ch.lamas.backendlamas.mapper.TrainRowMapper;
import ch.lamas.backendlamas.statistics.models.StatisticResponse;
import ch.lamas.backendlamas.trains.models.Ride;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DBRepositoryImpl implements DBRepository {

    public DBRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<Ride> getAllRides(int skippedRows) {
        return template.query(String.format(Statements.selectAllQuery, skippedRows), new TrainRowMapper());
    }

    @Override
    public List<Ride> getAllRidesByStation(int skippedRows, String station) {
        return template.query(String.format(Statements.selectAllByStation, station, skippedRows), new TrainRowMapper());
    }

    @Override
    public List<Ride> getAllRidesByDate(int skippedRows, Date date) {
        return template.query(String.format(Statements.selectAllByDate, date, skippedRows), new TrainRowMapper());
    }

    public List<Date> getAllDates(){
        return template.query(Statements.selectAllDates, new DateMapper());
    }

    @Override
    public List<String> getAllStations() {
        return template.query(Statements.selectAllStations, new StationMapper());
    }

    @Override
    public List<Ride> getStationAndDateResults(String station, Date date, int skippedRows) {
        return template.query(String.format(Statements.selectAllByStationAndDate, date, station, skippedRows), new TrainRowMapper());
    }

    @Override
    public int getTotalResults() {
        return (Integer)template.queryForObject(Statements.selectTotalResults, new HashMap<>(), Integer.class);
    }

    @Override
    public int getStationResults(String station) {
        return (Integer)template.queryForObject(String.format(Statements.selectTotalResultsByStation, station), new HashMap<>(), Integer.class);
    }

    @Override
    public int getDateResults(Date date) {
        return (Integer)template.queryForObject(String.format(Statements.selectTotalResultsByDate, date), new HashMap<>(), Integer.class);
    }

    @Override
    public int getStationAndDateCount(String station, Date date) {
        return (Integer)template.queryForObject(String.format(Statements.selectTotalResultsByStationAndDate, station, date), new HashMap<>(), Integer.class);
    }

    @Override
    public List<StatisticResponse> getDelayPerLine() {
        return template.query(Statements.selectDelayPerLine, new StatisticMapper());
    };

    @Override
    public List<StatisticResponse> getDelayPerStop() {
        return template.query(Statements.selectDelayPerStop, new StatisticMapper());
    };

    @Override
    public List<StatisticResponse> getDelayPerTransporttype() {
        return template.query(Statements.selectDelayPerTransporttype, new StatisticMapper());
    };

    @Override
    public List<StatisticResponse> getAverageDelayPerLine() {
        return template.query(Statements.selectAverageDelayPerLine, new StatisticMapper());
    };

    @Override
    public List<StatisticResponse> getAverageDelayPerStop() {
        return template.query(Statements.selectAverageDelayPerStop, new StatisticMapper());
    };

    @Override
    public List<StatisticResponse> getAverageDelayPerTransporttype() {
        return template.query(Statements.selectAverageDelayPerTransporttype, new StatisticMapper());
    };


}
