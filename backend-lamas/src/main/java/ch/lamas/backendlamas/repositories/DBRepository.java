package ch.lamas.backendlamas.repositories;

import ch.lamas.backendlamas.statistics.models.StatisticResponse;
import ch.lamas.backendlamas.trains.models.Ride;

import java.sql.Date;
import java.util.List;

public interface DBRepository {

    List<Ride> getAllRides(int skippedRows);

    List<Ride> getAllRidesByStation(int skippedRows, String station);

    List<Ride> getAllRidesByDate(int skippedRows, Date date);

    List<Date> getAllDates();

    List<String> getAllStations();

    List<Ride> getStationAndDateResults(String station, Date date, int skippedRows);

    int getTotalResults();

    int getStationResults(String station);

    int getDateResults(Date date);

    int getStationAndDateCount(String station, Date date);

    List<StatisticResponse> getDelayPerLine();

    List<StatisticResponse> getDelayPerStop();

    List<StatisticResponse> getDelayPerTransporttype();

    List<StatisticResponse> getAverageDelayPerLine();

    List<StatisticResponse> getAverageDelayPerStop();

    List<StatisticResponse> getAverageDelayPerTransporttype();

}
