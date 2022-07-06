package ch.lamas.backendlamas.trains;

import ch.lamas.backendlamas.trains.models.Ride;

import java.sql.Date;
import java.util.List;

public interface TrainService {

    List<Ride> getAllTrains(String page);

    List<Ride> getTrainsByStation(String station, String page);

    List<Ride> getTrainsByDate(String date, String page);

    List<Ride> getTrainsByStationAndDate(String station, String date, String page);

    List<String> getAllStations();

    List<Date> getAllDates();

    Integer getTotalResults();

    Integer getDateResults(String date);

    Integer getStationResults(String station);

    Integer getStationAndOrDateResults(String station, String date);
}
